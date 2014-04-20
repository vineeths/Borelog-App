/**
 * 
 *
 *
 */
package com.jk.borelog;

import java.util.Arrays;

import org.w3c.dom.Text;

import com.actionbarsherlock.app.ActionBar;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.interfaces.DialogItemSelected;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

/**
 * @author Linson
 *
 */
public class AddRockTypeEntryPage extends BaseActivity implements OnClickListener,DialogItemSelected{

	Context context;
	Button rockStrngthFrmBt,rockStrngthToBt,spacingFrmBt,spacingtToBt,roughFrmBt,roughToBt,
	apertureFrmBt,apertureToBt;
	RelativeLayout intensityLayout,patternLayout,grainLayout,rockNameLayout,clanLayout,
	rockCmmnLayout,whthringDscrptnLayout,inclusionsLayout,typeLayout,infillingLayout,
	geoFormationLayout,gradeLayout,remarksLayout,secndryColor1Layout,secndryColor2Layout,
	primaryColor1Layout,primaryColor2Layout,primaryColor3Layout,primaryColor4Layout;
	TextView intensityValue,patternValue,grainValue,rockNameValue,clanValue,
	rockCmmnValue,whthringDscrptnValue,inclusionsValue,typeValue,infillingValue,
	geoFormationValue,gradeValue,remarksValue,secndryColor1Value,secndryColor2Value,
	primaryColor1Value,primaryColor2Value,primaryColor3Value,primaryColor4Value;
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
		intensityLayout=(RelativeLayout)findViewById(R.id.intensityLayout);
		intensityLayout.setOnClickListener(this);
		patternLayout=(RelativeLayout)findViewById(R.id.patternLayout);
		patternLayout.setOnClickListener(this);
		grainLayout=(RelativeLayout)findViewById(R.id.grainSizeLayout);
		grainLayout.setOnClickListener(this);
		rockNameLayout=(RelativeLayout)findViewById(R.id.rockNameLayout);
		rockNameLayout.setOnClickListener(this);
		clanLayout=(RelativeLayout)findViewById(R.id.clanLayout);
		clanLayout.setOnClickListener(this);
		rockCmmnLayout=(RelativeLayout)findViewById(R.id.rankCommonLayout);
		rockCmmnLayout.setOnClickListener(this);
		whthringDscrptnLayout=(RelativeLayout)findViewById(R.id.wheatherDescriptionLayout);
		whthringDscrptnLayout.setOnClickListener(this);
		inclusionsLayout=(RelativeLayout)findViewById(R.id.inclusionRockTypeLayout);
		inclusionsLayout.setOnClickListener(this);
		typeLayout=(RelativeLayout)findViewById(R.id.typeLayout);
		typeLayout.setOnClickListener(this);
		infillingLayout=(RelativeLayout)findViewById(R.id.inFillingLayout);
		infillingLayout.setOnClickListener(this);
		geoFormationLayout=(RelativeLayout)findViewById(R.id.geologicalFormationLayout);
		geoFormationLayout.setOnClickListener(this);
		gradeLayout=(RelativeLayout)findViewById(R.id.gradeLayout);
		gradeLayout.setOnClickListener(this);
		remarksLayout=(RelativeLayout)findViewById(R.id.remarksLayout);
		remarksLayout.setOnClickListener(this);
		secndryColor1Layout=(RelativeLayout)findViewById(R.id.secondaryColor1Layout);
		secndryColor1Layout.setOnClickListener(this);
		secndryColor2Layout=(RelativeLayout)findViewById(R.id.secondaryColor2Layout);
		secndryColor2Layout.setOnClickListener(this);
		primaryColor1Layout=(RelativeLayout)findViewById(R.id.primaryColor1Layout);
		primaryColor1Layout.setOnClickListener(this);
		primaryColor2Layout=(RelativeLayout)findViewById(R.id.primaryColor2Layout);
		primaryColor2Layout.setOnClickListener(this);
		primaryColor3Layout=(RelativeLayout)findViewById(R.id.primaryColor3Layout);
		primaryColor3Layout.setOnClickListener(this);
		primaryColor4Layout=(RelativeLayout)findViewById(R.id.primaryColor4Layout);
		primaryColor4Layout.setOnClickListener(this);
		
		rockStrngthFrmBt=(Button)findViewById(R.id.rockStrengthFromCategoryBt);
		rockStrngthFrmBt.setOnClickListener(this);
		rockStrngthToBt=(Button)findViewById(R.id.rockStrengthToCategoryBt);
		rockStrngthToBt.setOnClickListener(this);
		spacingFrmBt=(Button)findViewById(R.id.spacingFromBt);
		spacingFrmBt.setOnClickListener(this);
		spacingtToBt=(Button)findViewById(R.id.spacingToBt);
		spacingtToBt.setOnClickListener(this);
		roughFrmBt=(Button)findViewById(R.id.roughnessFromBt);
		roughFrmBt.setOnClickListener(this);
		roughToBt=(Button)findViewById(R.id.roughnessToBt);
		roughToBt.setOnClickListener(this);
		apertureFrmBt=(Button)findViewById(R.id.apertureFromBt);
		apertureFrmBt.setOnClickListener(this);
		apertureToBt=(Button)findViewById(R.id.apertureToBt);
		apertureToBt.setOnClickListener(this);
		
		intensityValue=(TextView)findViewById(R.id.intensity);
		patternValue=(TextView)findViewById(R.id.pattern);
		grainValue=(TextView)findViewById(R.id.grainSize);
		rockNameValue=(TextView)findViewById(R.id.rockName);
		clanValue=(TextView)findViewById(R.id.clan);
		rockCmmnValue=(TextView)findViewById(R.id.rankCommon);
		whthringDscrptnValue=(TextView)findViewById(R.id.wheatherDescription);
		inclusionsValue=(TextView)findViewById(R.id.inclusionRockType);
		typeValue=(TextView)findViewById(R.id.type);
		infillingValue=(TextView)findViewById(R.id.inFilling);
		geoFormationValue=(TextView)findViewById(R.id.geologicalFormation);
		gradeValue=(TextView)findViewById(R.id.grade);
		remarksValue=(TextView)findViewById(R.id.remarks);
		secndryColor1Value=(TextView)findViewById(R.id.secondaryColor1);
		secndryColor2Value=(TextView)findViewById(R.id.secondaryColor2);
		primaryColor1Value=(TextView)findViewById(R.id.primaryColor1);
		primaryColor2Value=(TextView)findViewById(R.id.primaryColor2);
		primaryColor3Value=(TextView)findViewById(R.id.primaryColor3);
		primaryColor4Value=(TextView)findViewById(R.id.primaryColor4);
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
	public void onClick(View v) {
		if (v.getId()==R.id.leftBarButton) {
			finish();
		}
		else if (v==rockStrngthFrmBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("RockStrength"), 1);
			if(rockStrngthFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "RockStrength",Arrays.asList(string).indexOf(rockStrngthFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "RockStrength",0 , this,v);
		}
		else if (v==rockStrngthToBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("RockStrength"), 1);
			if(rockStrngthToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "RockStrength",Arrays.asList(string).indexOf(rockStrngthToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "RockStrength",0 , this,v);
		}
		else if (v==intensityLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Intensity"), 1);
			if(intensityValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Intensity",Arrays.asList(string).indexOf(intensityValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Intensity",0 , this,v);
		}
		else if (v==patternLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Pattern"), 1);
			if(patternValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Pattern",Arrays.asList(string).indexOf(patternValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Pattern",0 , this,v);
		}
		else if (v==grainLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("GrainSize"), 1);
			if(grainValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Grain Size",Arrays.asList(string).indexOf(grainValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Grain Size",0 , this,v);
		}
		else if (v==rockNameLayout) {
			String string[]=new String[]{"Igneous","Sedimentary"};
			if(rockNameValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Rock Name",Arrays.asList(string).indexOf(rockNameValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Rock Name",0 , this,v);
		}
		else if (v==clanLayout) {
			String string[]=new String[]{"Acid Clan","Intermediate Clan","Ultrabasic Clan","Basic Clan"};
			if(rockNameValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Clan",Arrays.asList(string).indexOf(rockNameValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Clan",0 , this,v);
		}
		else if (v==rockCmmnLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("RockCommonName"), 1);
			if(rockCmmnValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Rock Common Name",Arrays.asList(string).indexOf(rockCmmnValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Rock Common Name",0 , this,v);
		}
		else if (v==whthringDscrptnLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("WeatheringDescription-RockType"), 1);
			if(whthringDscrptnValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Weathering Description",Arrays.asList(string).indexOf(whthringDscrptnValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Weathering Description",0 , this,v);
		}
		else if (v==inclusionsLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Inclusions"), 1);
			if(inclusionsValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Inclusions",Arrays.asList(string).indexOf(inclusionsValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Inclusions",0 , this,v);
		}
		else if (v==spacingFrmBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Spacing"), 1);
			if(spacingFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Spacing",Arrays.asList(string).indexOf(spacingFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Spacing",0 , this,v);
		}
		else if (v==spacingtToBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Spacing"), 1);
			if(spacingtToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Spacing",Arrays.asList(string).indexOf(spacingtToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Spacing",0 , this,v);
		}
		else if (v==roughFrmBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Roughness"), 1);
			if(roughFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Roughness",Arrays.asList(string).indexOf(roughFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Roughness",0 , this,v);
		}
		else if (v==roughToBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Roughness"), 1);
			if(roughToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Roughness",Arrays.asList(string).indexOf(roughToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Roughness",0 , this,v);
		}
		else if (v==apertureFrmBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Aperture"), 1);
			if(apertureFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Aperture",Arrays.asList(string).indexOf(apertureFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Aperture",0 , this,v);
		}
		else if (v==apertureToBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Aperture"), 1);
			if(apertureToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Aperture",Arrays.asList(string).indexOf(apertureToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Aperture",0 , this,v);
		}
		else if (v==typeLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Type"), 1);
			if(typeValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Type",Arrays.asList(string).indexOf(typeValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Type",0 , this,v);
		}
		else if (v==infillingLayout) {
			if(infillingValue.getText().toString().length()>0)
				showTextBoxDialog("Infilling", infillingValue.getText().toString(), this, v);
			else
				showTextBoxDialog("Infilling", "", this, v);
		}
		else if (v==geoFormationLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("GeologicalFormation-RockType"), 1);
			if(geoFormationValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Geological Formation",Arrays.asList(string).indexOf(geoFormationValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Geological Formation",0 , this,v);
		}
		else if (v==gradeLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("GeologicalFormation-RockType"), 1);
			if(gradeValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Geological Formation",Arrays.asList(string).indexOf(gradeValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Geological Formation",0 , this,v);
		}
		else if (v==remarksLayout) {
			if(remarksValue.getText().toString().length()>0)
				showTextBoxDialog("Remarks", remarksValue.getText().toString(), this, v);
			else
				showTextBoxDialog("Remarks", "", this, v);
		}
		else if (v==secndryColor1Layout) {
				showColorPickerDialog(getLookUpValuesForModuleName("ColorSelection-Secondary"), "Secondory Color 1", this, v);
		}
		else if (v==secndryColor2Layout) {
			showColorPickerDialog(getLookUpValuesForModuleName("ColorSelection-Secondary"), "Secondory Color 1", this, v);
		}
		else if (v==primaryColor1Layout) {
			showColorPickerDialog(getLookUpValuesForModuleName("ColorSelection-Secondary"), "Secondory Color 1", this, v);
		}
		else if (v==primaryColor2Layout) {
			showColorPickerDialog(getLookUpValuesForModuleName("ColorSelection-Secondary"), "Secondory Color 1", this, v);
		}
		else if (v==primaryColor3Layout) {
			showColorPickerDialog(getLookUpValuesForModuleName("ColorSelection-Secondary"), "Secondory Color 1", this, v);
		}
		else if (v==primaryColor4Layout) {
			showColorPickerDialog(getLookUpValuesForModuleName("ColorSelection-Secondary"), "Secondory Color 1", this, v);
		}
		 
	}

	@Override
	public void itemSelected(String selectedItem) {
		
	}

	@Override
	public void cancelClicked() {
		
	}

	@Override
	public void doneClicked(View v, int position, String seledtedItem) {
		if(v==rockStrngthFrmBt){
			rockStrngthFrmBt.setText(seledtedItem);
		}
		else if (v==rockStrngthToBt) {
			rockStrngthToBt.setText(seledtedItem);
		}
		else if (v==intensityLayout) {
			intensityValue.setText(seledtedItem);
		}
		else if (v==patternLayout) {
			patternValue.setText(seledtedItem);
		}
		else if (v==grainLayout) {
			grainValue.setText(seledtedItem);
		}
		else if (v==rockNameLayout) {
			rockNameValue.setText(seledtedItem);
		}
		else if (v==whthringDscrptnLayout) {
			whthringDscrptnValue.setText(seledtedItem);
		}
		else if (v==inclusionsLayout) {
			inclusionsValue.setText(seledtedItem);
		}
		else if (v==spacingFrmBt) {
			spacingFrmBt.setText(seledtedItem);
		}
		else if (v==spacingtToBt) {
			spacingtToBt.setText(seledtedItem);
		}
		else if (v==roughFrmBt) {
			roughFrmBt.setText(seledtedItem);
		}
		else if (v==roughToBt) {
			roughToBt.setText(seledtedItem);
		}
		else if (v==apertureFrmBt) {
			apertureFrmBt.setText(seledtedItem);
		}
		else if (v==apertureToBt) {
			apertureToBt.setText(seledtedItem);
		}
		else if (v==typeLayout) {
			typeValue.setText(seledtedItem);
		}
		else if (v==geoFormationLayout) {
			geoFormationValue.setText(seledtedItem);
		}
		else if (v==infillingLayout) {
			infillingValue.setText(seledtedItem);
		}
		else if (v==remarksLayout) {
			remarksValue.setText(seledtedItem);
		}
	}
	
	
}
