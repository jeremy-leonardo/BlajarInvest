package com.mobileprog.blajarinvest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizFragment extends Fragment {

    List<Quiz> quizList;
    QuizDatabase quizDatabase;
    RecyclerView rvQuizzes;
    QuizAdapter adapter;

    public QuizFragment() {
        // Required empty public constructor
    }

    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        quizDatabase = new QuizDatabase(getView().getContext());
        quizList = quizDatabase.getAllQuiz();

        rvQuizzes = getView().findViewById(R.id.rvQuizzes);
        rvQuizzes.setLayoutManager(new LinearLayoutManager(getView().getContext()));

        adapter = new QuizAdapter(getView().getContext(), (ArrayList<Quiz>) quizList);
        rvQuizzes.setAdapter(adapter);
    }

}