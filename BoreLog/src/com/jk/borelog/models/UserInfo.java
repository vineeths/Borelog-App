/**
 * 
 *
 *
 */
package com.jk.borelog.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Linson
 *
 */
public class UserInfo {
	
	/***** Variables ****/
	
	public String userGUID;
	public String userName;
	public String userID;
	public String userEmail;
	public String userMbileNo;
	public String userRights;
	
	/***** JSON KEYS *****/
	public static final String userGUID_KEY="UserGUID";
	public static final String userName_KEY="UserName";
	public static final String userID_KEY="UserID";
	public static final String userEmail_KEY="UserEmail";
	public static final String userMbileNo_KEY="UserMobileNo";
	public static final String UserRights_KEY="UserRights";
	
	
	/*** DB ***/
	public static final String tableName="UserInfo";
	 public static final String createTableQuery =
	            "CREATE TABLE " + tableName + " (" +
	                        userGUID_KEY + " TEXT PRIMARY KEY, " +
	                        userName_KEY + " TEXT, " +
	                        userID_KEY + " TEXT, " +
	                        userEmail_KEY + " TEXT, " +
	                        userMbileNo_KEY + " TEXT, " +
	                        UserRights_KEY + "TEXT);";
	/**
	 * Constructor to set all the values from json object 
	 * @throws JSONException 
	 */
	public UserInfo(JSONObject jsonObject) throws JSONException {
		
			this.userGUID=jsonObject.getString(userGUID_KEY);
			this.userName=jsonObject.getString(userName_KEY);
			this.userID=jsonObject.getString(userID_KEY);
			this.userEmail=jsonObject.getString(userEmail_KEY);
			this.userMbileNo=jsonObject.getString(userMbileNo_KEY);
			this.userRights=jsonObject.getString(UserRights_KEY);
		
	}
	
	
	
	
	

}
