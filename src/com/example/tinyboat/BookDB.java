package com.example.tinyboat;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BookDB 
{
    public static final String DB_NAME="my_books";
    public static final int VERSION=1;
    private static BookDB bookDB;
    private SQLiteDatabase db;
    
    private BookDB(Context context)
    {
    	BookDatabaseHelper dbHelper=new BookDatabaseHelper(context,DB_NAME,null,VERSION);
    	db=dbHelper.getWritableDatabase();
    }
    
    //获取BookDB的实例
    public synchronized static BookDB getInstance(Context context)
    {
    	if(bookDB==null)
    	{
    		bookDB=new BookDB(context);
    	}
    	return bookDB;
    }
    
    //将BookItem实例存入数据库
    public void saveBookItem(BookItem bookItem)
    {
    	if(bookItem!=null)
    	{   
    		ByteArrayOutputStream os = new ByteArrayOutputStream();  
    		bookItem.getImageId().compress(Bitmap.CompressFormat.JPEG,100,os);
    		ContentValues values=new ContentValues();
    		values.put("name", bookItem.getName());
    		values.put("author", bookItem.getAuthor());
    		values.put("image", os.toByteArray());
    		db.insert("Book", null, values);
    	}
    }
    
    //从数据库中读取书籍信息 ：书名name 作者author 封面image；
    public List<BookItem> loadBookItem()
    {
    	List<BookItem> list=new ArrayList<BookItem>();
    	Cursor cursor=db.query("Book", null, null, null, null, null, null, null);
    	if(cursor.moveToFirst())
    	{
    		do {
    			BookItem bookItem=new BookItem();
    			Bitmap bmpout = BitmapFactory.decodeByteArray(cursor.getBlob(cursor.getColumnIndex("image")), 0, cursor.getBlob(cursor.getColumnIndex("image")).length);
    			bookItem.setName(cursor.getString(cursor.getColumnIndex("name")));
    			bookItem.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
    			bookItem.setImageId(bmpout);
    			list.add(bookItem);
    		}while(cursor.moveToNext());
    	}
    	return list;
    }
}
