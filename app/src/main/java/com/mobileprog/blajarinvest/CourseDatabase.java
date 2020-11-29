package com.mobileprog.blajarinvest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CourseDatabase {
    private DatabaseHelper dbHelper;

    public CourseDatabase(Context ctx) {
        dbHelper = new DatabaseHelper(ctx);
    }

    public long insertCourse(Course course) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.FIELD_COURSE_NAME, course.getName());

        long id = db.insert(DatabaseHelper.TABLE_NAME_COURSES, null, cv);

        db.close();

        return id;
    }

    public Course getCourse(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = "id=?";
        String[] selectionArgs = {"" + id};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME_COURSES, null, selection, selectionArgs, null, null, null);

        Course course = null;
        if(cursor.moveToFirst()) {
            course = new Course();
            course.setId(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.FIELD_COURSE_ID)));
            course.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_COURSE_NAME)));
        }

        cursor.close();
        db.close();

        return course;
    }

    public ArrayList<Course> getAllCourse() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME_COURSES, null, null, null, null, null, null);

        ArrayList<Course> courses = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                courses.add(new Course(id, name));
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return courses;
    }

}
