package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseContentActivity extends AppCompatActivity {

    long courseId;
    Course course;
    ArrayList<CourseContent> courseContents;
    CourseDatabase courseDatabase;
    CourseContentDatabase courseContentDatabase;

    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);
        tvText = findViewById(R.id.tvText);

        Intent intent = getIntent();
        courseDatabase = new CourseDatabase(this);
        courseContentDatabase = new CourseContentDatabase(this);

        courseId = intent.getLongExtra("courseId", -99);
        course = courseDatabase.getCourse(courseId);
        courseContents = courseContentDatabase.getCourseContentsByCourseId(courseId);
        tvText.setText(courseContents.get(0).getText());

        getSupportActionBar().setTitle(course.getName());

    }
}