/**
 *
 *
 */
package com.jk.borelog.api;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.jk.borelog.common.Globals;
import com.jk.borelog.common.NetworkConnectivityManager;
import com.jk.borelog.models.Results;
import com.jk.borelog.models.UserInfo;

import android.content.Context;
import android.util.Log;


/**
 * @author Linson
 *
 * This class will handle the functions which communicate with the server
 */
public class Communicator {

	Context context;
	NetworkConnectivityManager connectivityManager;
	public static String TAG="Communicator";
	public String appendUrl;
	public Communicator(Context context) {

		this.context = context;
		connectivityManager=new NetworkConnectivityManager(context);
	}
	/**
	 * @param userName
	 * @param password
	 */
	public ArrayList<Object> login(String userName, String password) {
		
		 JSONObject loginDetails = new JSONObject();
		 String url=Globals.baseURL+"LoginValidate";
		 ArrayList<Object>loginResponseList=new ArrayList<Object>();
		 try {
			loginDetails.put("UserID", userName);
			 loginDetails.put("Password", password);
			 JSONObject loginResponse=PostRequest.post(url, loginDetails);
			 JSONObject innerObject=new JSONObject(loginResponse.get("d").toString());
			 Results results=new Results(innerObject.getJSONObject("Result"));
			 UserInfo userInfo=new UserInfo(innerObject.getJSONObject("UserInfo"));
			 loginResponseList.add(results);
			 loginResponseList.add(userInfo);
			 return loginResponseList;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

		}

	
}
