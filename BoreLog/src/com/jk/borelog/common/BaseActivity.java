/**
 * @author Linson
 *
 * 
 */
package com.jk.borelog.common;

import com.actionbarsherlock.app.SherlockActivity;
import com.jk.borelog.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class BaseActivity extends SherlockActivity {

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
}
