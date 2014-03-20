/**
 * 
 *
 *
 */
package com.jk.borelog.adapter;

import java.util.ArrayList;

import com.jk.borelog.R;
import com.jk.borelog.adapter.ProjectListAdapter.ViewHolder;
import com.jk.borelog.models.BoreHoleInfoItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * @author Linson
 *
 */
public class BoreHoleNoSelectionListAdapter extends ArrayAdapter<BoreHoleInfoItem> {

	Context context;
	ArrayList<BoreHoleInfoItem>boreHoleInfoList=new ArrayList<BoreHoleInfoItem>();
	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public BoreHoleNoSelectionListAdapter(Context context,
			int textViewResourceId, ArrayList<BoreHoleInfoItem> objects) {
		super(context, textViewResourceId, objects);
		this.boreHoleInfoList=objects;
		this.context=context;
	}
	static class ViewHolder{
		private TextView boreHoleNoTxt;
		private CheckBox boreHoleCheckBox;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ViewHolder holder;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.borehole_list_item, null);
			holder = new ViewHolder();
			holder.boreHoleNoTxt=(TextView) v.findViewById(R.id.boreHoleText);
			holder.boreHoleCheckBox=(CheckBox)v.findViewById(R.id.boreHoleCheckBox);
			v.setTag(holder);
		
	}else{
		
		holder=(ViewHolder)v.getTag();
		
	}
	if (boreHoleInfoList.size()>0) {
		holder.boreHoleNoTxt.setText(boreHoleInfoList.get(position).boreHoleInfoNo);
	}
	
		return v;
	}
}
