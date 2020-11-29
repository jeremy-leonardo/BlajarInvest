package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    CourseDatabase courseDatabase;
    CourseContentDatabase courseContentDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(PreferenceHelper.getUsername(this) == "") {
            if(!PreferenceHelper.checkDatabaseInit(this)){
                initDatabase();
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

    private void initDatabase() {
        courseDatabase = new CourseDatabase(this);
        courseContentDatabase = new CourseContentDatabase(this);
        courseDatabase.insertCourse(new Course("Apa itu Investasi"));
        courseContentDatabase.insertCourseContent(new CourseContent(1, "Sebelum masuk ke dalam materi, apakah Anda sudah memahami sebenarnya apa itu Investasi? Yuk, kita pahami bersama.", 1));
        courseContentDatabase.insertCourseContent(new CourseContent(1, "Investasi adalah penanaman aset atau dana yang dilakukan untuk memperoleh keuntungan (return) yang baik di masa depan.", 2));
        courseContentDatabase.insertCourseContent(new CourseContent(1, "Lalu, apa bedanya dengan menabung? Menabung hanyalah tindakan untuk menyimpan uang demi mencapai suatu keperluan. Sedangkan investasi pada umumnya dilakukan dengan harapan untuk memperoleh keuntungan.", 3));
        courseContentDatabase.insertCourseContent(new CourseContent(1, "Apakah saya perlu melakukan Investasi? Tentu saja, hampir setiap orang memerlukannya. Dengan investasi, tujuan finansial di jangka panjang akan lebih mudah terpenuhi.", 4));
        courseDatabase.insertCourse(new Course("Mengenali Profil Risiko"));
        courseContentDatabase.insertCourseContent(new CourseContent(2, "Dalam melakukan investasi, ada banyak hal yang perlu diperhatikan. Salah satunya adalah profil risiko Anda, yang akan menjelaskan seberapa besar risiko yang bisa Anda tanggung atau hadapi.", 1));
    }
}