package com.example.schedulerapp;

import java.util.ArrayList;
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

    private CourseDatabase() {
        mWeek = new ArrayList<>();
        mCourses = new HashMap<>();

        Weekday weekday = new Weekday(1, "Monday");
        addWeekday(weekday);
        weekday = new Weekday(2, "Tuesday");
        addWeekday(weekday);
        weekday = new Weekday(3, "Wednesday");
        addWeekday(weekday);
        weekday = new Weekday(4, "Thursday");
        addWeekday(weekday);
        weekday = new Weekday(5, "Friday");
        addWeekday(weekday);


    }

    private void addWeekday(Weekday weekday) {
        mWeek.add(weekday);
        List<Course> courseList = new ArrayList<>();
        mCourses.put(weekday.getmId(), courseList);
    }
}
