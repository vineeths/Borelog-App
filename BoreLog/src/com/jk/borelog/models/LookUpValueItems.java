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
public class LookUpValueItems {

	/**** Variables ****/
	public String lookUpValue1;
	public String lookUpValue2;
	public String lookUpValue3;
	
	
	/**** JSON KEYS ****/
	
	public static final String lookUpValue1_key="LookupValue1";
	public static final String lookUpValue2_key="LookupValue2";
	public static final String lookUpValue3_key="LookupValue3";
	/**
	 * @throws JSONException 
	 * 
	 */
	public LookUpValueItems(JSONObject jsonObject) throws JSONException {
		super();
		this.lookUpValue1=jsonObject.getString(lookUpValue1_key);
		this.lookUpValue2=jsonObject.getString(lookUpValue2_key);
		this.lookUpValue3=jsonObject.getString(lookUpValue3_key);
	}
	
	
	
}
