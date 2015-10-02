package com.example.tinyboat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDatabaseHelper extends SQLiteOpenHelper
{
	public static final String CREATE_BOOK="create table Book("
    		+"id integer primary key autoincrement,"
    		+"name text"
    		+"author text"
    		+"image blob)";
	
	public BookDatabaseHelper(Context context, String name, CursorFactory factory, int version) 
	{
		super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(CREATE_BOOK);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		
	}
}
