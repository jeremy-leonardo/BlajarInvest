package com.mobileprog.blajarinvest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                  TODO
                    return true;
                case R.id.navigation_profile:
//                  TODO
                    return true;
            }
            return false;
        }

    };

}