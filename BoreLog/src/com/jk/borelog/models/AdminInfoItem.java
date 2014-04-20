/**
 * 
 *
 *
 */
package com.jk.borelog.models;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Linson
 *
 */
public class AdminInfoItem {

	/**** Variables ****/
	public String moduleName;
	public ArrayList<LookUpValueItems>lookUpValueItemList=new ArrayList<LookUpValueItems>();
	
	/**** JSON KEYS ****/
	
	public static final String moduleNameKey="ModuleName";
	public static final String lookUpValueItemKey="LookupValuesItemColl";
	
	/*** DB ***/
	public static final String tableName="AdminInfoItem";
	 public static final String createTableQuery =
	            "CREATE TABLE " + tableName + " (" +
	            		moduleNameKey + " TEXT PRIMARY KEY, " +
	            		LookUpValueItems.lookUpValue1_key + " TEXT, " +
	            		LookUpValueItems.lookUpValue2_key + " TEXT, " +
	            		LookUpValueItems.lookUpValue3_key + " TEXT);";
	 
	/**
	 * @throws JSONException 
	 * 
	 */
	public AdminInfoItem(JSONObject jsonObject) throws JSONException {
		super();
		this.moduleName=jsonObject.getString(moduleNameKey);
		for (int i = 0; i < jsonObject.getJSONArray(lookUpValueItemKey).length(); i++) {
			LookUpValueItems lookUpValueItem=new LookUpValueItems(jsonObject
					.getJSONArray(lookUpValueItemKey).getJSONObject(i));
			this.lookUpValueItemList.add(lookUpValueItem);
		}
	}
	
	

}
