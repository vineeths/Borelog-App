/**
 * 
 *
 *
 */
package com.jk.borelog;

import java.lang.reflect.Array;
import java.util.Arrays;

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
import com.jk.borelog.interfaces.DialogItemSelected;

/**
 * @author Linson
 *
 */
public class BoreHoleInfoDetailPage extends BaseActivity implements OnClickListener, DialogItemSelected {

	Context context;
	RelativeLayout rigLayout,drillingMethodLayout,harmerIDNoLayout,northingLayout,eastingLayout,
	superVisorNameLayout,drillerNameLayout,asistantName1Layout,asistantName2Layout,
	asistantName3Layout,asistantName4Layout,remarksLayout;
	TextView rigValue,drillingMethodValue,harmerIdValue,northingValue,eastingValue,
	superVisorNameValue,drillerNameValue,asistantName1Value,asistantName2Value,
	asistantName3Value,asistantName4Value,remarksValue;
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
		drillingMethodLayout=(RelativeLayout)findViewById(R.id.drillingMethodLayout);
		drillingMethodLayout.setOnClickListener(this);
		harmerIDNoLayout=(RelativeLayout)findViewById(R.id.harmerIDLayout);
		harmerIDNoLayout.setOnClickListener(this);
		northingLayout=(RelativeLayout)findViewById(R.id.northingLayout);
		northingLayout.setOnClickListener(this);
		eastingLayout=(RelativeLayout)findViewById(R.id.eastingLayout);
		eastingLayout.setOnClickListener(this);
		drillerNameLayout=(RelativeLayout)findViewById(R.id.drillerNameLayout);
		drillerNameLayout.setOnClickListener(this);
		asistantName1Layout=(RelativeLayout)findViewById(R.id.assistantName1Layout);
		asistantName1Layout.setOnClickListener(this);
		asistantName2Layout=(RelativeLayout)findViewById(R.id.assistantName2Layout);
		asistantName2Layout.setOnClickListener(this);
		asistantName3Layout=(RelativeLayout)findViewById(R.id.assistantName3Layout);
		asistantName3Layout.setOnClickListener(this);
		asistantName4Layout=(RelativeLayout)findViewById(R.id.assistantName4Layout);
		asistantName4Layout.setOnClickListener(this);
		remarksLayout=(RelativeLayout)findViewById(R.id.remarksLayout);
		remarksLayout.setOnClickListener(this);
		
		rigValue=(TextView)findViewById(R.id.rigNumr);
		drillingMethodValue=(TextView)findViewById(R.id.drillingMethodValue);
		harmerIdValue=(TextView)findViewById(R.id.harmerIDValue);
		northingValue=(TextView)findViewById(R.id.northingValue);
		eastingValue=(TextView)findViewById(R.id.eastingValue);
		drillerNameValue=(TextView)findViewById(R.id.drillerNameValue);
		asistantName1Value=(TextView)findViewById(R.id.assistantName1Value);
		asistantName2Value=(TextView)findViewById(R.id.assistantName2Value);
		asistantName3Value=(TextView)findViewById(R.id.assistantName3Value);
		asistantName4Value=(TextView)findViewById(R.id.assistantName4Value);
		remarksValue=(TextView)findViewById(R.id.remarks);
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
		else if(v.getId()==R.id.rigNumrLayout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("RigNo"), 1);
			if(rigValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Rig Number",Arrays.asList(string).indexOf(rigValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Rig Number",0 , this,v);
		}
		else if(v.getId()==R.id.drillingMethodLayout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("DrillingMethod"), 1);
			if(drillingMethodValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Drilling Method",Arrays.asList(string).indexOf(drillingMethodValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Drilling Method",0 , this,v);
		}
		else if(v.getId()==R.id.harmerIDLayout){
			if(harmerIdValue.getText().toString().length()>0)
				showTextBoxDialog("Harmer Id", harmerIdValue.getText().toString(), this, v);
			else
				showTextBoxDialog("Harmer Id", "", this, v);
		}
		else if(v.getId()==R.id.northingLayout){
			Toast.makeText(context, "Not Implemented", Toast.LENGTH_SHORT).show();
			
		}
		else if(v.getId()==R.id.eastingLayout){
			
			Toast.makeText(context, "Not Implemented", Toast.LENGTH_SHORT).show();
		}
		else if(v.getId()==R.id.drillerNameLayout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("DrillerName"), 1);
			if(drillerNameValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Drilling Name",Arrays.asList(string).indexOf(drillerNameValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Drilling Name",0 , this,v);
		}
		else if(v.getId()==R.id.assistantName1Layout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("AssistantName"), 1);
			if(asistantName1Value.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Assistance Name",Arrays.asList(string).indexOf(asistantName1Value.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Assistance Name",0 , this,v);
		}
		else if(v.getId()==R.id.assistantName2Layout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("AssistantName"), 1);
			if(asistantName2Value.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Assistance Name",Arrays.asList(string).indexOf(asistantName2Value.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Assistance Name",0 , this,v);
		}
		else if(v.getId()==R.id.assistantName3Layout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("AssistantName"), 1);
			if(asistantName3Value.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Assistance Name",Arrays.asList(string).indexOf(asistantName3Value.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Assistance Name",0 , this,v);
		}
		else if(v.getId()==R.id.assistantName4Layout){
			
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("AssistantName"), 1);
			if(asistantName4Value.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Assistance Name",Arrays.asList(string).indexOf(asistantName4Value.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Assistance Name",0 , this,v);
		}
		else if(v.getId()==R.id.remarksLayout){
			
			if(remarksValue.getText().toString().length()>0)
				showTextBoxDialog("Remarks", remarksValue.getText().toString(), this, v);
			else
				showTextBoxDialog("Remarks", "", this, v);
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
			rigValue.setText(value);
		}
		else if(v.getId()==R.id.drillingMethodLayout){
			drillingMethodValue.setText(value);
		}
		else if(v.getId()==R.id.northingLayout){
			northingValue.setText(value);
		}
		else if(v.getId()==R.id.eastingLayout){
			eastingValue.setText(value);
		}
		else if(v.getId()==R.id.drillerNameLayout){
			drillerNameValue.setText(value);
		}
		else if(v.getId()==R.id.assistantName1Layout){
			asistantName1Value.setText(value);
		}
		else if(v.getId()==R.id.assistantName2Layout){
			asistantName2Value.setText(value);
		}
		else if(v.getId()==R.id.assistantName3Layout){
			asistantName3Value.setText(value);
		}
		else if(v.getId()==R.id.assistantName4Layout){
			asistantName4Value.setText(value);
		}
		else if(v.getId()==R.id.harmerIDLayout){
			harmerIdValue.setText(value);
		}
		else if(v.getId()==R.id.remarksLayout){
			remarksValue.setText(value);
		}
	}
	
}
