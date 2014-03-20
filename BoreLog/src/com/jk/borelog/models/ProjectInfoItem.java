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
public class ProjectInfoItem {
	
	/**** Variables ****/
	public String projectGUID;
	public String projectName;
	public String projectNo;
	public ArrayList<BoreHoleInfoItem>boreHoleInfoItemList=new ArrayList<BoreHoleInfoItem>();
	
	
	/**** JSON KEYS ****/
	
	private static final String projectGUID_key="ProjectGUID";
	public static final String projectName_key="ProjectName";
	public static final String projectNo_key="ProjectNo";
	public static final String boreHoleInfoItem_key="BoreHoleInfoItemColl";
	/**
	 * @throws JSONException 
	 * 
	 */
	public ProjectInfoItem(JSONObject jsonObject) throws JSONException {
		super();
		this.projectGUID=jsonObject.getString(projectGUID_key);
		this.projectName=jsonObject.getString(projectName_key);
		this.projectNo=jsonObject.getString(projectNo_key);
		for (int i = 0; i < jsonObject.getJSONArray(boreHoleInfoItem_key).length(); i++) {
			BoreHoleInfoItem boreHoleItem =new BoreHoleInfoItem(jsonObject.getJSONArray(boreHoleInfoItem_key).getJSONObject(i)); 
			this.boreHoleInfoItemList.add(boreHoleItem);
		}
	}
	
	
	
}
