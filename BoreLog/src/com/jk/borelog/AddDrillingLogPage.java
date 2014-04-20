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
public class AddDrillingLogPage extends BaseActivity implements OnItemClickListener, OnClickListener {
	Context context;
	ArrayList<String>drillingLogList;
	InsituTestLogListAdapter drillingLogListAdapter;
	ListView drilinglogList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_drilling_log_page);
		init();
	}
	/**
	 * 
	 */
	private void init() {
		context=AddDrillingLogPage.this;
		setActionBar();
		drillingLogList=new ArrayList<String>();
		populateList();
		drillingLogListAdapter=new InsituTestLogListAdapter(context, R.id.insituTestLogList,
				drillingLogList);
		drilinglogList=(ListView)findViewById(R.id.addDrillingLogList);
		drilinglogList.setAdapter(drillingLogListAdapter);
		drilinglogList.setOnItemClickListener(this);
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
		backButton.setText("BoreHoles");
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
		drillingLogList.add("Add Soil Type Entry");
		drillingLogList.add("Add Rock Type Entry");
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if(arg2==0){
			Intent intent=new Intent(context, AddSoilTypeEntryPage.class);
			startActivity(intent);
		}
		else
		{
			Intent intent=new Intent(context, AddRockTypeEntryPage.class);
			startActivity(intent);
		}
	}
}
