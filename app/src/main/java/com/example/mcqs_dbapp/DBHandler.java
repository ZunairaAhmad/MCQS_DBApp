package com.example.mcqs_dbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

    public class DBHandler extends SQLiteOpenHelper{

        private static final String DATABASE_NAME = "app.db";
        private static final String TABLE_NAME = "appData";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_ROLLNO = "roll_no";
        private static final String COLUMN_ENROLL = "is_enroll";

        public DBHandler(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        }
    }
