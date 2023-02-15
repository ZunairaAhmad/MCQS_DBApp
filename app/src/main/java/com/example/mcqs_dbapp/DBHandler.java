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
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_SCORE = "score";
    private static final String COLUMN_ANSWER = "answer";
    private SQLiteDatabase db;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_QUESTION + " INTEGER,"
                + COLUMN_SCORE + " TEXT," //users score of right answer
                + COLUMN_ANSWER + " TEXT" //correct answer of the question
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertData(APP_BO app_bo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION, app_bo.getQuestion());
        values.put(COLUMN_SCORE, app_bo.getScore());
        values.put(COLUMN_ANSWER, app_bo.getAnswer());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateData(APP_BO app_bo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION, app_bo.getQuestion());
        values.put(COLUMN_SCORE, app_bo.getScore());
        values.put(COLUMN_ANSWER, app_bo.getAnswer());

        //db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[] {String.valueOf(app_bo.getScore())});
        db.close();
    }

    public void deleteData(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] {id});
        db.close();
    }

    public synchronized void truncate() {
        String truncateStatement = "DELETE FROM " + TABLE_NAME + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(truncateStatement);
        db.close();
    }


    public ArrayList<String> selectAllStudents() {
        ArrayList<String> data = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if (cursor.moveToFirst()) {
            do {
                data.add(new APP_BO(cursor.getInt(1),cursor.getString(2),cursor.getString(3)).toString());


            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return data;
    }
}