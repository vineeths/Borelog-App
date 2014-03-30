/**
 * 
 *
 *
 */
package com.jk.borelog.db;

import java.io.File;

import com.jk.borelog.models.UserInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;

/**
 * @author Linson
 *
 */
public class UserInfoDBAdapter {
	  Context context;
      private SQLiteDatabase db;
      private BoreLogDBHelper dbHelper;
      public UserInfoDBAdapter(Context context) {
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

      public Cursor getUserInfo(int sid,int did) {
              
              Cursor  cursor = db.query(UserInfo.tableName, new String[] {
            		  UserInfo.userGUID_KEY, UserInfo.userEmail_KEY,
            		  UserInfo.userID_KEY, UserInfo.userMbileNo_KEY,
            		  UserInfo.userName_KEY, UserInfo.UserRights_KEY },
                                      null, null, null, null,null);
              
              return cursor;
      }  
      

      public long insertUserInfo(UserInfo userInfo) {

              ContentValues newValue = new ContentValues();
              newValue.put(UserInfo.userGUID_KEY, userInfo.userGUID);
              newValue.put(UserInfo.userEmail_KEY, userInfo.userEmail);
              newValue.put(UserInfo.userID_KEY, userInfo.userID);
              newValue.put(UserInfo.userMbileNo_KEY, userInfo.userMbileNo);
              newValue.put(UserInfo.userName_KEY, userInfo.userName);
              newValue.put(UserInfo.UserRights_KEY, userInfo.userRights);
              
              return db.insert(UserInfo.tableName, null, newValue);
      }

     
}
