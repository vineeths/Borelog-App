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
	private String userGUID_KEY="UserGUID";
	private String userName_KEY="UserName";
	private String userID_KEY="UserID";
	private String userEmail_KEY="UserEmail";
	private String userMbileNo_KEY="UserMobileNo";
	private String UserRights_KEY="UserRights";
	
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
