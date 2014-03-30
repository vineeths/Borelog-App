/**
 * 
 *
 *
 */
package com.jk.borelog.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Linson
 *
 */
public class BoreLogDBHelper extends SQLiteOpenHelper{

	public static final String DATABASE_NAME = "Borelog.db";
	public static final int DATABASE_VERSION = 0;

	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public BoreLogDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
