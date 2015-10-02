package com.example.tinyboat;

public interface HttpCallBackListener 
{
    void onFinish(String response);
    void onError(Exception e);
}
