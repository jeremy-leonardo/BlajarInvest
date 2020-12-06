package com.mobileprog.blajarinvest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class CourseContentDatabase {

    private DatabaseHelper dbHelper;

    public CourseContentDatabase(Context ctx) {
        dbHelper = new DatabaseHelper(ctx);
    }

    public long insertCourseContent(CourseContent courseContent) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.FIELD_COURSE_CONTENT_COURSE_ID, courseContent.getCourseId());
        cv.put(DatabaseHelper.FIELD_COURSE_CONTENT_TEXT, courseContent.getText());

        long id = db.insert(DatabaseHelper.TABLE_NAME_COURSE_CONTENTS, null, cv);

        db.close();

        return id;
    }

    public ArrayList<CourseContent> getCourseContentsByCourseId(long courseId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = "course_id=?";
        String[] selectionArgs = {"" + courseId};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME_COURSE_CONTENTS, null, selection, selectionArgs, null, null, null);
        ArrayList<CourseContent> courseContents = new ArrayList<>();

        // Log.v("DEBUG", "getCourseContentsByCourseId "+ courseId);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                CourseContent courseContent = null;
                courseContent = new CourseContent();
                courseContent.setId(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.FIELD_COURSE_CONTENT_ID)));
                courseContent.setCourseId(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.FIELD_COURSE_CONTENT_COURSE_ID)));
                courseContent.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_COURSE_CONTENT_TEXT)));
                // Log.v("DEBUG", cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_COURSE_CONTENT_TEXT)));
                courseContents.add(courseContent);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return courseContents;
    }

}
