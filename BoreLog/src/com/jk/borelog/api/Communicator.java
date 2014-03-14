/**
 *
 *
 */
package com.jk.borelog.api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.jk.borelog.common.NetworkConnectivityManager;

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
	public void login(String userName, String password) {
		try {
		 JSONObject loginDetails = new JSONObject();
		 loginDetails.put("UserID", userName);
		 loginDetails.put("Password", password);

//         JSONObject j = new JSONObject();
//         j.put("memberDetails", loginDetails);

      //Instead of "http://www.xxx.com/service/xxx.asmx/" add your ASMX link
         
         String url = "http://203.211.146.160/borelogmobile/BoreholeLog.asmx/LoginValidate";

         HttpClient httpclient = new DefaultHttpClient();
         HttpPost request = new HttpPost(url);

         StringEntity s = new StringEntity(loginDetails.toString(), "UTF-8");

         s.setContentType("application/json;charset=UTF-8");
         request.setHeader("Accept", "application/json");
         request.setHeader("Content-Type", "application/json; charset=utf-8");
         request.setEntity(s);

         HttpResponse response = httpclient.execute(request);

         int i = response.getStatusLine().getStatusCode();

         System.out.println("StatusCode "+i);

         if (response.getStatusLine().getStatusCode() == 200)
         {
             HttpEntity entity = response.getEntity();
             String json = EntityUtils.toString(entity);
             Log.v("response", json);
         }
		}
		 catch (Exception e) {
             e.printStackTrace();
            Log.v("Exception", e.toString());
         }
		}

	
}
