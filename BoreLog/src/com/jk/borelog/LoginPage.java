/**
 * @author Linson
 *
 * 
 */
package com.jk.borelog;

import java.util.ArrayList;

import com.jk.borelog.api.Communicator;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.NetworkConnectivityManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
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
	}

	@Override
	public void onClick(View v) {
		
		loginTask=new LoginTask();
		
	}
	
	public class LoginTask extends AsyncTask<ArrayList<String>, Void, Void> {

		private ProgressDialog progressDialog;

		
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			try {
				progressDialog.dismiss();
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
						"Loading data...", true);
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
		protected Void doInBackground(ArrayList<String>... arg0) {

			try { 
				NetworkConnectivityManager manager=new NetworkConnectivityManager(context);
				if(manager.hasDataConnectivity()){
					Communicator communicator=new Communicator(context);
					communicator.login("sp1", "qwerty");
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}


		
	}
	
}
