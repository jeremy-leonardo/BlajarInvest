package com.mobileprog.blajarinvest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    TextView tvName;
    TextView tvLevel;
    TextView tvPointsNeeded;
    Button btnEdit;
    EditText etName;
    int points = 0;
    int level = 1;
    boolean isEditMode = false;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvName = getView().findViewById(R.id.tvName);
        tvLevel = getView().findViewById(R.id.tvLevel);
        tvPointsNeeded = getView().findViewById(R.id.tvPointsNeeded);
        btnEdit = getView().findViewById(R.id.btnEdit);
        etName = getView().findViewById(R.id.etName);
        etName.setVisibility(View.GONE);

        tvName.setText(PreferenceHelper.getUsername(getView().getContext()));
        points = PreferenceHelper.getPoints(getView().getContext());
        level = calculateLevel(points);
        tvLevel.setText("Level " + level);
        tvPointsNeeded.setText("Membutuhkan " + calculatePointsForNextLevelUp(level, points) + " point untuk naik level berikutnya");

        Button btnEdit = (Button) getView().findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(editButtonClickListener);
    }

    private View.OnClickListener editButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            editMode();
        }
    };

    public void editMode(){
        if (!isEditMode) {
            tvName.setVisibility(View.GONE);
            etName.setVisibility(View.VISIBLE);
            isEditMode = true;
            btnEdit.setText("Save");
            etName.setText(PreferenceHelper.getUsername(getView().getContext()));
        } else {
            tvName.setVisibility(View.VISIBLE);
            etName.setVisibility(View.GONE);
            isEditMode = false;
            btnEdit.setText("Edit Profile");
            String name = etName.getText().toString();
            PreferenceHelper.setUsername(getView().getContext(), name);
            tvName.setText(name);
        }
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