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
public class LastDayInsituLogItem {

	/**** Variables ****/
	
	public String insituType;
	public String description;
	public String value1;
	public String value2;
	public String value3;
	public String value4;
	public String value5;
	public String value6;
	public String value7;
	public String value8;
	public String value9;
	public String total;
	public String presentation;
	public String recovery;
	
	/**** JSON KEYS ****/	
	  
	public static final String insituTypeKey="InSituTestType";
	public static final String descriptionKey="Description";
	public static final String value1Key="Value1";
	public static final String value2Key="Value2";
	public static final String value3Key="Value3";
	public static final String value4Key="Value4";
	public static final String value5Key="Value5";
	public static final String value6Key="Value6";
	public static final String value7Key="Value7";
	public static final String value8Key="Value8";
	public static final String value9Key="Value9";
	public static final String totalKey="Total";
	public static final String presentationKey="Penetration";
	public static final String recoveryKey="Recovery";
	public static final String primaryIDKEY="InsituLogPrimaryKey";
	
	/** DB**/
	public static final String tableName="InsituLogItem";
	 public static final String createTableQuery =
	            "CREATE TABLE " + tableName + " (" +
	            		primaryIDKEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
	            		ProjectInfoItem.projectGUID_key+" TEXT, "+
	            		BoreHoleInfoItem.boreHoleInfoNoKey+"TEXT,"+
	            		insituTypeKey + " TEXT, " +
	            		descriptionKey + " TEXT, " +
	            		value1Key + " TEXT, " +
	            		value2Key + " TEXT, " +
	            		value3Key + " TEXT, " +
	            		value4Key + " TEXT, " +
	            		value5Key + " TEXT, " +
	            		value6Key + " TEXT, " +
	            		value7Key + " TEXT, " +
	            		value8Key + " TEXT, " +
	            		value9Key + " TEXT, " +	            		
						totalKey + " TEXT, " +
						presentationKey + " TEXT, " +
						recoveryKey + " TEXT);";
	/**
	 * @throws JSONException 
	 * 
	 */
	public LastDayInsituLogItem(JSONObject jsonObject) throws JSONException {
		super();
		Log.i("LastDayInsituLogItem", "***************************************\n" +
				jsonObject);
		this.insituType=jsonObject.getString(insituTypeKey);
		this.description=jsonObject.getString(descriptionKey);
		this.value1=jsonObject.getString(value1Key);
		this.value2=jsonObject.getString(value2Key);
		this.value3=jsonObject.getString(value3Key);
		this.value4=jsonObject.getString(value4Key);
		this.value5=jsonObject.getString(value5Key);
		this.value6=jsonObject.getString(value6Key);
		this.value7=jsonObject.getString(value7Key);
		this.value8=jsonObject.getString(value8Key);
		this.value9=jsonObject.getString(value9Key);
		this.total=jsonObject.getString(totalKey);
		this.presentation=jsonObject.getString(presentationKey);
		this.recovery=jsonObject.getString(recoveryKey);
	}
	
	
	
}
