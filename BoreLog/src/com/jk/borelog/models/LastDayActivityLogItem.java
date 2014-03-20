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
	private static final String startTimeKey="StartTime";
	private static final String activityKey="Activity";
	private static final String typeOfInstallationKey="TypeofInstallation";
	private static final String depthKey="Depth";
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
