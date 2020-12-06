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

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    Context context;
    ArrayList<Course> courseList;

    public CourseAdapter(Context context, ArrayList<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_course, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courseList.get(position);
        holder.tvName.setText(course.getName());
        holder.tvNumber.setText(""+course.getId());
        if (course.getIsCompleted() == 1) {
            holder.tvComplete.setText("Selesai");
        } else {
            holder.tvComplete.setText("Belum Selesai");
        }
//        holder.ivCourse.setImageResource(course.getImage());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tvName;
        TextView tvNumber;
        TextView tvComplete;
//        ImageView ivCourse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvComplete = itemView.findViewById(R.id.tvComplete);
//            ivCourse = itemView.findViewById(R.id.ivCourse);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            Course course = courseList.get(position);

            Intent intent = new Intent(context, CourseContentActivity.class);

            intent.putExtra("courseId", course.getId());

            context.startActivity(intent);

        }


    }
}


