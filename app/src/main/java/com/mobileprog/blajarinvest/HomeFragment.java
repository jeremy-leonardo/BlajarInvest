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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    List<Course> courseList;
    CourseDatabase courseDatabase;
    RecyclerView rvCourses;
    CourseAdapter adapter;
    TextView tvWelcome;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvWelcome = getView().findViewById(R.id.tvWelcome);

        String username = PreferenceHelper.getUsername(getView().getContext());
        tvWelcome.setText("Halo " + username + ",");

        courseDatabase = new CourseDatabase(getView().getContext());
        courseList = courseDatabase.getAllCourse();

        rvCourses = getView().findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(getView().getContext()));

        adapter = new CourseAdapter(getView().getContext(), (ArrayList<Course>) courseList);
        rvCourses.setAdapter(adapter);
    }
}