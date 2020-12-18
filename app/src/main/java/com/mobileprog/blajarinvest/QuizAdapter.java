package com.mobileprog.blajarinvest;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {

    Context context;
    ArrayList<Quiz> quizList;

    public QuizAdapter(Context context, ArrayList<Quiz> quizList) {
        this.context = context;
        this.quizList = quizList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_quiz, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quiz quiz = quizList.get(position);
        holder.tvQuizTitle.setText("Quiz " + quiz.getId());
        if (quiz.getIsCompleted() == 1) {
            holder.tvComplete.setText("Selesai");
        } else {
            holder.tvComplete.setText("Belum Selesai");
        }
//        holder.ivQuiz.setImageResource(quiz.getImage());
    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tvQuizTitle;
        TextView tvComplete;
//        ImageView ivQuiz;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuizTitle = itemView.findViewById(R.id.tvQuizTitle);
            tvComplete = itemView.findViewById(R.id.tvComplete);
//            ivQuiz = itemView.findViewById(R.id.ivQuiz);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            Quiz quiz = quizList.get(position);

            Intent intent = new Intent(context, QuizContentActivity.class);

            intent.putExtra("quizId", quiz.getId());

            context.startActivity(intent);

        }


    }
}


