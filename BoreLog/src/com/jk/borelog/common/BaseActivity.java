/**
 * @author Linson
 *
 * 
 */
package com.jk.borelog.common;

import com.actionbarsherlock.app.SherlockActivity;
import com.jk.borelog.R;
import com.jk.borelog.interfaces.ChoicesItemSelected;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
	            	   itemSelected.doneClicked(v, itemPosition);
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
}
