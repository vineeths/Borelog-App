/**
 * 
 *
 *
 */
package com.jk.borelog;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.jk.borelog.adapter.InsituTestLogListAdapter;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;

/**
 * @author Linson
 *
 */
public class AddInsituTestLogPage extends BaseActivity implements OnClickListener, OnItemClickListener {

	Context context;
	ArrayList<String>testLogList;
	InsituTestLogListAdapter insituTestLogListAdapter;
	ListView insituTestLogValueList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_insitu_test_log_page);
		init();
	}
	/**
	 * 
	 */
	private void init() {
		context=AddInsituTestLogPage.this;
		setActionBar();
		testLogList=new ArrayList<String>();
		populateList();
		insituTestLogListAdapter=new InsituTestLogListAdapter(context, R.id.insituTestLogList,
				testLogList);
		insituTestLogValueList=(ListView)findViewById(R.id.insituTestLogList);
		insituTestLogValueList.setAdapter(insituTestLogListAdapter);
		insituTestLogValueList.setOnItemClickListener(this);
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
		title.setText(Globals.boreHoleInfoItem);
		Button backButton=(Button)v.findViewById(R.id.leftBarButton);
		backButton.setText("InsituTestLogs");
		backButton.setOnClickListener(this);
		Button rightBarButton=(Button)v.findViewById(R.id.rightBarButton);
		rightBarButton.setVisibility(View.GONE);
		getSupportActionBar().setCustomView(v,lp);
	}
	@Override
	public void onClick(View v) {
		
		if(v.getId()==R.id.leftBarButton){
			finish();
		}
	}
	/**
	 * 
	 */
	private void populateList() {
		testLogList.add("Auger");
		testLogList.add("Ground Water Observation");
		testLogList.add("SPT");
		testLogList.add("TW");
		testLogList.add("CR");
		testLogList.add("PS");
		testLogList.add("MZ");
		testLogList.add("PBT");
		testLogList.add("PKT");
		testLogList.add("PRM");
		testLogList.add("PZS");
		testLogList.add("VST");
		testLogList.add("WSP");
		testLogList.add("ATT-MZ");
		testLogList.add("ATT-PS");
		testLogList.add("ATT-TW");
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		Toast.makeText(context, "Not implemented the action for "+testLogList.get(arg2), Toast.LENGTH_SHORT).show();
	}	
}
