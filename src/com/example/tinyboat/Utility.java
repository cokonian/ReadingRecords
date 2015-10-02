package com.example.tinyboat;

import org.json.JSONException;
import org.json.JSONObject;

public class Utility 
{
    public synchronized static void handleBookItemsResponse(BookDB bookDB,String response)
    {
    	try{
    		JSONObject jsonObject=new JSONObject(response);
    		JSONObject bookInfo=jsonObject.getJSONObject("rating");
    		BookItem bookItem=new BookItem();
    		String bookName=bookInfo.getString("title");
    		bookItem.setName(bookName);
    		String bookAuthor=bookInfo.getString("author");
    		bookItem.setAuthor(bookAuthor);
    		String bookImageAddress=bookInfo.getString("image");
    		byte[] buffer=HttpUtil.downloadImage(bookImageAddress);
    		bookItem.setImageId(buffer);
    		bookDB.saveBookItem(bookItem);    		
    	}catch(JSONException e)
    	{
    		e.printStackTrace();
    	}
    }

	
}
