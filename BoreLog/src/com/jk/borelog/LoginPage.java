/**
 * @author Linson
 *
 * 
 */
package com.jk.borelog;

import java.util.ArrayList;

import com.jk.borelog.api.Communicator;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;
import com.jk.borelog.common.NetworkConnectivityManager;
import com.jk.borelog.models.Results;
import com.jk.borelog.models.UserInfo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends BaseActivity implements OnClickListener {

	Button loginBt;
	EditText userNameExt,passwrdExt;
	Context context;
	Void params;
	LoginTask loginTask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		getActionBar().hide();
		init();
	}

	/**
	 * initialize the values 
	 */
	private void init() {
		context=LoginPage.this;
		loginBt=(Button)findViewById(R.id.login_bt);
		userNameExt=(EditText)findViewById(R.id.username_ext);
		passwrdExt=(EditText)findViewById(R.id.password_ext);
		loginBt.setOnClickListener(this);
		
		//for test
		userNameExt.setText("sp1");
		passwrdExt.setText("qwerty");
	}

	@Override
	public void onClick(View v) {
		
		loginTask=new LoginTask();
		if(validationSucceeded()){
			loginTask.execute(userNameExt.getText().toString(),passwrdExt.getText().toString());
		}
		
		
	}
	
	/**
	 * 
	 */
	private boolean validationSucceeded() {
		boolean validationSucceed=false;
		if(userNameExt.getText().length()>0 && passwrdExt.getText().length()>0){
			validationSucceed=true;
			
		}else if(userNameExt.getText().length()==0 && passwrdExt.getText().length()==0){
			showAlertMessage(Globals.validation, "Please fill User name and Password.");
		}else if(userNameExt.getText().length()>0){
			showAlertMessage(Globals.validation, "Please fill User name.");
			if(!(passwrdExt.getText().length()>0)){
				showAlertMessage(Globals.validation, "Please fill Password.");
			}
		}else if(passwrdExt.getText().length()>0){
			if(!(userNameExt.getText().length()>0)){
				showAlertMessage(Globals.validation, "Please fill User name.");
			}
		}
		return validationSucceed;
		
	}

	public class LoginTask extends AsyncTask<String, Void, ArrayList<Object>> {

		private ProgressDialog progressDialog;

		@Override
		protected void onPostExecute(ArrayList<Object> resultList) {
			super.onPostExecute(resultList);
			try {
				progressDialog.dismiss();
				doLoginResponseAction(resultList);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			try {
				progressDialog = ProgressDialog.show(
						context, "",
						"Logging in...", true);
				progressDialog.setCancelable(true);
				progressDialog.setOnCancelListener(new OnCancelListener() {
					
					@Override
					public void onCancel(DialogInterface dialog) {

						loginTask.cancel(true);
						progressDialog.dismiss();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		@Override
		protected ArrayList<Object> doInBackground(String... arg0) {
			ArrayList<Object>responseList=new ArrayList<Object>();
			try { 
				NetworkConnectivityManager manager=new NetworkConnectivityManager(context);
				if(manager.hasDataConnectivity()){
					
					Communicator communicator=new Communicator(context);
					responseList=communicator.login(arg0[0], arg0[1]);
					return responseList;
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}


		
	}

	/**
	 * @param resultList
	 */
	public void doLoginResponseAction(ArrayList<Object> resultList) {
		
		if(resultList.size()>0){
			Results loginResults=(Results)resultList.get(0);
			if(Integer.parseInt(loginResults.response)==1){
				UserInfo userInfo=(UserInfo)resultList.get(1);
				Globals.userInfo=userInfo;
				Intent intent=new Intent(context, ProjectList.class);
				startActivity(intent);
			}else{
				showAlertMessage("Failed to login", loginResults.message);
			}
		}else{
			showAlertMessage("Error", "Something bad happened, please try again.");
		}
		
	}
	
}
