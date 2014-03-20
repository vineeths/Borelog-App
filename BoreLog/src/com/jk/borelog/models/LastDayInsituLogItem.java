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
	  
	private static final String insituTypeKey="InSituTestType";
	private static final String descriptionKey="Description";
	private static final String value1Key="Value1";
	private static final String value2Key="Value2";
	private static final String value3Key="Value3";
	private static final String value4Key="Value4";
	private static final String value5Key="Value5";
	private static final String value6Key="Value6";
	private static final String value7Key="Value7";
	private static final String value8Key="Value8";
	private static final String value9Key="Value9";
	private static final String totalKey="Total";
	private static final String presentationKey="Penetration";
	private static final String recoveryKey="Recovery";
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
