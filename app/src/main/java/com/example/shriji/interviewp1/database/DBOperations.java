package com.example.shriji.interviewp1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shriji.interviewp1.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    private Context mContext;
    private SQLiteOpenHelper mSQLiteOpenHelper;
    private SQLiteDatabase mSQLiteDatabase;

    public DBOperations(Context context) {
        mContext = context;
        mSQLiteOpenHelper = new DBHelper(context);
        mSQLiteDatabase = mSQLiteOpenHelper.getWritableDatabase();
    }

    public void openDB() {
        mSQLiteDatabase = mSQLiteOpenHelper.getWritableDatabase();
    }

    public void closeDB() {
        mSQLiteDatabase.close();
    }

    public long insertUsers(UserModel userModel) {
        ContentValues values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME, userModel.getName());
        values.put(DBConstants.COLUMN_EMAIL, userModel.getEmail());
        values.put(DBConstants.COLUMN_PASSWORD, userModel.getPassword());
        long usersCount = mSQLiteDatabase.insert(DBConstants.TABLE_NAME, null, values);
        return usersCount;
    }

    public boolean loginUser(String name, String email, String password) {
        Cursor cursor = mSQLiteDatabase.query(DBConstants.TABLE_NAME, DBConstants.COLUMN_ALL,
                DBConstants.COLUMN_NAME + " =? AND " +
                        DBConstants.COLUMN_EMAIL + " =? AND " +
                        DBConstants.COLUMN_PASSWORD + " =?",
                new String[] {name,email,password},null,null,null);

        int counts = cursor.getCount();
        if(counts>0){
            return true;
        }else {
            return false;
        }
    }
}
