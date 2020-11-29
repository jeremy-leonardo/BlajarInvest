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
        courseContentDatabase.insertCourseContent(new CourseContent(1,
                "Sebelum masuk ke dalam materi, apakah Anda sudah memahami sebenarnya apa itu Investasi? Yuk, kita pahami bersama. " +
                        "\n\nInvestasi adalah penanaman aset atau dana yang dilakukan untuk memperoleh keuntungan (return) yang baik di masa depan.",
                1));
        courseContentDatabase.insertCourseContent(new CourseContent(1,
                "Lalu, apa bedanya dengan menabung? Menabung hanyalah tindakan untuk menyimpan uang demi mencapai suatu keperluan. Dimana biasanya dalam menabung, kita tidak berharap agar value dari tabungan akan berkembang (walaupun apabila menabung di rekening bank ada bunga). " +
                        "\n\nSedangkan investasi pada umumnya dilakukan dengan harapan untuk memperoleh keuntungan.",
                2));
        courseContentDatabase.insertCourseContent(new CourseContent(1,
                "Apakah saya perlu melakukan Investasi? Tentu saja, hampir setiap orang memerlukannya. Dengan investasi, tujuan finansial di jangka panjang akan lebih mudah terpenuhi." +
                        "\n\nSetiap orang tidak dapat bekerja selamanya dan akan pensiun, apakah kita bisa memenuhi kebutuhan kita apabila kita sudah tidak bekerja?" +
                        "\n\nHal tersebut merupakan salah satu alasan mengapa kita memerlukan investasi. Sudah seharusnya kita tidak menambah beban bagi anak - anak kita untuk menanggung masa pensiun kita.",
                3));
        courseDatabase.insertCourse(new Course("Sebelum Melakukan Investasi"));
        courseContentDatabase.insertCourseContent(new CourseContent(2,
                "Investasi memiliki risiko tersendiri, dimana hal tersebut akan dibahas di materi - materi berikutnya nanti. Karena adanya risiko tersebut maka pasti ada kemungkinan untuk rugi dalam investasi. " +
                        "\n\nKarena itulah kita tidak boleh berinvestasi dengan uang dapur (uang untuk kebutuhan hidup sehari - hari). Investasi harus dilakukan dengan dana yang tidak akan digunakan dalam waktu dekat. Apabila Anda akan ditagih bayaran uang sekolah anak, maka alokasikan dana untuk hal tersebut dahulu baru setelah tidak ada kebutuhan lainnya boleh diinvestasikan.",
                1));
        courseDatabase.insertCourse(new Course("Mengenali Profil Risiko"));
        courseContentDatabase.insertCourseContent(new CourseContent(3,
                "Dalam melakukan investasi, ada banyak hal yang perlu diperhatikan. Salah satunya adalah profil risiko Anda, yang akan menjelaskan seberapa besar risiko yang bisa Anda tanggung atau hadapi.",
                1));
    }
}