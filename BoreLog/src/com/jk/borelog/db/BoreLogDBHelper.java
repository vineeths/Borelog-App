/**
 * 
 *
 *
 */
package com.jk.borelog.db;

import com.jk.borelog.models.AdminInfoItem;
import com.jk.borelog.models.BoreHoleInfoItem;
import com.jk.borelog.models.LastDayActivityLogItem;
import com.jk.borelog.models.LastDayBoreHoleInfo;
import com.jk.borelog.models.LastDayInsituLogItem;
import com.jk.borelog.models.ProjectInfoItem;
import com.jk.borelog.models.UserInfo;

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
	public static final int DATABASE_VERSION = 1;

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
		db.execSQL(UserInfo.createTableQuery);
		db.execSQL(AdminInfoItem.createTableQuery);
		db.execSQL(ProjectInfoItem.createTableQuery);
		db.execSQL(BoreHoleInfoItem.createTableQuery);
		db.execSQL(LastDayActivityLogItem.createTableQuery);
		db.execSQL(LastDayBoreHoleInfo.createTableQuery);
		db.execSQL(LastDayInsituLogItem.createTableQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + UserInfo.createTableQuery);
		db.execSQL("DROP TABLE IF EXISTS " + AdminInfoItem.createTableQuery);
		db.execSQL("DROP TABLE IF EXISTS " + ProjectInfoItem.createTableQuery);
		db.execSQL("DROP TABLE IF EXISTS " + BoreHoleInfoItem.createTableQuery);
		db.execSQL("DROP TABLE IF EXISTS " + LastDayActivityLogItem.createTableQuery);
		db.execSQL("DROP TABLE IF EXISTS " + LastDayBoreHoleInfo.createTableQuery);
		db.execSQL("DROP TABLE IF EXISTS " + LastDayInsituLogItem.createTableQuery);
		}
	

}
