package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CourseContentActivity extends AppCompatActivity {

    long courseId;
    Course course;
    CourseDatabase courseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);

        Intent intent = getIntent();
        courseDatabase = new CourseDatabase(this);

        courseId = intent.getLongExtra("courseId", -99);
        course = courseDatabase.getCourse(courseId);

        getSupportActionBar().setTitle("" + course.getName());

    }
}