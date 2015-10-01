package com.example.tinyboat;

public class BookItem 
{
    private int imageId;
    private  String bookName;
    private String author;
    
    public BookItem(String bookName,String author,int imageId)
    {
    	this.bookName=bookName;
    	this.author=author;
    	this.imageId=imageId;
    }
    
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
    
    public int getImageId()
    {
    	return imageId;
    }
    
    public void setImageId(int imageId)
    {
    	this.imageId=imageId;
    }
    
}
