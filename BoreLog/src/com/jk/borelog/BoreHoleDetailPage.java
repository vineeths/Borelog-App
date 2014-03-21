/**
 * 
 *
 *
 */
package com.jk.borelog;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;

/**
 * @author Linson
 *
 */
public class BoreHoleDetailPage extends BaseActivity implements OnClickListener {

	Context context;
	TextView projectTitle,statusText;
	ImageView boreHoleInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.borehole_detail_page);
		init();
	}

	/**
	 * 
	 */
	private void init() {
		context=BoreHoleDetailPage.this;
		setActionBar();
		statusText=(TextView)findViewById(R.id.statusText);
		projectTitle=(TextView)findViewById(R.id.projectTitle);
		projectTitle.setText(Globals.projectInfoItem.projectName);
		boreHoleInfo=(ImageView)findViewById(R.id.boreholeinfo);
		boreHoleInfo.setOnClickListener(this);
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
		title.setText(Globals.boreHoleInfoItem);
		Button backButton=(Button)v.findViewById(R.id.leftBarButton);
		backButton.setText("Boreholes");
		backButton.setOnClickListener(this);
		Button rightBarButton=(Button)v.findViewById(R.id.rightBarButton);
		rightBarButton.setVisibility(View.GONE);
		getActionBar().setCustomView(v,lp);
	}

	@Override
	public void onClick(View arg0) {
		if(arg0.getId()==R.id.leftBarButton){
			Globals.boreHoleInfoItem=null;
			finish();
		}else if (arg0.getId()==R.id.boreholeinfo) {
			
			Intent intent=new Intent(context, BoreHoleInfoDetailPage.class);
			startActivity(intent);
			
		}
	}
}
