package com.jk.borelog.models;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Linson
 *
 */
public class LastDayActivityLogItem {

	/**** variables ****/
	public String startTime;
	public String activity;
	public String typeOfInstallation;
	public String depth;
	
	
	/**** JSON KEYS ****/
	public static final String startTimeKey="StartTime";
	public static final String activityKey="Activity";
	public static final String typeOfInstallationKey="TypeofInstallation";
	public static final String depthKey="Depth";
	public static final String primaryIDKey="primarykey";
	/*** DB ***/
	public static final String tableName="ActivityLogItem";
	 public static final String createTableQuery =
	            "CREATE TABLE " + tableName + " (" +
	            		primaryIDKey + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
	            		startTimeKey + " TEXT, " +
	            		depthKey + " TEXT, " +
	            		typeOfInstallationKey + " TEXT, " +
	            		ProjectInfoItem.projectGUID_key+" TEXT, "+
	            		BoreHoleInfoItem.boreHoleInfoNoKey+"TEXT,"+
	            		activityKey + " TEXT);";
	/**
	 * @throws JSONException 
	 * 
	 */
	public LastDayActivityLogItem(JSONObject jsonObject) throws JSONException {
		super();
		this.startTime=jsonObject.getString(startTimeKey);
		this.activity=jsonObject.getString(activityKey);
		this.typeOfInstallation=jsonObject.getString(typeOfInstallationKey);
		this.depth=jsonObject.getString(depthKey);
	}
	
}
