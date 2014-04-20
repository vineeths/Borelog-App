/**
 * @author Linson
 *
 * 
 */
package com.jk.borelog.common;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockActivity;
import com.jk.borelog.R;
import com.jk.borelog.adapter.ColorPickerAdapter;
import com.jk.borelog.interfaces.DialogItemSelected;
import com.jk.borelog.models.AdminInfoItem;
import com.jk.borelog.models.LookUpValueItems;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BaseActivity extends SherlockActivity {
	int itemPosition;
	public void showAlertMessage(String title,String message){
		new AlertDialog.Builder(this)
	    .setTitle(title)
	    .setMessage(message)
	    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        }
	     })	    
	    .setIcon(R.drawable.ic_launcher)
	     .show();
	}
	
	public void showChoiceBoxDialog(final String string[],String title,int selectedPosition,final DialogItemSelected itemSelected,final View v){
		itemPosition=selectedPosition;
		new AlertDialog.Builder(this)
	    .setTitle(title)
	           .setSingleChoiceItems(string, selectedPosition,
	                      new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					itemPosition=which;
				}
	           })
	           .setPositiveButton("Done", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   itemSelected.doneClicked(v, itemPosition,string[itemPosition]);
	               }
	           })
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   itemSelected.cancelClicked();
	               }
	           })

	    .create()
	    .show();
	}
	public void showTextBoxDialog(final String title,final String inputValue,final DialogItemSelected itemSelected,final View v){
		final EditText input=new EditText(BaseActivity.this);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
		input.setInputType(EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE | EditorInfo.TYPE_TEXT_FLAG_IME_MULTI_LINE);
		input.setMaxLines(Integer.MAX_VALUE);
		input.setHorizontallyScrolling(false);
		input.setLayoutParams(lp);
		
		if(inputValue.length()>0){
			input.setText(inputValue);
		}
		new AlertDialog.Builder(this)
	    .setTitle(title)
	    .setView(input)       
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	               }
	           })

	    .create()
	    .show();
	}
	public void showColorPickerDialog(final ArrayList<LookUpValueItems> lookupList,String title,final DialogItemSelected itemSelected,final View v){
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);     
        View layout = inflater.inflate(R.layout.color_picker_view,(ViewGroup) findViewById(R.id.layout_root));     
        GridView gridview = (GridView)layout.findViewById(R.id.colorPickerGridView);     
        gridview.setAdapter(new ColorPickerAdapter(this, lookupList));     
          
        gridview.setOnItemClickListener(new OnItemClickListener()     
        {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(BaseActivity.this, " "+arg2, Toast.LENGTH_LONG).show();
			}  
              
        });  
		new AlertDialog.Builder(this)
	    .setTitle(title)
	    .setView(layout)
	           .setPositiveButton("Done", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   itemSelected.doneClicked(v, itemPosition,lookupList.get(itemPosition).lookUpValue1);
	               }
	           })
	           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   itemSelected.cancelClicked();
	               }
	           })

	    .create()
	    .show();
	}
	protected void showToast(String msg) {
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
	}

	public ArrayList<LookUpValueItems> getLookUpValuesForModuleName(String moduleName){
		ArrayList<LookUpValueItems>lookUpValueItemList=new ArrayList<LookUpValueItems>();
		for(AdminInfoItem item:Globals.adminInfoItemList){
			if(item.moduleName !=null && item.moduleName.equalsIgnoreCase(moduleName)){
				Log.i("AdminLookup", "Size of lookuplist "+item.lookUpValueItemList.size());
				Log.i("AdminLookup", "val of lookup 1 "+item.lookUpValueItemList.get(0).lookUpValue2);
				lookUpValueItemList= item.lookUpValueItemList;
				for (int i = 0; i < lookUpValueItemList.size(); i++) {
					Log.i("AdminLookup", "lookupvalue1 "+lookUpValueItemList.get(i).lookUpValue1);
				}
			}
		}
		return lookUpValueItemList;
	}
	public String[] getArrayForLookUpValue(ArrayList<LookUpValueItems> lookUpValueList,int lookUpValueNumber){
		Log.i("LookUpArray", "lookup Value list size "+lookUpValueList.size() +"\n lookUpValueNumber "+lookUpValueNumber);
		String[] lookUpValueArray=new String[lookUpValueList.size()];
	
		for (int i = 0; i < lookUpValueList.size(); i++) {
			LookUpValueItems item=lookUpValueList.get(i);
			lookUpValueArray[i]=item.lookUpValue1;
			if (lookUpValueNumber==Integer.parseInt("1")) {
				lookUpValueArray[i]=item.lookUpValue1;
			} else if (lookUpValueNumber==Integer.parseInt("2")) {
				lookUpValueArray[i]=item.lookUpValue2;
			}else if (lookUpValueNumber==Integer.parseInt("3")) {
				lookUpValueArray[i]=item.lookUpValue3;
			}
		}
		return lookUpValueArray;
	}
}
