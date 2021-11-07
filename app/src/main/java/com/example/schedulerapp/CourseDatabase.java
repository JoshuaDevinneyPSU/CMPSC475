package com.example.schedulerapp;

import java.util.HashMap;
import java.util.List;

public class CourseDatabase {

    private static CourseDatabase mCourseDb;
    private List<Weekday> mWeek;
    private HashMap<Integer, List<Course>> mCourses;

    public enum SubjectSortOrder { ALPHABETIC, UPDATE_DESC, UPDATE_ASC };

    public static CourseDatabase getInstance() {
        if (mCourseDb == null) {
            mCourseDb = new CourseDatabase();
        }
        return mCourseDb;
    }
}
