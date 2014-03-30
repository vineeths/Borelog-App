/**
 * 
 *
 *
 */
package com.jk.borelog.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.jk.borelog.models.BoreHoleInfoItem;
import com.jk.borelog.models.ProjectInfoItem;

/**
 * @author Linson
 *
 */
public class BoreHoleIeInfoIDBAdapter {

	  Context context;
    private SQLiteDatabase db;
    private BoreLogDBHelper dbHelper;
    public BoreHoleIeInfoIDBAdapter(Context context) {
            super();
            dbHelper = new BoreLogDBHelper(context,
                            BoreLogDBHelper.DATABASE_NAME, null,
                            BoreLogDBHelper.DATABASE_VERSION);
            this.context = context;
    
    }

    public void close() {
            if (db.isOpen())
                    db.close();
    }

    public void open() throws SQLiteException {
            try {
                    db = dbHelper.getWritableDatabase();
            } catch (SQLiteException ex) {
                    db = dbHelper.getReadableDatabase();
            }
    }

    public Cursor getAllBoreHoleDetail(String projectGuid) {
            
            Cursor  cursor = db.query(BoreHoleInfoItem.tableName, new String[] {
            		BoreHoleInfoItem.boreHoleInfoNoKey, BoreHoleInfoItem.boreHolIdKey
            		,ProjectInfoItem.projectGUID_key
            		},ProjectInfoItem.projectGUID_key+"="+projectGuid, null, null, null,null);
            
            return cursor;
    }  
   

    public long insertBoreHoleDetails(BoreHoleInfoItem boreInfoItem) {

            ContentValues newValue = new ContentValues();
            newValue.put(ProjectInfoItem.projectGUID_key, boreInfoItem.boreHoleprojectGUID);
            newValue.put(BoreHoleInfoItem.boreHoleInfoNoKey, boreInfoItem.boreHoleInfoNo);
            newValue.put(BoreHoleInfoItem.boreHolIdKey, boreInfoItem.boreHoleId);
            
            return db.insert(ProjectInfoItem.tableName, null, newValue);
    }

   


}
