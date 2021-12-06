package com.example.schedulerapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    public static int ARG_COURSE_ID;
    private Course mCourse;

    public DetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARG_COURSE_ID = 1;

        mCourse = CourseDatabase.getInstance().getCourses(1).get(ARG_COURSE_ID-1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        if(mCourse != null){
            TextView nameTextView = rootView.findViewById(R.id.course_name);
            nameTextView.setText(mCourse.getmName());

            TextView profTextView = rootView.findViewById(R.id.prof_name);
            profTextView.setText(mCourse.getmProf());

            TextView timeTextView = rootView.findViewById(R.id.time_range);
            timeTextView.setText(mCourse.getmStart() + "-" + mCourse.getmEnd());

            TextView locTextView = rootView.findViewById(R.id.location);
            locTextView.setText(mCourse.getmLocation());
        }

        return rootView;
    }
}