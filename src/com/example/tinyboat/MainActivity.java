package com.example.tinyboat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
		
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
		imageIcon=(ImageView)findViewById(R.id.main_activity_pic);
		search=(Button)findViewById(R.id.search_new_book);
		menu=(Button)findViewById(R.id.app_menu);
		appName=(TextView)findViewById(R.id.app_name);
		adapter=new BookItemAdapter(MainActivity.this,R.layout.my_book_item,myBookList);
		listView=(ListView)findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
