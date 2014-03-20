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
	
	/**** JSON KEYS ****/
	private String boreHoleInfoNoKey="BoreholeNo";
	private String boreHolIdKey="BoreholeID";
	/**
	 * @throws JSONException 
	 * 
	 */
	public BoreHoleInfoItem(JSONObject jsonObject) throws JSONException {
		super();
		this.boreHoleInfoNo=jsonObject.getString(boreHoleInfoNoKey);
		this.boreHoleId=jsonObject.optString(boreHolIdKey);
	}
	
	
}
