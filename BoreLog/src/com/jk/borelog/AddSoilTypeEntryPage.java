/**
 * 
 *
 *
 */
package com.jk.borelog;

import java.util.Arrays;

import com.actionbarsherlock.app.ActionBar;
import com.jk.borelog.common.BaseActivity;
import com.jk.borelog.interfaces.DialogItemSelected;

import android.app.Activity;
import android.content.ContentValues;
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
public class AddSoilTypeEntryPage extends BaseActivity implements OnClickListener,DialogItemSelected{

	Context  context;
	RelativeLayout principleSoilTypeLayout,soilDescrptnLayout,secndrySoilType1Layout,
	secndrySoilType2Layout,intensityLayout,patternLayout,whetherDescriptionLayout,
	textureLayout,geoClasificationLayout,geoFormationLayout,geoMemberLayout;
	TextView princpleSoileTypeValue,soilDescriptionValue,secndrySoilType1,
	secndrySoilType2,intensityValue,patternValue,whetherDescriptionValue,
	textureValue,geoClasficationValue,geoFormationValue,geoMemberValue;
	Button soilStrengthFrmBt,soilStrengthToBt,inclusionFrmBt,inclusionToBt,
			particleSizeFrmBt,particleSizeToBt,particleShapeFrmBt,particleShapeToBt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_soil_type_entry);
		init();
	}
	/**
	 * 
	 */
	private void init() {
		context=AddSoilTypeEntryPage.this;
		setUpActionBar();
		principleSoilTypeLayout=(RelativeLayout)findViewById(R.id.principleSoilTypeLayout);
		principleSoilTypeLayout.setOnClickListener(this);
		soilDescrptnLayout=(RelativeLayout)findViewById(R.id.soilDescriptionLayout);
		soilDescrptnLayout.setOnClickListener(this);
		secndrySoilType1Layout=(RelativeLayout)findViewById(R.id.secondarySoilType1Layout);
		secndrySoilType1Layout.setOnClickListener(this);
		secndrySoilType2Layout=(RelativeLayout)findViewById(R.id.secondarySoilType2Layout);
		secndrySoilType2Layout.setOnClickListener(this);
		intensityLayout=(RelativeLayout)findViewById(R.id.intensityLayout);
		intensityLayout.setOnClickListener(this);
		patternLayout=(RelativeLayout)findViewById(R.id.patternLayout);
		patternLayout.setOnClickListener(this);
		whetherDescriptionLayout=(RelativeLayout)findViewById(R.id.wheatherDescriptionLayout);
		whetherDescriptionLayout.setOnClickListener(this);
		textureLayout=(RelativeLayout)findViewById(R.id.textureLayout);
		textureLayout.setOnClickListener(this);
		geoClasificationLayout=(RelativeLayout)findViewById(R.id.geologicalClsfctnLayout);
		geoClasificationLayout.setOnClickListener(this);
		geoFormationLayout=(RelativeLayout)findViewById(R.id.geologicalfrmtnLayout);
		geoFormationLayout.setOnClickListener(this);
		geoMemberLayout=(RelativeLayout)findViewById(R.id.geologicalMmbrLayout);
		geoMemberLayout.setOnClickListener(this);
		
		soilStrengthFrmBt=(Button)findViewById(R.id.soilStrengthFromCategoryBt);
		soilStrengthFrmBt.setOnClickListener(this);
		soilStrengthToBt=(Button)findViewById(R.id.soilStrengthToCategoryBt);
		soilStrengthToBt.setOnClickListener(this);
		inclusionFrmBt=(Button)findViewById(R.id.inclusionFromBt);
		inclusionFrmBt.setOnClickListener(this);
		inclusionToBt=(Button)findViewById(R.id.inclusionToBt);
		inclusionToBt.setOnClickListener(this);
		particleSizeFrmBt=(Button)findViewById(R.id.particleSizeFromBt);
		particleSizeFrmBt.setOnClickListener(this);
		particleSizeToBt=(Button)findViewById(R.id.particleSizeToBt);
		particleSizeToBt.setOnClickListener(this);
		
		particleShapeFrmBt=(Button)findViewById(R.id.particleShapeFromBt);
		particleShapeFrmBt.setOnClickListener(this);
		particleShapeToBt=(Button)findViewById(R.id.particleShapeToBt);
		particleShapeToBt.setOnClickListener(this);
		
		princpleSoileTypeValue=(TextView)findViewById(R.id.principleSoilType);
		soilDescriptionValue=(TextView)findViewById(R.id.soilDescription);
		secndrySoilType1=(TextView)findViewById(R.id.secondarySoilType1);
		secndrySoilType2=(TextView)findViewById(R.id.secondarySoilType2);
		intensityValue=(TextView)findViewById(R.id.intensity);
		patternValue=(TextView)findViewById(R.id.pattern);
		whetherDescriptionValue=(TextView)findViewById(R.id.wheatherDescription);
		textureValue=(TextView)findViewById(R.id.texture);
		geoClasficationValue=(TextView)findViewById(R.id.geologicalClsfctn);
		geoFormationValue=(TextView)findViewById(R.id.geologicalFormation);
		geoMemberValue=(TextView)findViewById(R.id.geologicalMmbr);
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
		title.setText("Add Soil Type Entry");
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
		else if (v.getId()==R.id.principleSoilTypeLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("PrincipalSoilType"), 1);
			if(princpleSoileTypeValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Principal Soil Type",Arrays.asList(string).indexOf(princpleSoileTypeValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Principal Soil Type",0 , this,v);
		}
		else if (v.getId()==R.id.soilStrengthFromCategoryBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("SoilStrength-CohesiveSoils"), 1);
			if(soilStrengthFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Soil Strength",Arrays.asList(string).indexOf(soilStrengthFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Soil Strength",0 , this,v);
		}
		else if (v.getId()==R.id.soilStrengthToCategoryBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("SoilStrength-GranularSoils"), 1);
			if(soilStrengthToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Soil Strength",Arrays.asList(string).indexOf(soilStrengthToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Soil Strength",0 , this,v);
		}
		else if (v.getId()==R.id.soilDescriptionLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("SoilDescription"), 1);
			if(soilDescriptionValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Soil Description",Arrays.asList(string).indexOf(soilDescriptionValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, " Soil Description",0 , this,v);
		}
		else if (v.getId()==R.id.secondarySoilType1Layout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("SecondarySoilType"), 1);
			if(soilDescriptionValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Secondary Soil Type",Arrays.asList(string).indexOf(secndrySoilType1.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Secondary Soil Type",0 , this,v);
		}
		else if (v.getId()==R.id.secondarySoilType2Layout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("SecondarySoilType"), 1);
			if(soilDescriptionValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Secondary Soil Type",Arrays.asList(string).indexOf(secndrySoilType2.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Secondary Soil Type",0 , this,v);
		}
		else if (v.getId()==R.id.inclusionFromBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Inclusions"), 1);
			if(inclusionFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Inclusions",Arrays.asList(string).indexOf(inclusionFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Inclusions",0 , this,v);
		}
		else if (v.getId()==R.id.inclusionToBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Inclusions"), 1);
			if(inclusionToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Inclusions",Arrays.asList(string).indexOf(inclusionToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Inclusions",0 , this,v);
		}
		else if (v.getId()==R.id.particleSizeFromBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("ParticleSize"), 1);
			if(particleSizeFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Particle Size",Arrays.asList(string).indexOf(particleSizeFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Particle Size",0 , this,v);
		}
		else if (v.getId()==R.id.particleSizeToBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("ParticleSize"), 1);
			if(particleSizeToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Particle Size",Arrays.asList(string).indexOf(particleSizeToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Particle Size",0 , this,v);
		}
		
		else if (v.getId()==R.id.particleShapeFromBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("ParticleShape"), 1);
			if(particleShapeFrmBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Particle Shape",Arrays.asList(string).indexOf(particleShapeFrmBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Particle Shape",0 , this,v);
		}
		else if (v.getId()==R.id.particleShapeToBt) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("ParticleShape"), 1);
			if(particleShapeToBt.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Particle Shape",Arrays.asList(string).indexOf(particleShapeToBt.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Particle Shape",0 , this,v);
		}
		else if (v.getId()==R.id.intensityLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Intensity"), 1);
			if(intensityValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Intensity",Arrays.asList(string).indexOf(intensityValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Intensity",0 , this,v);
		}
		else if (v.getId()==R.id.patternLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Pattern"), 1);
			if(patternValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Pattern",Arrays.asList(string).indexOf(patternValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Pattern",0 , this,v);
		}
		else if (v.getId()==R.id.wheatherDescriptionLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("WeatheringDescription-SoilType"), 1);
			if(whetherDescriptionValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Weathering Description",Arrays.asList(string).indexOf(whetherDescriptionValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Weathering Description",0 , this,v);
		}
		else if (v.getId()==R.id.textureLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("Texture"), 1);
			if(textureValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Texture",Arrays.asList(string).indexOf(textureValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Texture",0 , this,v);
		}
		else if (v.getId()==R.id.geologicalClsfctnLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("GeologicalClassification-SoilType"), 1);
			if(geoClasficationValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Geological Classification",Arrays.asList(string).indexOf(geoClasficationValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Geological Classification",0 , this,v);
		}
		else if (v.getId()==R.id.geologicalfrmtnLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("GeologicalFormation-SoilType"), 1);
			if(geoFormationValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Geological Formation",Arrays.asList(string).indexOf(geoFormationValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Geological Formation",0 , this,v);
		}
		else if (v.getId()==R.id.geologicalMmbrLayout) {
			String string[]=getArrayForLookUpValue(getLookUpValuesForModuleName("GeologicalFormationMember"), 1);
			if(geoMemberValue.getText().toString().length()>0)
				showChoiceBoxDialog(string, "Geological Formation Member",Arrays.asList(string).indexOf(geoMemberValue.getText().toString()) , this,v);
			else 
				showChoiceBoxDialog(string, "Geological Formation Member",0 , this,v);
		}
		
	}
	@Override
	public void itemSelected(String selectedItem) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cancelClicked() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doneClicked(View v, int position, String seledtedItem) {
		if(v.getId()==R.id.principleSoilTypeLayout){
			princpleSoileTypeValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.soilStrengthFromCategoryBt){
			soilStrengthFrmBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.soilStrengthToCategoryBt){
			soilStrengthToBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.soilDescriptionLayout){
			soilDescriptionValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.secondarySoilType1Layout){
			secndrySoilType1.setText(seledtedItem);
		}
		else if(v.getId()==R.id.secondarySoilType2Layout){
			secndrySoilType2.setText(seledtedItem);
		}
		else if(v.getId()==R.id.inclusionFromBt){
			inclusionFrmBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.inclusionToBt){
			inclusionToBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.particleSizeFromBt){
			particleSizeFrmBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.particleSizeToBt){
			particleSizeToBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.particleShapeFromBt){
			particleShapeFrmBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.particleShapeToBt){
			particleShapeToBt.setText(seledtedItem);
		}
		else if(v.getId()==R.id.intensityLayout){
			intensityValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.patternLayout){
			patternValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.wheatherDescriptionLayout){
			whetherDescriptionValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.textureLayout){
			textureValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.geologicalClsfctnLayout){
			geoClasficationValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.geologicalfrmtnLayout){
			geoFormationValue.setText(seledtedItem);
		}
		else if(v.getId()==R.id.geologicalMmbrLayout){
			geoMemberValue.setText(seledtedItem);
		}
	}
	
	

}
