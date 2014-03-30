/**
 * 
 *
 *
 */
package com.jk.borelog.models;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Linson
 *
 */
public class BoreHoleInfoItem {
	
	/**** Variables ****/
	public String boreHoleInfoNo;
	public String boreHoleId;
	public String boreHoleprojectGUID=null;
	
	/**** JSON KEYS ****/
	public static final String boreHoleInfoNoKey="BoreholeNo";
	public static final String boreHolIdKey="BoreholeID";
	public static final String boreHoleDbID="BoreHoleDBID";
	
	/*** DB ***/
	public static final String tableName="BoreHoleInfo";
	 public static final String createTableQuery =
	            "CREATE TABLE " + tableName + " (" +
	            		boreHoleDbID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
	            		boreHoleInfoNoKey +" TEXT, " +
	            		ProjectInfoItem.projectGUID_key + " TEXT, " +
	            		boreHolIdKey + " TEXT);";
	/**
	 * @throws JSONException 
	 * 
	 */
	public BoreHoleInfoItem(JSONObject jsonObject) throws JSONException {
		super();
		this.boreHoleInfoNo=jsonObject.getString(boreHoleInfoNoKey);
		this.boreHoleId=jsonObject.optString(boreHolIdKey);
	}
	/**
	 * @return the projectGUID
	 */
	public String getBoreHoleprojectGUID() {
		return boreHoleprojectGUID;
	}
	/**
	 * @param projectGUID the projectGUID to set
	 */
	public void setBoreHoleprojectGUID(String boreHoleprojectGUID) {
		this.boreHoleprojectGUID = boreHoleprojectGUID;
	}
	
	
}
