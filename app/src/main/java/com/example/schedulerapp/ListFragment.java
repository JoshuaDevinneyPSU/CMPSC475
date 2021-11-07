package com.example.schedulerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFragment  extends Fragment {

    private CourseDatabase mCourseDb;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        View.OnClickListener onClickListener = itemView -> {
          int selectedCourseId = (int) itemView.getTag();
          Bundle args = new Bundle();
          //args.putInt(DetailFragment.ARG_COURSE_ID, selectedCourseId);
          //Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
        };

        mRecyclerView = rootView.findViewById(R.id.course_list);
        List<Course> courses = mCourseDb.getCourses(1);
        mRecyclerView.setAdapter(new CourseAdapter(courses, onClickListener));

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
            Course course = mCourses.get(position);
            holder.bind(course);
            holder.itemView.setTag(course.getmId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mCourses.size();
        }
    }

    private static class CourseHolder extends RecyclerView.ViewHolder {
        private final TextView mNameTextView;

        public CourseHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_class, parent, false));
            mNameTextView = itemView.findViewById(R.id.course_name);
        }

        public void bind(Course course) {
            mNameTextView.setText(course.getmName());
        }
    }
}
