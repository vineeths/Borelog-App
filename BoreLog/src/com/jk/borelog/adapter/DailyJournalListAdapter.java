/**
 * 
 *
 *
 */
package com.jk.borelog.adapter;

import java.util.ArrayList;
import java.util.List;

import com.jk.borelog.R;
import com.jk.borelog.adapter.BoreHoleNoSelectionListAdapter.ViewHolder;
import com.jk.borelog.models.LastDayActivityLogItem;

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
public class DailyJournalListAdapter extends ArrayAdapter<LastDayActivityLogItem> {

	
	Context context;
	ArrayList<LastDayActivityLogItem>dailyActivityLogList=new ArrayList<LastDayActivityLogItem>();
	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public DailyJournalListAdapter(Context context, int textViewResourceId,
			ArrayList<LastDayActivityLogItem> objects) {
		super(context, textViewResourceId, objects);
		this.context=context;
		dailyActivityLogList=objects;
	}
	static class ViewHolder{
		private TextView startTimeTxt;
		private TextView activityNameTxt;
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
			holder.startTimeTxt=(TextView) v.findViewById(R.id.startTime);
			holder.activityNameTxt=(TextView)v.findViewById(R.id.activityName);
			v.setTag(holder);
		
	}else{
		
		holder=(ViewHolder)v.getTag();
		
	}
	if (dailyActivityLogList.size()>0) {
		holder.startTimeTxt.setText(dailyActivityLogList.get(position).startTime);
		holder.activityNameTxt.setText(dailyActivityLogList.get(position).activity);
	}
	
		return v;
	}
	

}
