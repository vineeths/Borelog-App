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
public class Results {

		/**** Variables ****/
		public String response;
		public String message;
		
		/**** JSON KEYS ****/
		
		public String response_key="Response";
		public String message_key="ErrorDesc";
		/**
		 * Constructor to set all the values from json object
		 * @throws JSONException 
		 */
		public Results(JSONObject resultObject) throws JSONException {
			
			this.response=resultObject.getString(response_key);
			this.message=resultObject.getString(message_key);
		}
		
		
		
}
