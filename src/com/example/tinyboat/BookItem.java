package com.example.tinyboat;

import android.graphics.Bitmap;

public class BookItem 
{
    private Bitmap imageId;
    private  String bookName;
    private String author;
    
   
    public String getName()
    {
    	return bookName;
    }
    
    public void setName(String bookName)
    {
    	this.bookName=bookName;
    }
    
    public String getAuthor()
    {
    	return author;
    }
    
    public void setAuthor(String author)
    {
    	this.author=author;
    }
    
    public Bitmap getImageId()
    {
    	return imageId;
    }
    
    public void setImageId(Bitmap imageId)
    {
    	this.imageId=imageId;
    }
    
}
