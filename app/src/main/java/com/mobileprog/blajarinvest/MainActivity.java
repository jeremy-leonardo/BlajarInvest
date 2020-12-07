package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Course> courseList;
    CourseDatabase courseDatabase;
    RecyclerView rvCourses;
    CourseAdapter adapter;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);

        String username = PreferenceHelper.getUsername(this);
        tvWelcome.setText("Halo " + username + ",");

        courseDatabase = new CourseDatabase(this);
        courseList = courseDatabase.getAllCourse();

        rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CourseAdapter(this, (ArrayList<Course>) courseList);
        rvCourses.setAdapter(adapter);
    }

    public void onProfileIconClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        finish();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.v("DEBUG", "onActivity Result");
//        if (resultCode == RESULT_OK) {
//           int completedCourseId = data.getIntExtra("completedCourseId", -99);
//            Log.v("DEBUG", ""+completedCourseId);
//           if(completedCourseId != -99) {
//               courseList = courseDatabase.getAllCourse();
//               adapter.notifyDataSetChanged();
//           }
//        }
//    }
}