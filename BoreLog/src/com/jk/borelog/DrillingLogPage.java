/**
 * 
 *
 *
 */
package com.jk.borelog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;

/**
 * @author Linson
 *
 */
public class DrillingLogPage extends BaseActivity implements OnClickListener {
	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drilling_log_page);
		init();
	}

	/**
	 * 
	 */
	private void init() {
		context=DrillingLogPage.this;
		setActionBar();
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
		backButton.setText("Boreholes");
		backButton.setOnClickListener(this);
		Button rightBarButton=(Button)v.findViewById(R.id.rightBarButton);
		rightBarButton.setText("Add");
		rightBarButton.setBackgroundResource(R.drawable.green_button);
		rightBarButton.setOnClickListener(this);
		getSupportActionBar().setCustomView(v,lp);
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.rightBarButton){
			Intent intent=new Intent(context, AddDrillingLogPage.class);
			startActivity(intent);
		}else if (v.getId()==R.id.leftBarButton) {
			finish();
		}
	}
}
