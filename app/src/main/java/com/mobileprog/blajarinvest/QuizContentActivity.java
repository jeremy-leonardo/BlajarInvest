package com.mobileprog.blajarinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizContentActivity extends AppCompatActivity {

    QuizDatabase quizDatabase;
    long quizId;
    Quiz quiz;
    TextView tvQuestion;
    TextView tvQuizTitle;
    EditText etAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_content);

        Intent intent = getIntent();
        quizDatabase = new QuizDatabase(this);
        quizId = intent.getLongExtra("quizId", -99);
        quiz = quizDatabase.getQuiz(quizId);

        tvQuizTitle = findViewById(R.id.tvQuizTitle);
        tvQuestion = findViewById(R.id.tvQuestion);
        etAnswer = findViewById(R.id.etAnswer);

        tvQuizTitle.setText("Quiz " + quiz.getId());
        tvQuestion.setText(quiz.getQuestion());

    }

    public void submitBtnClick(View view) {
        Log.v("TEST", "test");
        Log.v("TEST", etAnswer.getText().toString());
        if(quiz.getAnswer().equals(etAnswer.getText().toString())){
            Log.v("TEST", "bnr");
            if(quiz.getIsCompleted() != 1) PreferenceHelper.addPoints(this, 20);
            quizDatabase.complete(quizId);

            Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("completedQuizId", courseId);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        } else {
            Log.v("TEST", "salah");
            Toast.makeText(this, "Jawaban Anda salah", Toast.LENGTH_SHORT);
        }

    }

}