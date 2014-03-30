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

import com.jk.borelog.models.ProjectInfoItem;
import com.jk.borelog.models.UserInfo;

/**
 * @author Linson
 *
 */
public class ProjectInfoDBAdapter {
	  Context context;
      private SQLiteDatabase db;
      private BoreLogDBHelper dbHelper;
      public ProjectInfoDBAdapter(Context context) {
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

      public Cursor getProjectDetail(String projectGuid) {
              
              Cursor  cursor = db.query(ProjectInfoItem.tableName, new String[] {
            		  ProjectInfoItem.projectGUID_key, ProjectInfoItem.projectName_key,
            		  ProjectInfoItem.projectNo_key  },
                                      ProjectInfoItem.projectGUID_key+"="+projectGuid, null, null, null,null);
              
              return cursor;
      }  
      public Cursor getAllProjectDetail(String projectGuid) {
          
          Cursor  cursor = db.query(ProjectInfoItem.tableName, new String[] {
        		  ProjectInfoItem.projectGUID_key, ProjectInfoItem.projectName_key,
        		  ProjectInfoItem.projectNo_key  },
                                  null, null, null, null,null);
          
          return cursor;
  } 

      public long insertProjectDetails(ProjectInfoItem projectInfoItem) {

              ContentValues newValue = new ContentValues();
              newValue.put(ProjectInfoItem.projectGUID_key, projectInfoItem.projectGUID);
              newValue.put(ProjectInfoItem.projectName_key, projectInfoItem.projectName);
              newValue.put(ProjectInfoItem.projectNo_key, projectInfoItem.projectNo);
              
              return db.insert(ProjectInfoItem.tableName, null, newValue);
      }

     
}
