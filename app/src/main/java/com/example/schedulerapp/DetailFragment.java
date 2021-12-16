package com.example.schedulerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    public static String ARG_COURSE_ID = "course_id";
    private Course mCourse;
    public static int mCourseID;

    public DetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mCourseID = args.getInt(ARG_COURSE_ID);
        mCourse = CourseDatabase.getInstance().getCourses(ListFragment.mWeekDay).get(mCourseID-1);
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
            timeTextView.setText(mCourse.getmStart() + " - " + mCourse.getmEnd());

            TextView locTextView = rootView.findViewById(R.id.location);
            locTextView.setText(mCourse.getmLocation());
        }

        return rootView;
    }
}