package com.jk.borelog.api;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jk.borelog.common.Logger;


import android.util.Log;


public class GetRequest {
	/**
	 * 
	 */
	static JSONObject res = new JSONObject();
	static String TAG = "PostRequest";

	/**
	 * convert response from url into  a Json object
	 * 
	 * @return JSON object
	 * */
	public static JSONObject get(final String url) {

		try {  
		
			Logger.show(Log.INFO, TAG,
					"URL " +url);
			HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters,
					15000);
			HttpConnectionParams.setSoTimeout(httpParameters,
					15000);
			HttpClient client = new DefaultHttpClient(httpParameters);
	        HttpGet request = new HttpGet();
	        request.setURI(new URI(url));
	        HttpResponse response = client.execute(request);
	        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	        InputStream ips  = response.getEntity().getContent();
	        String responseString = response.toString();
			responseString = intputStreamToStringConvertor(ips);
			Logger.show(Log.INFO, TAG, "server response: " + responseString);
			JSONObject jObject = new JSONObject(responseString);
			res = jObject;
	        }
	        else{
	        	
	        	Logger.show(Log.INFO, "Errrrrrrrrrrrr", response.getStatusLine().getStatusCode()+"");
	        	
	        }
			
		} catch (NullPointerException e) {
			Logger.show(e);
			res = null;
		} catch (UnsupportedEncodingException e) {
			Logger.show(e);
			res = null;
		} catch (ClientProtocolException e) {
			Logger.show(e);
		} catch (IOException e) {
			Logger.show(e);
			res = null;
		} catch (JSONException e) {
			Logger.show(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * convert response from url into string
	 * @param url
	 * @return
	 */
	public static String getRequestModels(final String url) {
		String responseString=null;
		try {  
		
			Logger.show(Log.INFO, TAG,
					"URL " +url);
			HttpClient client = new DefaultHttpClient();
	        HttpGet request = new HttpGet();
	        request.setURI(new URI(url));
	        HttpResponse response = client.execute(request);
	        InputStream ips  = response.getEntity().getContent();
	        responseString = response.toString();
			responseString = intputStreamToStringConvertor(ips);
			
		} catch (NullPointerException e) {
			Logger.show(e);
			res = null;
		} catch (UnsupportedEncodingException e) {
			Logger.show(e);
			res = null;
		} catch (ClientProtocolException e) {
			Logger.show(e);
		} catch (IOException e) {
			Logger.show(e);
			res = null;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseString;
	}
	
	/** Converting InputStream to string */
	private static String intputStreamToStringConvertor(InputStream inputStream) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"), 800);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			inputStream.close();
			return sb.toString();
		} catch (NullPointerException e) {
			Logger.show(e);
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}



}
