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
import com.jk.borelog.models.LastDayActivityLogItem;
import com.jk.borelog.models.ProjectInfoItem;

/**
 * @author Linson
 *
 */
public class ActivityLogItemDBAdapter {
	  Context context;
      private SQLiteDatabase db;
      private BoreLogDBHelper dbHelper;
      public ActivityLogItemDBAdapter(Context context) {
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

      public Cursor getAcitvityLogDetail(String projectGuid,String boreHoleID) {
              
              Cursor  cursor = db.query(LastDayActivityLogItem.tableName, new String[] {
            		  LastDayActivityLogItem.startTimeKey, LastDayActivityLogItem.activityKey,
            		  LastDayActivityLogItem.typeOfInstallationKey,LastDayActivityLogItem.depthKey  },
                                      ProjectInfoItem.projectGUID_key+"="+projectGuid+"AND"+BoreHoleInfoItem.boreHoleInfoNoKey+"="+boreHoleID,
                                      null, null, null,null);
              
              return cursor;
      }  
      

      public long insertActivityLogDetails(LastDayActivityLogItem lastActivityLogItem) {

              ContentValues newValue = new ContentValues();
              newValue.put(LastDayActivityLogItem.startTimeKey, lastActivityLogItem.startTime);
              newValue.put(LastDayActivityLogItem.activityKey, lastActivityLogItem.activity);
              newValue.put(LastDayActivityLogItem.typeOfInstallationKey, lastActivityLogItem.typeOfInstallation);
              newValue.put(LastDayActivityLogItem.depthKey, lastActivityLogItem.depth);
              return db.insert(LastDayActivityLogItem.tableName, null, newValue);
      }

     
}
