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
import com.jk.borelog.models.LastDayInsituLogItem;
import com.jk.borelog.models.ProjectInfoItem;

/**
 * @author Linson
 *
 */
public class InsituLogItemDBAdapter {
	  Context context;
      private SQLiteDatabase db;
      private BoreLogDBHelper dbHelper;
      public InsituLogItemDBAdapter(Context context) {
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

      public Cursor getInsituLogDetail(String projectGuid,String boreHoleID) {
              
              Cursor  cursor = db.query(LastDayActivityLogItem.tableName, new String[] {
            		  LastDayInsituLogItem.insituTypeKey, LastDayInsituLogItem.descriptionKey,
            		  LastDayInsituLogItem.totalKey,LastDayInsituLogItem.presentationKey,
            		  LastDayInsituLogItem.recoveryKey,LastDayInsituLogItem.value1Key,
            		  LastDayInsituLogItem.value2Key,
            		  LastDayInsituLogItem.value3Key,
            		  LastDayInsituLogItem.value4Key,
            		  LastDayInsituLogItem.value5Key,
            		  LastDayInsituLogItem.value6Key,
            		  LastDayInsituLogItem.value7Key,
            		  LastDayInsituLogItem.value8Key,
            		  LastDayInsituLogItem.value9Key},
                                      ProjectInfoItem.projectGUID_key+"="+projectGuid+"AND"+BoreHoleInfoItem.boreHoleInfoNoKey+"="+boreHoleID,
                                      null, null, null,null);
              
              return cursor;
      }  
      

      public long insertActivityLogDetails(LastDayInsituLogItem lastDayInsituLogItem) {

              ContentValues newValue = new ContentValues();
              newValue.put(LastDayInsituLogItem.insituTypeKey, lastDayInsituLogItem.insituType);
              newValue.put(LastDayInsituLogItem.descriptionKey, lastDayInsituLogItem.description);
              newValue.put(LastDayInsituLogItem.totalKey, lastDayInsituLogItem.total);
              newValue.put(LastDayInsituLogItem.presentationKey, lastDayInsituLogItem.presentation);
              newValue.put(LastDayInsituLogItem.recoveryKey, lastDayInsituLogItem.recovery);
              newValue.put(LastDayInsituLogItem.value1Key, lastDayInsituLogItem.value1);
              newValue.put(LastDayInsituLogItem.value2Key, lastDayInsituLogItem.value2);
              newValue.put(LastDayInsituLogItem.value3Key, lastDayInsituLogItem.value3);
              newValue.put(LastDayInsituLogItem.value4Key, lastDayInsituLogItem.value4);
              newValue.put(LastDayInsituLogItem.value5Key, lastDayInsituLogItem.value5);
              newValue.put(LastDayInsituLogItem.value6Key, lastDayInsituLogItem.value6);
              newValue.put(LastDayInsituLogItem.value7Key, lastDayInsituLogItem.value7);
              newValue.put(LastDayInsituLogItem.value8Key, lastDayInsituLogItem.value8);
              newValue.put(LastDayInsituLogItem.value9Key, lastDayInsituLogItem.value9);
              return db.insert(LastDayInsituLogItem.tableName, null, newValue);
      }

     
}
