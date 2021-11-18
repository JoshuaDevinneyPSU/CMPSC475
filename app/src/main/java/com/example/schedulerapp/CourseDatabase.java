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

        Course course = new Course(1, 1, "CMPSC 475", "Dr. Xiao", "3:00pm", "4:00pm", "Burke 180");
        addCourse(course);
        course = new Course(1, 2, "GEOG 101", "Dr. Naber", "5:00pm", "6:00pm", "Nick 130");
        addCourse(course);

    }

    private void addWeekday(Weekday weekday) {
        mWeek.add(weekday);
        List<Course> courseList = new ArrayList<>();
        mCourses.put(weekday.getmId(), courseList);
    }

    public void addCourse(Course course) {
        List<Course> courseList = mCourses.get(course.getmDay());
        if(courseList != null) {
            courseList.add(course);
        }
    }

    public List<Course> getCourses(int weekday) {
        return mCourses.get(weekday);
    }
}
