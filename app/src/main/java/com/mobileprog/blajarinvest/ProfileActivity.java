package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvLevel;
    TextView tvPointsNeeded;
    int points = 0;
    int level = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvLevel = findViewById(R.id.tvLevel);
        tvPointsNeeded = findViewById(R.id.tvPointsNeeded);

        tvName.setText(PreferenceHelper.getUsername(this));
        points = PreferenceHelper.getPoints(this);
        level = calculateLevel(points);
        tvLevel.setText("Level " + level);
        tvPointsNeeded.setText("Membutuhkan " + calculatePointsForNextLevelUp(level, points) + " point untuk naik level berikutnya");
    }

    private int calculateLevel(int points) {
        int levelup = ( (int)Math.sqrt(625 + (100 * points)) - 25 ) / 50; // berdasarkan quadratic formula (rumus abc)
        return levelup + 1;
//        untuk ke level 2 cari 50 points, naik ke level 3 cari lagi 100 points, level 4 cari lagi 150 points.
//        increment 50 points untuk kebutuhan naik level untuk tiap kali naik level
    }

    private int calculatePointsNeeded(int level) {
        return 25*(level-1)*level;
    }

    private int calculatePointsForNextLevelUp(int currentLevel, int points){
        int excessPoints = points - calculatePointsNeeded(currentLevel);
        int needed = calculatePointsNeeded(currentLevel+1) - excessPoints;
        return needed;
    }

}