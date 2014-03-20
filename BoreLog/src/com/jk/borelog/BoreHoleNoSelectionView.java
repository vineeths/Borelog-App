/**
 * 
 *
 *
 */
package com.jk.borelog;

import com.jk.borelog.adapter.BoreHoleNoSelectionListAdapter;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;
import com.jk.borelog.models.BoreHoleInfoItem;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Linson
 *
 */
public class BoreHoleNoSelectionView extends BaseActivity implements OnItemClickListener, OnClickListener {

	Button draftBt,newBt,lastSubmittedBt;
	ListView boreHoleListView;
	BoreHoleNoSelectionListAdapter boreHoleNoSelectionListAdapter;
	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.borehole_selectio_view);
		init();
	}

	/**
	 * 
	 */
	private void init() {
		context=BoreHoleNoSelectionView.this;
		draftBt=(Button)findViewById(R.id.draftBt);
		newBt=(Button)findViewById(R.id.newBt);
		newBt.setOnClickListener(this);
		lastSubmittedBt=(Button)findViewById(R.id.lastSubmittedBt);
		boreHoleListView=(ListView)findViewById(R.id.boreHoleList);
		boreHoleNoSelectionListAdapter=new BoreHoleNoSelectionListAdapter
				(context, R.id.boreHoleList, Globals.projectInfoItem.boreHoleInfoItemList);
		boreHoleListView.setAdapter(boreHoleNoSelectionListAdapter);
		boreHoleListView.setOnItemClickListener(this);
		setActionBar();
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		BoreHoleInfoItem boreHoleInfoItem=(BoreHoleInfoItem) arg0.getAdapter().getItem(arg2);
		
		CheckBox clickedView=(CheckBox) arg1.findViewById(R.id.boreHoleCheckBox);
		Toast.makeText(context, "test "+clickedView.isChecked(), Toast.LENGTH_SHORT).show();
		if(clickedView.isChecked()){
			clickedView.setChecked(false);
		}
		else{
			clickedView.setChecked(true);
			Globals.boreHoleInfoItem=boreHoleInfoItem.boreHoleInfoNo;
		}
		
	}

	/**
	 * 
	 */
	private void setActionBar() {
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false); 
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
		LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v= layoutInflater.inflate(R.layout.action_bar_view, null);
		TextView title=(TextView)v.findViewById(R.id.title);
		title.setText("Boreholes");
		Button backButton=(Button)v.findViewById(R.id.leftBarButton);
		backButton.setText("Projects");
		backButton.setOnClickListener(this);
		Button rightBarButton=(Button)v.findViewById(R.id.rightBarButton);
		rightBarButton.setVisibility(View.GONE);
		getActionBar().setCustomView(v,lp);
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId()== R.id.leftBarButton){
			Globals.projectInfoItem=null;
			finish();
		}else if (v.getId()==R.id.newBt) {
			
			Intent i=new Intent(context, BoreHoleDetailPage.class);
			startActivity(i);
		}
	}

}
