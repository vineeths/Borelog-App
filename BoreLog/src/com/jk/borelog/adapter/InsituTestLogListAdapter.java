/**
 * 
 *
 *
 */
package com.jk.borelog.adapter;

import java.util.ArrayList;
import java.util.List;

import com.jk.borelog.R;
import com.jk.borelog.adapter.ProjectListAdapter.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author Linson
 *
 */
public class InsituTestLogListAdapter extends ArrayAdapter<String> {

	Context context;
	ArrayList<String>valueList;
	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public InsituTestLogListAdapter(Context context, int textViewResourceId,
			ArrayList<String> objects) {
		super(context, textViewResourceId, objects);
		this.valueList=objects;
		this.context=context;
	}
	static class ViewHolder{
		private TextView nameText;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ViewHolder holder;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.project_list_item, null);
			holder = new ViewHolder();
			holder.nameText=(TextView) v.findViewById(R.id.projectName);
			v.setTag(holder);
		
	}else{
		
		holder=(ViewHolder)v.getTag();
		
	}
	if (valueList.size()>0) {
		holder.nameText.setText(valueList.get(position));
	}
	
		return v;
	}
}
