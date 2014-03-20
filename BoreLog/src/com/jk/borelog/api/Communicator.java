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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jk.borelog.common.Globals;
import com.jk.borelog.common.NetworkConnectivityManager;
import com.jk.borelog.models.AdminInfoItem;
import com.jk.borelog.models.LastDayBoreHoleInfo;
import com.jk.borelog.models.ProjectInfoItem;
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
			 loginResponseList.add(results);
			 if(results.response.equalsIgnoreCase("1")){
				 UserInfo userInfo=new UserInfo(innerObject.getJSONObject("UserInfo"));				 
				 loginResponseList.add(userInfo);
			 }
			
			 return loginResponseList;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

		}
	
	/**
	 * @param userGUID
	 */
	public ArrayList<Object> getProjectList(String userGUID) {
		
		JSONObject userDetails=new JSONObject();
		String url=Globals.baseURL+"GetProjectBoreholeInfo";
		try {
			userDetails.put("UserGUID", userGUID);
			JSONObject loginResponse=PostRequest.post(url, userDetails);
			JSONObject innerObject=new JSONObject(loginResponse.get("d").toString());
			ArrayList<Object>responseList=new ArrayList<Object>();
			Results results=new Results(innerObject.getJSONObject("Result"));
			JSONArray projectHoleInfoArray=innerObject.getJSONArray("ProjectInfoItemColl");
			ArrayList<ProjectInfoItem> projectInfoItemList=new ArrayList<ProjectInfoItem>();
			for (int i = 0; i < projectHoleInfoArray.length(); i++) {
				ProjectInfoItem projectInfoItem=new ProjectInfoItem(projectHoleInfoArray.getJSONObject(i));
				projectInfoItemList.add(projectInfoItem);
			}
			responseList.add(results);
			responseList.add(projectInfoItemList);
			return responseList;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
	/**
	 * 
	 */
	public ArrayList<Object> getAdminLookupValues() {
		
		String url=Globals.baseURL+"GetAdminLookupValues";
		try {
			
			JSONObject loginResponse=PostRequest.post(url, new JSONObject());
			JSONObject innerObject=new JSONObject(loginResponse.get("d").toString());
			ArrayList<Object>responseList=new ArrayList<Object>();
			Results results=new Results(innerObject.getJSONObject("Result"));
			JSONArray adminInfoItemArray=innerObject.getJSONArray("AdminInfoItemColl");
			ArrayList<AdminInfoItem> adminInfoItemList=new ArrayList<AdminInfoItem>();
			for (int i = 0; i < adminInfoItemArray.length(); i++) {
				AdminInfoItem adminInfoItem=new AdminInfoItem(adminInfoItemArray.getJSONObject(i));
				adminInfoItemList.add(adminInfoItem);
				Log.i("Communicator", "**** admin info ="+ adminInfoItem.moduleName);
			}
			Log.i("Communicator", "**** admin list size ="+ adminInfoItemList.size());
			responseList.add(results);
			responseList.add(adminInfoItemList);
			return responseList;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 
	 */
	public ArrayList<Object> getLastDayBoreHoleInfo(String contractGuid, String boreHoleNo) {
		JSONObject boreHoleDetails=new JSONObject();
		String url=Globals.baseURL+"GetLastDayBoreholeInfo";
		try {
			boreHoleDetails.put("ContractGUID", contractGuid);
			boreHoleDetails.put("BoreholeNo", boreHoleNo);
			JSONObject loginResponse=PostRequest.post(url, boreHoleDetails);
			JSONObject innerObject=new JSONObject(loginResponse.get("d").toString());
			ArrayList<Object>responseList=new ArrayList<Object>();
			Results results=new Results(innerObject.getJSONObject("Result"));
			LastDayBoreHoleInfo lastDayBoreHoleInfo=new LastDayBoreHoleInfo(innerObject.getJSONObject("LastDayBHInfo"));
			Log.i("Communicator", "**** lasDayInsituLogItemList size ="+ lastDayBoreHoleInfo.lasDayInsituLogItemList.size());
			responseList.add(results);
			responseList.add(lastDayBoreHoleInfo);
			return responseList;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
}
