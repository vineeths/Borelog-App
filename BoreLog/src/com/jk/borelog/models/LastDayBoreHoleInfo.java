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
public class LastDayBoreHoleInfo {
	/**** Variables ****/
	public String contractGUID;
	public String publicGUID;
	public String boreHoleID;
	public String clientName;
	public String projectName;
	public String projectNo;
	public String projectManagerName;
	public String supervisorName;
	public String boreHoleNo;
	public String boreHoleDate;
	public String rigNo;
	public String drillingMethod;
	public String diameterOfCasing;
	public String diameterOfBoreHole;
	public String northing;
	public String easting;
	public String drillerName;
	public String assistantName1;
	public String assistantName2;
	public String assistantName3;
	public String assistantName4;
	public String remarks;
	public String terminationDepth;
	public String lastRecordDepth;
	public ArrayList<LastDayActivityLogItem> lastDayActivityLogItemList=new ArrayList<LastDayActivityLogItem>();
	public ArrayList<LastDrillingLogItem>lastDayDrillingLogItemList=new ArrayList<LastDrillingLogItem>();
	public ArrayList<LastDayInsituLogItem>lasDayInsituLogItemList=new ArrayList<LastDayInsituLogItem>();
	public ArrayList<InSItuLogMaxDepthItem>inSItuLogMaxDepthItemList=new ArrayList<InSItuLogMaxDepthItem>();
	
	/**** JSON KEYS ****/
	private static final String contractGUIDKey= "ContractGUID";
	private static final String publicGUIDKey= "BHGUID";
	private static final String boreHoleIDKey= "BoreholeID";
	private static final String clientNameKey= "ClientName";
	private static final String projectNameKey= "ProjectName";
	private static final String projectNoKey= "ProjectNo";
	private static final String projectManagerNameKey= "ProjectManagerName";
	private static final String supervisorNameKey= "SupervisorName";
	private static final String boreHoleNoKey= "BoreholeNo";
	private static final String boreHoleDateKey= "BoreholeDate";
	private static final String rigNoKey= "RigNo";
	private static final String drillingMethodKey= "DrillingMethod";
	private static final String diameterOfCasingKey= "DiameterofCasing";
	private static final String diameterOfBoreHoleKey= "DiameterofBorehole";
	private static final String northingKey= "Northing";
	private static final String eastingKey= "Easting";
	private static final String drillerNameKey= "DrillerName";
	private static final String assistantName1Key= "AssistantName1";
	private static final String assistantName2Key= "AssistantName2";
	private static final String assistantName3Key= "AssistantName3";
	private static final String assistantName4Key= "AssistantName4";
	private static final String remarksKey= "Remarks";
	private static final String terminationDepthKey= "TerminationDepth";
	private static final String lastRecordDepthKey= "LastRecordDepth";
	private static final String lastDayActivityLogItemListKey= "LastDayActivityLogItemColl";
	private static final String lastDayDrillingLogItemListKey= "LastDayDrillingLogItemColl";
	private static final String lasDayInsituLogItemListKey= "LastDayInSituLogItemColl";
	private static final String inSItuLogMaxDepthItemListKey= "InSituLogMaxDepthItemColl";
	/**
	 * @throws JSONException 
	 * 
	 */
	public LastDayBoreHoleInfo(JSONObject jsonObject) throws JSONException {
		super();
		this.contractGUID=jsonObject.getString(contractGUIDKey);
		this.publicGUID=jsonObject.getString(publicGUIDKey);
		this.boreHoleID=jsonObject.getString(boreHoleIDKey);
		this.clientName=jsonObject.getString(clientNameKey);
		this.projectName=jsonObject.getString(projectNameKey);
		this.projectNo=jsonObject.getString(projectNoKey);
		this.projectManagerName=jsonObject.getString(projectManagerNameKey);
		this.supervisorName=jsonObject.getString(supervisorNameKey);
		this.boreHoleNo=jsonObject.getString(boreHoleNoKey);
		this.boreHoleDate=jsonObject.getString(boreHoleDateKey);
		this.rigNo=jsonObject.getString(rigNoKey);
		this.drillingMethod=jsonObject.getString(drillingMethodKey);
		this.diameterOfCasing=jsonObject.getString(diameterOfCasingKey);
		this.diameterOfBoreHole=jsonObject.getString(diameterOfBoreHoleKey);
		this.northing=jsonObject.getString(northingKey);
		this.easting=jsonObject.getString(eastingKey);
		this.drillerName=jsonObject.getString(drillerNameKey);
		this.assistantName1=jsonObject.getString(assistantName1Key);
		this.assistantName2=jsonObject.getString(assistantName2Key);
		this.assistantName3=jsonObject.getString(assistantName3Key);
		this.assistantName4=jsonObject.getString(assistantName4Key);
		this.remarks=jsonObject.getString(remarksKey);
		this.terminationDepth=jsonObject.getString(terminationDepthKey);		
		this.lastRecordDepth=jsonObject.getString(lastRecordDepthKey);
		
		for (int i = 0; i < jsonObject.getJSONArray(lastDayActivityLogItemListKey).length(); i++) {
			LastDayActivityLogItem activityLogItem=new LastDayActivityLogItem(jsonObject.getJSONArray(lastDayActivityLogItemListKey).getJSONObject(i));
			this.lastDayActivityLogItemList.add(activityLogItem);
//			Log.i("LastDayBoreHoleInfo", "lastDayActivityLogItemList size ="+lastDayActivityLogItemList.size());
		}
		
		for (int i = 0; i < jsonObject.getJSONArray(lasDayInsituLogItemListKey).length(); i++) {
			LastDayInsituLogItem insituLogItem=new LastDayInsituLogItem(jsonObject.getJSONArray(lasDayInsituLogItemListKey).getJSONObject(i));
			this.lasDayInsituLogItemList.add(insituLogItem);
//			Log.i("LastDayBoreHoleInfo", "lasDayInsituLogItemList size ="+lasDayInsituLogItemList.size());
		}
		for (int i = 0; i < jsonObject.getJSONArray(inSItuLogMaxDepthItemListKey).length(); i++) {
			InSItuLogMaxDepthItem inSItuLogMaxDepthItem=new InSItuLogMaxDepthItem(jsonObject.getJSONArray(inSItuLogMaxDepthItemListKey).getJSONObject(i));
			this.inSItuLogMaxDepthItemList.add(inSItuLogMaxDepthItem);
//			Log.i("LastDayBoreHoleInfo", "inSItuLogMaxDepthItemList size ="+inSItuLogMaxDepthItemList.size());
		}
	}
	
	
	
	
}
