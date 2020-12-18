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
    public static final String FIELD_COURSE_IS_COMPLETED = "is_completed";

    private static final String createCourses =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_COURSES + " (" +
                    FIELD_COURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_COURSE_NAME + " TEXT," +
                    FIELD_COURSE_IS_COMPLETED + " INTEGER )";

    private static final String dropCourses =
            "DROP TABLE IF EXISTS " + TABLE_NAME_COURSES;
    /* ========================================================================= */

    /* ============================ COURSE CONTENTS ============================ */
    public static final String TABLE_NAME_COURSE_CONTENTS = "course_contents";
    public static final String FIELD_COURSE_CONTENT_COURSE_ID = "course_id";
    public static final String FIELD_COURSE_CONTENT_ID = "id";
    public static final String FIELD_COURSE_CONTENT_TEXT = "text";

    private static final String createCourseContents =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_COURSE_CONTENTS + " (" +
                    FIELD_COURSE_CONTENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FIELD_COURSE_CONTENT_COURSE_ID + " INTEGER, " +
                    FIELD_COURSE_CONTENT_TEXT + " TEXT, " +
                    " FOREIGN KEY (" + FIELD_COURSE_CONTENT_COURSE_ID + ") REFERENCES " + TABLE_NAME_COURSES + "(" + FIELD_COURSE_ID + ")"
                    + ")";

    private static final String dropCourseContents =
            "DROP TABLE IF EXISTS " + TABLE_NAME_COURSE_CONTENTS;
    /* ========================================================================= */

    /* ================================= QUIZ ================================== */
    public static final String TABLE_NAME_QUIZZES = "quizzes";
    public static final String FIELD_QUIZ_ID = "id";
    public static final String FIELD_QUIZ_QUESTION = "question";
    public static final String FIELD_QUIZ_ANSWER = "answer";
    public static final String FIELD_QUIZ_IS_COMPLETED = "is_completed";

    private static final String createQuizzes =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_QUIZZES + " (" +
                    FIELD_QUIZ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_QUIZ_QUESTION + " TEXT," +
                    FIELD_QUIZ_ANSWER + " TEXT," +
                    FIELD_QUIZ_IS_COMPLETED + " INTEGER )";

    private static final String dropQuizzes =
            "DROP TABLE IF EXISTS " + TABLE_NAME_QUIZZES;
    /* ========================================================================= */


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createCourses);
        db.execSQL(createCourseContents);
        db.execSQL(createQuizzes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropCourses);
        db.execSQL(dropCourseContents);
        db.execSQL(dropQuizzes);
        onCreate(db);
    }
}