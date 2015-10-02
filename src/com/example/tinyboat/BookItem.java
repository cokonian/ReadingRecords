package com.example.tinyboat;

public class BookItem 
{
    private byte[] imageId;
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
    
    public byte[] getImageId()
    {
    	return imageId;
    }
    
    public void setImageId(byte[] imageId)
    {
    	this.imageId=imageId;
    }
    
}
