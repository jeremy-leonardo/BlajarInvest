package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        etName = findViewById(R.id.etName);
    }

    public void nextBtnClick(View view) {
        PreferenceHelper.setUsername(this, etName.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}