package com.jk.borelog.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.jk.borelog.models.AdminInfoItem;
import com.jk.borelog.models.LookUpValueItems;
import com.jk.borelog.models.ProjectInfoItem;

public class AdminInfoItemDBAdapter {

	  Context context;
    private SQLiteDatabase db;
    private BoreLogDBHelper dbHelper;
    public AdminInfoItemDBAdapter(Context context) {
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

    public Cursor getLookUpValueCursor(String moduleName) {
            
            Cursor  cursor = db.query(ProjectInfoItem.tableName, new String[] {
          		  LookUpValueItems.lookUpValue1_key, LookUpValueItems.lookUpValue2_key,
          		LookUpValueItems.lookUpValue3_key  },
                                    AdminInfoItem.moduleNameKey+"="+moduleName, null, null, null,null);
            
            return cursor;
    }  
    

    public void insertAdminInfoIem(AdminInfoItem adminInfoItem) {

            ContentValues newValue = new ContentValues();
            newValue.put(AdminInfoItem.moduleNameKey, adminInfoItem.moduleName);
            for (LookUpValueItems lookUpValueItems : adminInfoItem.lookUpValueItemList) {
            	newValue.put(LookUpValueItems.lookUpValue1_key, lookUpValueItems.lookUpValue1);
            	newValue.put(LookUpValueItems.lookUpValue2_key, lookUpValueItems.lookUpValue2);
            	newValue.put(LookUpValueItems.lookUpValue3_key, lookUpValueItems.lookUpValue3);
            	insertContentValue(newValue);
			}
    }

    public long insertContentValue(ContentValues newValues) {

        return db.insert(AdminInfoItem.tableName, null, newValues);
}

}
