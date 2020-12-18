package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    CourseDatabase courseDatabase;
    CourseContentDatabase courseContentDatabase;
    QuizDatabase quizDatabase;
    private Handler waitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        waitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if(PreferenceHelper.getUsername(getApplicationContext()) == "") {
                        if(!PreferenceHelper.checkDatabaseInit(getApplicationContext())){
                            initDatabase();
                            PreferenceHelper.setDoneInitDatabase(getApplicationContext());
                        }
                        Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    finish();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);
    }

    private void initDatabase() {
        
        // Seharusnya dan sebaiknya ini load data dari Database Server (Cloud),
        // tapi tidak ada OpenAPI yang cocok untuk ini,
        // dan membuat API sendiri itu diluar scope dari mata kuliah ini

        courseDatabase = new CourseDatabase(this);
        courseContentDatabase = new CourseContentDatabase(this);
        quizDatabase = new QuizDatabase(this);

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
        courseContentDatabase.insertCourseContent(new CourseContent(2,
                "Sebelum memulai investasi, ada baiknya menyiapkan dana darurat dan asuransi terlebih dahulu. Apalagi apabila Anda sudah berkeluarga. " +
                        "\n\nDana darurat merupakan dana yang dapat dengan mudah Anda tarik apabila ada suatu keperluan mendesak (misalnya Anda jatuh sakit dan perlu biaya perawatan). " +
                        "\n\nAsuransi juga merupakan hal yang penting untuk melindungi Anda dan keluarga apabila ada hal buruk yang terjadi, agar tidak perlu mengganggu dana yang sudah diinvestasikan.",
                2));
        courseDatabase.insertCourse(new Course("Mengenali Profil Risiko"));
        courseContentDatabase.insertCourseContent(new CourseContent(3,
                "Dalam melakukan investasi, ada banyak hal yang perlu diperhatikan. Salah satunya adalah profil risiko Anda, yang akan menjelaskan seberapa besar risiko yang bisa Anda tanggung atau hadapi.",
                1));
        courseContentDatabase.insertCourseContent(new CourseContent(3,
                "Dalam mengetahui profil risiko Anda, dapat melihat tujuan invetasi, source of income, dan jumlah income Anda. \nDalam menentukannya, seringkali ada banyak questionaire yang dapat membantu Anda yang dapat Anda search di Google.",
                2));
        courseContentDatabase.insertCourseContent(new CourseContent(3,
                "Biasanya secara umum, profil risiko akan dibagi menjadi 3, yaitu: \nKonservatif: Mengambil instrumen investasi yang paling aman, toleransi terhadap kerugian sangat rendah. " +
                        "\n\nModerat: Mengambil instrumen investasi secara mixed, memiliki toleransi terhadap kerugian. " +
                        "\n\nAgresif: Mengambil instrumen investasi yang memiliki risiko terbesar namun dengan potensi return yang lebih tinggi, memiliki toleransi yang besar terhadap kerugian.",
                3));
        courseDatabase.insertCourse(new Course("Jangan Serakah"));
        courseContentDatabase.insertCourseContent(new CourseContent(4,
                "Dalam melakukan investasi, penting untuk mengingatkan diri agar jangan serakah. Apabila ada peluang investasi dengan potensi return besar, maka tentu risiko yang ada juga besar. " +
                        "\n\nBanyak sekali orang lupa akan hal tersebut dan akhirnya stress ketika mengalami kerugian, hal ini karena orang hanya melihat potensi return-nya saja tanpa memikirkan risiko yang pasti ada",
                1));
        courseDatabase.insertCourse(new Course("Instrumen Investasi"));
        courseContentDatabase.insertCourseContent(new CourseContent(5,
                "Insturmen investasi yang ada itu sangat banyak. Beberapa contohnya adalah:" +
                        "\n1. Reksadana" +
                        "\n2. Obligasi" +
                        "\n3. Saham" +
                        "\n4. Logam Mulia (cth: emas)" +
                        "\n5. P2P Lending" +
                        "\n\nSetiap instrumen invesstasi memiliki risiko yang berbeda, misalnya saham merupakan instrumen investasi dengan risiko yang cukup besar," +
                        "apalagi jika Anda tidak menganalisa saham perusahaan yang Anda beli.",
                1));
        courseDatabase.insertCourse(new Course("Mulai Investasi"));
        courseContentDatabase.insertCourseContent(new CourseContent(6,
                "Tergantung instrumen investasi yang diinginkan, maka platform untuk melakukan investasi akan berbeda." +
                        "\n\nUntuk investasi saham, maka dapat dimulai dengan membuka akun di sekuritas. Ada baiknya melakukan pengecekan di BEI dan memilih salah satu sekuritas terbesar yang ada di Indonesia, serta pertimbangkan juga sekuritas yang ada di dekat lokasi rumah." +
                        "\n\nUntuk investasi reksadana, maka dapat dimulai dengan membuka akun di APERD (agen penjual reksa dana) yang terdaftar secara legal.",
                1));
        quizDatabase.insertQuiz(new Quiz(
                "________ merupakan tindakan penanaman aset atau dana yang dilakukan untuk memperoleh keuntungan (return) yang baik di masa depan",
                "investasi"
        ));

    }
}