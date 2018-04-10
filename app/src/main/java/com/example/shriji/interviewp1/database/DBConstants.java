package com.example.shriji.interviewp1.database;

public interface DBConstants {
    String TABLE_NAME = "usersTable";
    String COLUMN_ID = "id";
    String COLUMN_NAME = "name";
    String COLUMN_EMAIL = "email";
    String COLUMN_PASSWORD = "password";

    String[] COLUMN_ALL = {COLUMN_ID,COLUMN_NAME,COLUMN_EMAIL,COLUMN_PASSWORD};

    String SQL_CREATE = "CREATE TABLE " + TABLE_NAME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_PASSWORD + " TEXT" + ");";

    String SQL_DELETE = "DROP TABLE IF EXISTS " +TABLE_NAME;
}
