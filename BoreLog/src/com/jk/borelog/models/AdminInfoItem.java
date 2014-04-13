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
	
	private static final String moduleNameKey="ModuleName";
	private static final String lookUpValueItemKey="LookupValuesItemColl";
	/**
	 * @throws JSONException 
	 * 
	 */
	public AdminInfoItem(JSONObject jsonObject) throws JSONException {
		super();
		this.moduleName=jsonObject.getString(moduleNameKey);
		Log.i("Module Name", this.moduleName);
		Log.i("Module Name", jsonObject.toString());
		Log.i("Module Name", "array lenght"+jsonObject.getJSONArray(lookUpValueItemKey).length());
		for (int i = 0; i < jsonObject.getJSONArray(lookUpValueItemKey).length(); i++) {
			LookUpValueItems lookUpValueItem=new LookUpValueItems(jsonObject
					.getJSONArray(lookUpValueItemKey).getJSONObject(i));
			this.lookUpValueItemList.add(lookUpValueItem);
		}
	}
	
	

}
