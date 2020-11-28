package com.mobileprog.blajarinvest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "main_db";
    public static final int DB_VERSION = 1;

    /* ================================ COURSES ================================ */
    public static final String TABLE_NAME_COURSES = "courses";
    public static final String FIELD_COURSE_ID = "id";
    public static final String FIELD_COURSE_NAME = "name";

    private static final String createCourses =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_COURSES + " (" +
                    FIELD_COURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_COURSE_NAME + " TEXT )";

    private static final String dropCourses =
            "DROP TABLE IF EXISTS " + TABLE_NAME_COURSES;
    /* ========================================================================= */


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createCourses);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropCourses);
        onCreate(db);
    }
}