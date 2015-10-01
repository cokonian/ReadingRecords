package com.example.tinyboat;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookItemAdapter extends ArrayAdapter<BookItem> 
{
    private int resourceId;
    
	public BookItemAdapter(Context context, int resource, List<BookItem> objects) 
	{
		super(context, resource, objects);
		resourceId=resource;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent)
	{
		BookItem book=getItem(position);
		View view=LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView bookImage=(ImageView)view.findViewById(R.id.my_book_image);
		TextView bookName=(TextView)view.findViewById(R.id.my_book_name);
		TextView bookAuthor=(TextView)view.findViewById(R.id.my_book_author);
		ImageView toDetail=(ImageView)view.findViewById(R.id.book_item_to_detail);
		bookImage.setImageResource(book.getImageId());
		bookName.setText(book.getName());
		bookAuthor.setText(book.getAuthor());
		toDetail.setImageResource(R.drawable.ic_chevron_right_black_36dp);
		return view;
	}

}
