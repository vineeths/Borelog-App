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
public class InSItuLogMaxDepthItem {

	/**** Variables ****/
	
	public String insituType;
	public String maxDepth;
	
	/**** JSON KEYS ****/
	
	private static final String insituTypeKey="InsituType";
	private static final String maxDepthKey="MaxDepth";
	
	/**
	 * @throws JSONException 
	 * 
	 */
	public InSItuLogMaxDepthItem(JSONObject jsonObject) throws JSONException {
		super();
		this.insituType=jsonObject.getString(insituTypeKey);
		this.maxDepth=jsonObject.getString(maxDepthKey);
	}
	
	
}
