package com.example.tinyboat;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class Utility 
{
    public static void handleBookItemsResponse(Context context,BookDB bookDB,String response)
    {
    	try{
    		JSONObject bookInfo=new JSONObject(response);    		
    		String bookName=bookInfo.getString("title");
    		Log.e("bookTitle", bookName);
    		String bookAuthor=bookInfo.getString("author");
    		Log.e("bookAuthor", bookAuthor);    		
    		String bookImageAddress=bookInfo.getString("image");
    		Log.e("imageAddress", bookImageAddress);
    		byte[] buffer=HttpUtil.downloadImage(bookImageAddress);   		
    		saveData(context ,bookDB,bookName,bookAuthor,buffer);
    	}catch(JSONException e)
    	{
    		e.printStackTrace();
    	}
    }

	public static boolean saveData(Context context, BookDB bookDB, String bookName, String bookAuthor, byte[] buffer) 
	{
		BookItem bookItem=new BookItem();	
		bookItem.setName(bookName);
		bookItem.setAuthor(bookAuthor);
		bookItem.setImageId(buffer);
		bookDB.saveBookItem(bookItem);
		return true; 
	}

	
}
