package com.example.tinyboat;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpUtil 
{
    public static void sendHttpRequest(final String address,final HttpCallBackListener listener)
    {
    	new Thread(new Runnable()
    	{
			@Override
			public void run() {
				HttpURLConnection connection=null;
				try{
					URL url=new URL(address);
					connection=(HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in=connection.getInputStream();
					BufferedReader reader=new BufferedReader(new InputStreamReader(in));
					StringBuilder response=new StringBuilder();
					String line;
					while((line=reader.readLine())!=null)
					{
						response.append(line);
						Log.e("this step?", line);
					}
				}catch(Exception e)
				{
					if(listener!=null)
					{
						listener.onError(e);
					}
				}finally{
					if(connection!=null)
					{
						connection.disconnect();
					}
				}
			}
    	}).start();
    }
    
    public static byte[] downloadImage(final String address)
    {    	
				HttpURLConnection connection=null;
				try{
					URL url=new URL(address);
					connection=(HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setDoInput(true);
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
			        byte[] data = new byte[1000];  
			        int count = -1;  
					if(connection.getResponseCode()==200)
					{
						InputStream is = connection.getInputStream();
						while((count = is.read(data,0,1000)) != -1)  
					    outStream.write(data, 0, count); 
						data=null;
						is.close();
						return outStream.toByteArray();		
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		return null;	
    }
}
