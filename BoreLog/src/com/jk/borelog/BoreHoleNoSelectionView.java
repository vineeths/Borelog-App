/**
 * 
 *
 *
 */
package com.jk.borelog;

import com.actionbarsherlock.app.ActionBar;
import com.jk.borelog.adapter.BoreHoleNoSelectionListAdapter;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;
import com.jk.borelog.models.BoreHoleInfoItem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
		DisplayMetrics dm = new DisplayMetrics(); 
		getWindowManager().getDefaultDisplay().getMetrics(dm); 
		int height = dm.heightPixels;
		if(Globals.projectInfoItem.boreHoleInfoItemList.size()>5){
			LayoutParams lp=new LayoutParams(
					android.view.ViewGroup.LayoutParams.MATCH_PARENT,
					height/2);
			lp.setMargins(5, 5, 5, 5);
			lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
			boreHoleListView.setLayoutParams(lp);
			boreHoleListView.setPadding(5, 5, 5, 5);
		}
		boreHoleListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		boreHoleNoSelectionListAdapter=new BoreHoleNoSelectionListAdapter
				(context, R.id.boreHoleList, Globals.projectInfoItem.boreHoleInfoItemList);
		boreHoleListView.setAdapter(boreHoleNoSelectionListAdapter);
		boreHoleListView.setOnItemClickListener(this);
		setActionBar();
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		BoreHoleInfoItem boreHoleInfoItem=(BoreHoleInfoItem) arg0.getAdapter().getItem(arg2);
		for (int i = 0; i < arg0.getChildCount(); i++) {
			if(i!=arg2){
				CheckBox checkBox=(CheckBox) arg0.getChildAt(i).findViewById(R.id.boreHoleCheckBox);
				TextView textView=(TextView) arg0.getChildAt(i).findViewById(R.id.boreHoleText);
				checkBox.setChecked(false);
			}
		}
		CheckBox clickedView=(CheckBox) arg1.findViewById(R.id.boreHoleCheckBox);
		if(clickedView.isChecked()){
			clickedView.setChecked(false);
			Globals.boreHoleInfoItem=null;
		}
		else{
			clickedView.setChecked(true);
			Globals.boreHoleInfoItem=boreHoleInfoItem.boreHoleInfoNo;
		}
		boreHoleNoSelectionListAdapter.notifyDataSetChanged();
	}

	/**
	 * 
	 */
	private void setActionBar() {
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(false); 
		com.actionbarsherlock.app.ActionBar.LayoutParams lp = new com.actionbarsherlock.app.ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
		LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v= layoutInflater.inflate(R.layout.action_bar_view, null);
		TextView title=(TextView)v.findViewById(R.id.title);
		title.setText("Boreholes");
		Button backButton=(Button)v.findViewById(R.id.leftBarButton);
		backButton.setText("Projects");
		backButton.setOnClickListener(this);
		Button rightBarButton=(Button)v.findViewById(R.id.rightBarButton);
		rightBarButton.setVisibility(View.GONE);
		getSupportActionBar().setCustomView(v,lp);
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId()== R.id.leftBarButton){
			Globals.projectInfoItem=null;
			finish();
		}else if (v.getId()==R.id.newBt) {
			if(Globals.boreHoleInfoItem!=null){
				Intent i=new Intent(context, BoreHoleDetailPage.class);
				startActivity(i);
			}else{
				showAlertMessage("Validation", "Please select one of the BoreHole");
			}
			
		}
	}

}
