package com.jk.borelog.adapter;

import java.util.ArrayList;

import com.jk.borelog.R;
import com.jk.borelog.adapter.DailyJournalListAdapter.ViewHolder;
import com.jk.borelog.models.LookUpValueItems;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorPickerAdapter extends BaseAdapter{

		private Context context;
		ArrayList<LookUpValueItems>colorValueList=new ArrayList<LookUpValueItems>();
		public ColorPickerAdapter(Context c,ArrayList<LookUpValueItems>colorValueList) {
			this.context = c;
			this.colorValueList=colorValueList;
		}

		
		static class ViewHolder{
			private View colorView;
			private TextView colorName;
		}
		


		@Override
		public View getView(int arg0, View convertView, ViewGroup arg2) {
			View v = convertView;
			ViewHolder holder;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.color_picker_cell, null);
				holder = new ViewHolder();
				holder.colorName=(TextView) v.findViewById(R.id.colorText);
				holder.colorView=(View)v.findViewById(R.id.colorView);
				v.setTag(holder);
			
		}else{
			
			holder=(ViewHolder)v.getTag();
			
		}
			if(colorValueList.size()>0){
				holder.colorName.setText(colorValueList.get(arg0).lookUpValue1);
				holder.colorView.setBackgroundColor(Color.parseColor("#"+colorValueList.get(arg0).lookUpValue2));
			}
			
		
			return v;
		}






		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return colorValueList.size();
		}






		@Override
		public Object getItem(int position) {
			return null;
		}






		@Override
		public long getItemId(int position) {
			return 0;
		}

}
