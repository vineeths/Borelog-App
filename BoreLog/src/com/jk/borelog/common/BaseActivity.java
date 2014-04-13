/**
 * @author Linson
 *
 * 
 */
package com.jk.borelog.common;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockActivity;
import com.jk.borelog.R;
import com.jk.borelog.interfaces.ChoicesItemSelected;
import com.jk.borelog.models.AdminInfoItem;
import com.jk.borelog.models.LookUpValueItems;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

public class BaseActivity extends SherlockActivity {
	int itemPosition;
	public void showAlertMessage(String title,String message){
		new AlertDialog.Builder(this)
	    .setTitle(title)
	    .setMessage(message)
	    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        }
	     })	    
	    .setIcon(R.drawable.ic_launcher)
	     .show();
	}
	
	public void showChoiceBoxDialog(final String string[],String title,int selectedPosition,final ChoicesItemSelected itemSelected,final View v){
		itemPosition=selectedPosition;
		new AlertDialog.Builder(this)
	    .setTitle(title)
	           .setSingleChoiceItems(string, selectedPosition,
	                      new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					itemPosition=which;
				}
	           })
	           .setPositiveButton("Done", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   itemSelected.doneClicked(v, itemPosition,string[itemPosition]);
	               }
	           })
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   itemSelected.cancelClicked();
	               }
	           })

	    .create()
	    .show();
	}
	public ArrayList<LookUpValueItems> getLookUpValuesForModuleName(String moduleName){
		ArrayList<LookUpValueItems>lookUpValueItemList=new ArrayList<LookUpValueItems>();
		for(AdminInfoItem item:Globals.adminInfoItemList){
			if(item.moduleName !=null && item.moduleName.equalsIgnoreCase(moduleName)){
				Log.i("AdminLookup", "Size of lookuplist "+item.lookUpValueItemList.size());
				lookUpValueItemList= item.lookUpValueItemList;
			}
		}
		return lookUpValueItemList;
	}
	public String[] getArrayForLookUpValue(ArrayList<LookUpValueItems> lookUpValueList,int lookUpValueNumber){
		Log.i("LookUpArray", "lookup Value list size "+lookUpValueList.size() +"\n lookUpValueNumber "+lookUpValueNumber);
		String[] lookUpValueArray=new String[lookUpValueList.size()];
	
		for (int i = 0; i < lookUpValueList.size(); i++) {
			LookUpValueItems item=lookUpValueList.get(i);
			Log.i("LookUpArray", "before if loop "+item.lookUpValue1);
			Log.i("LookUpArray3","before if loop "+ item.lookUpValue3);
			Log.i("LookUpArray2", "before if loop "+item.lookUpValue2);
			lookUpValueArray[i]=item.lookUpValue1;
			if (lookUpValueNumber==Integer.parseInt("1")) {
				lookUpValueArray[i]=item.lookUpValue1;
				Log.i("LookUpArray1", item.lookUpValue1);
			} else if (lookUpValueNumber==Integer.parseInt("2")) {
				lookUpValueArray[i]=item.lookUpValue2;
				Log.i("LookUpArray2", item.lookUpValue2);
			}else if (lookUpValueNumber==Integer.parseInt("3")) {
				lookUpValueArray[i]=item.lookUpValue3;
				Log.i("LookUpArray3", item.lookUpValue3);
			}
		}
		return lookUpValueArray;
	}
}
