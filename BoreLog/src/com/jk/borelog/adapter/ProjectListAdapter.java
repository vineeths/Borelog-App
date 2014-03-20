/**
 * 
 *
 *
 */
package com.jk.borelog.adapter;

import java.util.ArrayList;
import java.util.List;

import com.jk.borelog.R;
import com.jk.borelog.models.ProjectInfoItem;

import android.content.Context;
import android.media.JetPlayer.OnJetEventListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author Linson
 *
 */
public class ProjectListAdapter extends ArrayAdapter<ProjectInfoItem>{

	Context context;
	ArrayList<ProjectInfoItem>projectList=new ArrayList<ProjectInfoItem>();
	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public ProjectListAdapter(Context context, int textViewResourceId,
			ArrayList<ProjectInfoItem> objects) {
		super(context, textViewResourceId, objects);
		this.projectList=objects;
		this.context=context;
	}
	static class ViewHolder{
		private TextView projectNameTxt;
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
			holder.projectNameTxt=(TextView) v.findViewById(R.id.projectName);
			v.setTag(holder);
		
	}else{
		
		holder=(ViewHolder)v.getTag();
		
	}
	if (projectList.size()>0) {
		holder.projectNameTxt.setText(projectList.get(position).projectName);
	}
	
		return v;
	}
	

}
