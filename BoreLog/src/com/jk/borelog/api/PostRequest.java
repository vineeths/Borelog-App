package com.jk.borelog.api;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.jk.borelog.common.Logger;


import android.util.Log;


public class PostRequest {
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
	public static JSONObject post(final String url,JSONObject params) {
		String responseString="";
		try {  
			
			HttpClient httpclient = new DefaultHttpClient();
	         HttpPost request = new HttpPost(url);
	         if(params!=null){
	        	 StringEntity s = new StringEntity(params.toString(), "UTF-8");
		         s.setContentType("application/json;charset=UTF-8");
		         request.setHeader("Accept", "application/json");
		         request.setHeader("Content-Type", "application/json; charset=utf-8");
		         request.setEntity(s);
	         }
	         
	         

	         HttpResponse response = httpclient.execute(request);

	        	         

	         if (response.getStatusLine().getStatusCode() == 200)
	         {
	             HttpEntity entity = response.getEntity();
	             responseString = EntityUtils.toString(entity);
	             Log.v("response", responseString);
	         }
			
			
			
			JSONObject jObject = new JSONObject(responseString);
			res = jObject;
	       
			
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
		}
		return res;
	}
	
}
