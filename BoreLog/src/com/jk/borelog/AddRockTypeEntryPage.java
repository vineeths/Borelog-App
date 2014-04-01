/**
 * 
 *
 *
 */
package com.jk.borelog;

import com.actionbarsherlock.app.ActionBar;
import com.jk.borelog.common.BaseActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

/**
 * @author Linson
 *
 */
public class AddRockTypeEntryPage extends BaseActivity implements OnClickListener{

	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_rock_type_entry);
		init();
	}

	/**
	 * 
	 */
	private void init() {
		context=AddRockTypeEntryPage.this;
		setUpActionBar();
	}
	/**
	 * 
	 */
	private void setUpActionBar() {

		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(false); 
		com.actionbarsherlock.app.ActionBar.LayoutParams lp = new com.actionbarsherlock.app.ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
		LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v= layoutInflater.inflate(R.layout.action_bar_view, null);
		TextView title=(TextView)v.findViewById(R.id.title);
		title.setText("Add Rock Type Entry");
		title.setTextSize(18.0f);
		Button backButton=(Button)v.findViewById(R.id.leftBarButton);
		backButton.setText("Back");
		backButton.setOnClickListener(this);
		Button rightBarButton=(Button)v.findViewById(R.id.rightBarButton);
		rightBarButton.setVisibility(View.GONE);
		getSupportActionBar().setCustomView(v,lp);
	
	}
	@Override
	public void onClick(View arg0) {
		finish();
	}
	
	
}
