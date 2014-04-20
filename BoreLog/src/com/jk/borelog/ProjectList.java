/**
 * 
 *
 *
 */
package com.jk.borelog;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.jk.borelog.adapter.ProjectListAdapter;
import com.jk.borelog.api.Communicator;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;
import com.jk.borelog.common.NetworkConnectivityManager;
import com.jk.borelog.db.AdminInfoItemDBAdapter;
import com.jk.borelog.models.AdminInfoItem;
import com.jk.borelog.models.BoreHoleInfoItem;
import com.jk.borelog.models.ProjectInfoItem;
import com.jk.borelog.models.Results;
import com.jk.borelog.models.UserInfo;

/**
 * @author Linson
 *
 */
public class ProjectList extends BaseActivity implements OnClickListener, OnItemClickListener {

	Context context;
	ProjectDetailsTask projectDetailsTask;
	ProjectListAdapter projectListAdapter;
	ListView projectListView;
	ArrayList<AdminInfoItem>adminInfoItemList=new ArrayList<AdminInfoItem>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projects_list_page);		
		init();
	}
	
	/**
	 * 
	 */
	private void init() {
		context=ProjectList.this;
		setActionBar();
		projectListView = (ListView)findViewById(R.id.projectList);
		projectListView.setOnItemClickListener(this);
		projectDetailsTask=new ProjectDetailsTask();
		Void params = null;
		projectDetailsTask.execute(params);
		
	}
	
	/**
	 * 
	 */
	private void setActionBar() {
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(false); 
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
		LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v= layoutInflater.inflate(R.layout.action_bar_view, null);
		TextView title=(TextView)v.findViewById(R.id.title);
		title.setText("Projects");
		Button logoutButton=(Button)v.findViewById(R.id.rightBarButton);
		logoutButton.setText("Logout");
		logoutButton.setOnClickListener(this);
		Button leftBarButton=(Button)v.findViewById(R.id.leftBarButton);
		leftBarButton.setVisibility(View.GONE);
		getSupportActionBar().setCustomView(v,lp);
	}

	public class ProjectDetailsTask extends AsyncTask<Void, Void, ArrayList<Object>> {

		private ProgressDialog progressDialog;

		@Override
		protected ArrayList<Object> doInBackground(Void... arg0) {
			ArrayList<Object>responseList=new ArrayList<Object>();
			ArrayList<Object>boreHoleInfoList=new ArrayList<Object>();
			try { 
				NetworkConnectivityManager manager=new NetworkConnectivityManager(context);
				if(manager.hasDataConnectivity()){
					
					Communicator communicator=new Communicator(context);
					responseList=communicator.getProjectList(Globals.userInfo.userGUID);
					communicator.getAdminLookupValues();
					
					
					Results loginResults=(Results)responseList.get(0);
					if(loginResults.response.equalsIgnoreCase("1")){
						Object object=responseList.get(1);
						ArrayList<ProjectInfoItem>projectList=(ArrayList<ProjectInfoItem>) object;
						for (int i = 0; i < projectList.size(); i++) {
							ProjectInfoItem infoItem=projectList.get(i);
							for (int j = 0; j < infoItem.boreHoleInfoItemList.size(); j++) {
								BoreHoleInfoItem boreHoleInfoItem=infoItem.boreHoleInfoItemList.get(j);
								ArrayList<Object>lastDayBoreHoleInfo=
										communicator.getLastDayBoreHoleInfo(infoItem.projectGUID, boreHoleInfoItem.boreHoleInfoNo);
								boreHoleInfoList.add(lastDayBoreHoleInfo);
							}
						}
						Log.i("ProjectList", "@@@ boreHoleInfoList size"+boreHoleInfoList.size());
					}
					
					return responseList;
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		
		}

		@Override
		protected void onPostExecute(ArrayList<Object> result) {
			super.onPostExecute(result);
			try {
				progressDialog.dismiss();
				if(result.size()>0){
					Results loginResults=(Results)result.get(0);
					if(loginResults.response.equalsIgnoreCase("1")){
						Object object=result.get(1);
						ArrayList<ProjectInfoItem>projectList=(ArrayList<ProjectInfoItem>) object;
						updateList(projectList);
					}
					else{
						showAlertMessage("Download failed.", loginResults.message);
					}
				}
				
				
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
						"Downloading BoreHole data,\n please wait...", true);
				progressDialog.setCancelable(true);
				progressDialog.setOnCancelListener(new OnCancelListener() {
					
					@Override
					public void onCancel(DialogInterface dialog) {

						projectDetailsTask.cancel(true);
						progressDialog.dismiss();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param projectList
	 */
	public void updateList(ArrayList<ProjectInfoItem> projectList) {
		projectListAdapter=new ProjectListAdapter(context, R.id.projectList, projectList);
		projectListView.setAdapter(projectListAdapter);
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId()==R.id.rightBarButton){
			Globals.userInfo=null;
			Globals.projectInfoItem=null;					
			finish();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		ProjectInfoItem clickedItem=(ProjectInfoItem)arg0.getAdapter().getItem(arg2);
		Globals.projectInfoItem=clickedItem;
		Intent intent=new Intent(context, BoreHoleNoSelectionView.class);
		startActivity(intent);
	}

	

}
