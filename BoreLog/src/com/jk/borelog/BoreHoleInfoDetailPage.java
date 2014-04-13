/**
 * 
 *
 *
 */
package com.jk.borelog;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.common.Globals;
import com.jk.borelog.interfaces.ChoicesItemSelected;

/**
 * @author Linson
 *
 */
public class BoreHoleInfoDetailPage extends BaseActivity implements OnClickListener, ChoicesItemSelected {

	Context context;
	RelativeLayout rigLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.borehole_info_detail_page);
		init();
	}

	
	/**
	 * 
	 */
	private void init() {
		context=BoreHoleInfoDetailPage.this;
		setActionBar();
		rigLayout=(RelativeLayout)findViewById(R.id.rigNumrLayout);
		rigLayout.setOnClickListener(this);
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
		title.setText("Borehole Info");
		Button backButton=(Button)v.findViewById(R.id.leftBarButton);
		backButton.setText("Back");
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
		if(v.getId()==R.id.rigNumrLayout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("RigNo"), 1);
			showChoiceBoxDialog(string, "Rig Number", 0, this,v);
		}
	}


	@Override
	public void itemSelected(String selectedItem) {
		Toast.makeText(context, selectedItem, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void cancelClicked() {
		
	}

	@Override
	public void doneClicked(View v, int position, String value) {

		if(v.getId()==R.id.rigNumrLayout){
			Toast.makeText(context, "postition "+position, Toast.LENGTH_SHORT).show();
		}
	}
	
}
