package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseContentActivity extends AppCompatActivity {

    long courseId;
    Course course;
    int page;
    ArrayList<CourseContent> courseContents;
    CourseDatabase courseDatabase;
    CourseContentDatabase courseContentDatabase;

    TextView tvText;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);
        tvText = findViewById(R.id.tvText);
        tvTitle = findViewById(R.id.tvTitle);

        Intent intent = getIntent();
        courseDatabase = new CourseDatabase(this);
        courseContentDatabase = new CourseContentDatabase(this);
        courseId = intent.getLongExtra("courseId", -99);
        course = courseDatabase.getCourse(courseId);
        courseContents = courseContentDatabase.getCourseContentsByCourseId(courseId);
        page = 1;

        tvText.setText(courseContents.get(page - 1).getText());
        tvTitle.setText(course.getName());

    }

    public void nextBtnClick(View view) {
        if(page + 1 <= courseContents.size()) {
            page++;
            tvText.setText(courseContents.get(page - 1).getText());
        } else {
            if(course.getIsCompleted() != 1) PreferenceHelper.addPoints(this, 50);
            courseDatabase.complete(courseId);
            Intent intent = new Intent(this, CompleteActivity.class);
            intent.putExtra("completedCourseId", courseId);
            startActivity(intent);
            finish();
        }
    }

    public void prevBtnClick(View view) {
        if(page - 1 > 0){
            page--;
            tvText.setText(courseContents.get(page - 1).getText());
        } else {
            finish();
        }
    }

}