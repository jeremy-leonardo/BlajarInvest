package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Course> courseList = new ArrayList<>();
    RecyclerView rvCourses;
    CourseAdapter adapter;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);

        String username = PreferenceHelper.getUsername(this);
        tvWelcome.setText("Halo, " + username);



        courseList.add(new Course(1, "Introduksi"));

        rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CourseAdapter(this, (ArrayList<Course>) courseList);
        rvCourses.setAdapter(adapter);

    }
}