package com.mobileprog.blajarinvest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuizDatabase {
    private DatabaseHelper dbHelper;

    public QuizDatabase(Context ctx) {
        dbHelper = new DatabaseHelper(ctx);
    }

    public long insertQuiz(Quiz quiz) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.FIELD_QUIZ_QUESTION, quiz.getQuestion());
        cv.put(DatabaseHelper.FIELD_QUIZ_ANSWER, quiz.getAnswer());
        cv.put(DatabaseHelper.FIELD_QUIZ_IS_COMPLETED, quiz.getIsCompleted());

        long id = db.insert(DatabaseHelper.TABLE_NAME_QUIZZES, null, cv);

        db.close();

        return id;
    }

    public Quiz getQuiz(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = "id=?";
        String[] selectionArgs = {"" + id};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME_QUIZZES, null, selection, selectionArgs, null, null, null);

        Quiz quiz = null;
        if(cursor.moveToFirst()) {
            quiz = new Quiz();
            quiz.setId(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_ID)));
            quiz.setQuestion(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_QUESTION)));
            quiz.setAnswer(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_ANSWER)));
            quiz.setIsCompleted(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_IS_COMPLETED)));
        }

        cursor.close();
        db.close();

        return quiz;
    }

    public ArrayList<Quiz> getAllQuiz() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME_QUIZZES, null, null, null, null, null, null);

        ArrayList<Quiz> quizzes = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_ID));
                String question = cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_QUESTION));
                String answer = cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_ANSWER));
                int isCompleted = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.FIELD_QUIZ_IS_COMPLETED));
                quizzes.add(new Quiz(id, question, answer, isCompleted));
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return quizzes;
    }

    public void complete(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.FIELD_QUIZ_IS_COMPLETED, 1);

        String selection = "id=?";
        String[] selectionArgs = {"" + id};
        db.update(DatabaseHelper.TABLE_NAME_QUIZZES, cv, selection, selectionArgs);
        db.close();
    }

}
