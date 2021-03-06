package com.example.schedulerapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFragment extends Fragment {

    private CourseDatabase mCourseDb = CourseDatabase.getInstance();
    public static RecyclerView mRecyclerView;
    public static int mWeekDay = 1;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate fragment list onto main activity
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        //Set onClick for clicking on a course
        View.OnClickListener onClickListener = itemView -> {
          int selectedCourseId = (int) itemView.getTag();
            Log.d(TAG, "onCreateView: " + itemView.getTag());
          Bundle args = new Bundle();

          //Send the course ID when clicked
          args.putInt(String.valueOf(DetailFragment.ARG_COURSE_ID), selectedCourseId);
          Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
        };

        //Populate recycler view with the list of courses for the weekday
        mRecyclerView = rootView.findViewById(R.id.course_list);
        List<Course> courses = mCourseDb.getCourses(mWeekDay);
        mRecyclerView.setAdapter(new CourseAdapter(courses, onClickListener));

        //Add dividers between courses
        DividerItemDecoration divider = new DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(divider);

        return rootView;
    }

    private class CourseAdapter extends RecyclerView.Adapter<CourseHolder> {
        private final List<Course> mCourses;
        private final View.OnClickListener mOnClickListener;

        public CourseAdapter(List<Course> courses, View.OnClickListener onClickListener) {
            mCourses = courses;
            mOnClickListener = onClickListener;
        }

        @NonNull
        @Override
        public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CourseHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(CourseHolder holder, int position) {
            //Get course position in Recycler view list and tag ID
            Course course = mCourses.get(position);
            holder.bind(course);
            holder.itemView.setTag(course.getmId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            //Get number of courses in list
            if(mCourses != null) {
                return mCourses.size();
            }
            return 0;
        }
    }

    private static class CourseHolder extends RecyclerView.ViewHolder {
        //Course Block textViews
        private final TextView mNameTextView;
        private final TextView mProfTextView;
        private final TextView mTimeTextView;
        private final TextView mLocTextView;

        public CourseHolder(LayoutInflater inflater, ViewGroup parent) {
            //Link textViews with the view in the layout
            super(inflater.inflate(R.layout.list_item_class, parent, false));
            mNameTextView = itemView.findViewById(R.id.course_name);
            mProfTextView = itemView.findViewById(R.id.prof_name);
            mTimeTextView = itemView.findViewById(R.id.time_range);
            mLocTextView = itemView.findViewById(R.id.location);
        }

        public void bind(Course course) {
            //Bind data to the textViews
            mNameTextView.setText(course.getmName());
            mProfTextView.setText(course.getmProf());
            mTimeTextView.setText(course.getmStart() + " - " + course.getmEnd());
            mLocTextView.setText(course.getmLocation());
        }
    }
}
