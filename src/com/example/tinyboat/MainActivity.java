package com.example.tinyboat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
		
	private RelativeLayout mainTitle;
	private ImageView imageIcon;
	private Button search;
	private Button menu;
	private TextView appName;
	
	
	private List<BookItem> myBookList=new ArrayList<BookItem>();
	private ListView listView;
	private BookItemAdapter adapter;
	private BookDB bookDB;
	private ProgressDialog progressDialog;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mainTitle=(RelativeLayout)findViewById(R.id.main_title);
		imageIcon=(ImageView)findViewById(R.id.main_activity_pic);
		search=(Button)findViewById(R.id.search_new_book);
		menu=(Button)findViewById(R.id.app_menu);
		appName=(TextView)findViewById(R.id.app_name);
		adapter=new BookItemAdapter(MainActivity.this,R.layout.my_book_item,myBookList);
		listView=(ListView)findViewById(R.id.list_view);		
		search.setOnClickListener(this);
		menu.setOnClickListener(this);
		Intent intent=getIntent();
		if(intent.getStringExtra("isbn")!=null)
		{   
			bookDB=BookDB.getInstance(this);
			String isbnCode=intent.getStringExtra("isbn");
			Log.e("ISBNCode", isbnCode);
			queryFromServer(isbnCode);
			myBookList=bookDB.loadBookItem();
			listView.setAdapter(adapter);
		}

		
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.search_new_book:
			Intent intent=new Intent(MainActivity.this,SearchActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.app_menu:
			break;			
		default:
			break;
		}
	}
	
	private void queryFromServer(String isbnCode) 
	{   
		String address="";
	    if(!TextUtils.isEmpty(isbnCode))
	    {
	    	address="http://api.douban.com/v2/book/isbn/:"+isbnCode;
	    }
	    showProgressDialog();
	    HttpUtil.sendHttpRequest(address, new HttpCallBackListener(){
	    	@Override
			public void onFinish(String response) {
				Utility.handleBookItemsResponse(MainActivity.this,bookDB, response);
				runOnUiThread(new Runnable(){
					@Override
					public void run() {
						closeProgressDialog();
					}		
					
				});
			}
			@Override
			public void onError(Exception e) {
				runOnUiThread(new Runnable(){
					@Override
					public void run() {
						closeProgressDialog();
						Toast.makeText(MainActivity.this, "¼ÓÔØÊ§°Ü¡£¡£¡£", Toast.LENGTH_SHORT).show();
					}		
					
				});				
			}
	    	
	    });
	}

	private void showProgressDialog() {
		if(progressDialog==null)
		{
			progressDialog=new ProgressDialog(this);
			progressDialog.setMessage("ÕýÔÚËÑË÷¡£¡£¡£");
			progressDialog.setCanceledOnTouchOutside(false);
		}
		progressDialog.show();
	}
	
	private void closeProgressDialog() {
		if(progressDialog!=null)
		{
			progressDialog.dismiss();
		}
	}	
}
