package com.example.tinyboat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SearchActivity extends Activity implements OnClickListener
{
    private EditText editISBN;
    private Button search;
    private Button back;
    private RelativeLayout title;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.search_book_layout);
		title=(RelativeLayout)findViewById(R.id.search_title1);
		editISBN=(EditText)findViewById(R.id.edit);
		search=(Button)findViewById(R.id.search_isbn);
		back=(Button)findViewById(R.id.title_back);
		search.setOnClickListener(this);
		back.setOnClickListener(this);
		
    }

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.title_back:
			Intent i=new Intent(SearchActivity.this,MainActivity.class);
			startActivity(i);
			finish();
			break;
		case R.id.search_isbn:
			String isbnCode=editISBN.getText().toString();
			Intent intent=new Intent(SearchActivity.this,MainActivity.class);
			intent.putExtra("isbn", isbnCode);
			startActivity(intent);
			finish();
			break;
		default:
			break;
		}
			
	}
}
