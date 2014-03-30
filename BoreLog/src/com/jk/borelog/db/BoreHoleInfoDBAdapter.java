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
import com.jk.borelog.models.LastDayBoreHoleInfo;
import com.jk.borelog.models.ProjectInfoItem;

/**
 * @author Linson
 *
 */
public class BoreHoleInfoDBAdapter {


	  Context context;
  private SQLiteDatabase db;
  private BoreLogDBHelper dbHelper;
  public BoreHoleInfoDBAdapter(Context context) {
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

  public Cursor getBoreHoleInfoDetails(String boreHoleNo) {
          
          Cursor  cursor = db.query(LastDayBoreHoleInfo.tableName, new String[] {
        		  LastDayBoreHoleInfo.contractGUIDKey, LastDayBoreHoleInfo.boreHoleIDKey
          		,LastDayBoreHoleInfo.publicGUIDKey,LastDayBoreHoleInfo.clientNameKey
          		,LastDayBoreHoleInfo.projectNameKey,LastDayBoreHoleInfo.projectNoKey
          		,LastDayBoreHoleInfo.projectManagerNameKey,LastDayBoreHoleInfo.supervisorNameKey
          		,LastDayBoreHoleInfo.boreHoleNoKey,LastDayBoreHoleInfo.boreHoleDateKey
          		,LastDayBoreHoleInfo.rigNoKey,LastDayBoreHoleInfo.drillingMethodKey
          		,LastDayBoreHoleInfo.diameterOfCasingKey,LastDayBoreHoleInfo.diameterOfBoreHoleKey
          		,LastDayBoreHoleInfo.northingKey,LastDayBoreHoleInfo.eastingKey
          		,LastDayBoreHoleInfo.drillerNameKey,LastDayBoreHoleInfo.assistantName1Key
          		,LastDayBoreHoleInfo.assistantName2Key,LastDayBoreHoleInfo.assistantName3Key
          		,LastDayBoreHoleInfo.assistantName4Key,LastDayBoreHoleInfo.remarksKey
          		,LastDayBoreHoleInfo.terminationDepthKey,LastDayBoreHoleInfo.lastRecordDepthKey
          		
          		},LastDayBoreHoleInfo.boreHoleNoKey+"="+boreHoleNo, null, null, null,null);
          
          return cursor;
  }  
 

  public long insertBoreHoleInfoDetails(LastDayBoreHoleInfo lastDayBoreHoleInfo) {

          ContentValues newValue = new ContentValues();
          newValue.put(LastDayBoreHoleInfo.contractGUIDKey, lastDayBoreHoleInfo.contractGUID);
          newValue.put(LastDayBoreHoleInfo.boreHoleIDKey, lastDayBoreHoleInfo.boreHoleID);
          newValue.put(LastDayBoreHoleInfo.publicGUIDKey, lastDayBoreHoleInfo.publicGUID);
          newValue.put(LastDayBoreHoleInfo.clientNameKey, lastDayBoreHoleInfo.clientName);
          newValue.put(LastDayBoreHoleInfo.projectNameKey, lastDayBoreHoleInfo.projectName);
          newValue.put(LastDayBoreHoleInfo.projectManagerNameKey, lastDayBoreHoleInfo.projectManagerName);
          newValue.put(LastDayBoreHoleInfo.supervisorNameKey, lastDayBoreHoleInfo.supervisorName);
          newValue.put(LastDayBoreHoleInfo.projectNoKey, lastDayBoreHoleInfo.projectNo);
          newValue.put(LastDayBoreHoleInfo.boreHoleNoKey, lastDayBoreHoleInfo.boreHoleNo);
          newValue.put(LastDayBoreHoleInfo.boreHoleDateKey, lastDayBoreHoleInfo.boreHoleDate);
          newValue.put(LastDayBoreHoleInfo.rigNoKey, lastDayBoreHoleInfo.rigNo);
          newValue.put(LastDayBoreHoleInfo.drillingMethodKey, lastDayBoreHoleInfo.drillingMethod);
          newValue.put(LastDayBoreHoleInfo.diameterOfCasingKey, lastDayBoreHoleInfo.diameterOfCasing);
          newValue.put(LastDayBoreHoleInfo.diameterOfBoreHoleKey, lastDayBoreHoleInfo.diameterOfBoreHole);
          newValue.put(LastDayBoreHoleInfo.northingKey, lastDayBoreHoleInfo.northing);
          newValue.put(LastDayBoreHoleInfo.eastingKey, lastDayBoreHoleInfo.easting);
          newValue.put(LastDayBoreHoleInfo.drillerNameKey, lastDayBoreHoleInfo.drillerName);
          newValue.put(LastDayBoreHoleInfo.assistantName1Key, lastDayBoreHoleInfo.assistantName1);
          newValue.put(LastDayBoreHoleInfo.assistantName2Key, lastDayBoreHoleInfo.assistantName2);
          newValue.put(LastDayBoreHoleInfo.assistantName3Key, lastDayBoreHoleInfo.assistantName3);
          newValue.put(LastDayBoreHoleInfo.assistantName4Key, lastDayBoreHoleInfo.assistantName4);
          newValue.put(LastDayBoreHoleInfo.remarksKey, lastDayBoreHoleInfo.remarks);
          newValue.put(LastDayBoreHoleInfo.terminationDepthKey, lastDayBoreHoleInfo.terminationDepth);
          return db.insert(LastDayBoreHoleInfo.tableName, null, newValue);
  }

 



}
