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
public class LookUpValueItems {

	/**** Variables ****/
	public String lookUpValue1;
	public String lookUpValue2;
	public String lookUpValue3;
	
	
	/**** JSON KEYS ****/
	
	private static final String lookUpValue1_key="LookupValue1";
	private static final String lookUpValue2_key="LookupValue2";
	private static final String lookUpValue3_key="LookupValue3";
	/**
	 * @throws JSONException 
	 * 
	 */
	public LookUpValueItems(JSONObject jsonObject) throws JSONException {
		super();
		this.lookUpValue1=jsonObject.getString(lookUpValue1_key);
		this.lookUpValue1=jsonObject.getString(lookUpValue2_key);
		this.lookUpValue1=jsonObject.getString(lookUpValue3_key);
	}
	
	
	
}
