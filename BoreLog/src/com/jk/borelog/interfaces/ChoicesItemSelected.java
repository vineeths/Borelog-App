/**
 * 
 *
 *
 */
package com.jk.borelog.interfaces;

import android.view.View;

/**
 * @author Linson
 *
 */
public interface ChoicesItemSelected {

	public void itemSelected(String selectedItem);
	public void cancelClicked();
	public void doneClicked(View v,int position,String seledtedItem);
}
