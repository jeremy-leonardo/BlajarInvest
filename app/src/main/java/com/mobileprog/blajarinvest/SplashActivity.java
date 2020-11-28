package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    CourseDatabase courseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(PreferenceHelper.getUsername(this) == "") {
            if(!PreferenceHelper.checkDatabaseInit(this)){
                courseDatabase = new CourseDatabase(this);
                courseDatabase.insertCourse(new Course("Apa itu Investasi"));
                courseDatabase.insertCourse(new Course("Mengenali Profil Risiko"));
                PreferenceHelper.setDoneInitDatabase(this);
            }
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        finish();

    }
}