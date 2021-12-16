package com.example.schedulerapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseDatabase {

    private static CourseDatabase mCourseDb;
    private List<Weekday> mWeek;
    private HashMap<Integer, List<Course>> mCourses;

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

        Course course = new Course(1, 1, "CMPSC 475", "Dr. Xiao", "3:00pm", "4:00pm", "Burke 105");
        addCourse(course);
        course = new Course(2, 1, "CMPSC 461", "Dr. Hoblos", "11:00am", "12:15pm", "Burke 107");
        addCourse(course);
        course = new Course(3, 1, "ENGL 202C", "Dr. Gallagher", "8:00am", "9:00am", "Kochel 025");
        addCourse(course);

        course = new Course(1, 3, "CMPSC 475", "Dr. Xiao", "3:00pm", "4:00pm", "Burke 105");
        addCourse(course);
        course = new Course(2, 3, "CMPSC 461", "Dr. Hoblos", "11:00am", "12:15pm", "Burke 107");
        addCourse(course);
        course = new Course(3, 3, "ENGL 202C", "Dr. Gallagher", "8:00am", "9:00am", "Kochel 025");
        addCourse(course);
        course = new Course(4, 3, "SWENG 465 Lab", "Dr. Sammoud", "1:00pm", "2:30pm", "AMIC 110");
        addCourse(course);

        course = new Course(1, 5, "CMPSC 475", "Dr. Xiao", "3:00pm", "4:00pm", "Burke 105");
        addCourse(course);
        course = new Course(2, 5, "CMPSC 461", "Dr. Hoblos", "11:00am", "12:15pm", "Burke 107");
        addCourse(course);
        course = new Course(3, 5, "ENGL 202C", "Dr. Gallagher", "8:00am", "9:00am", "Kochel 025");
        addCourse(course);
        course = new Course(4, 5, "SWENG 465 Lab", "Dr. Sammoud", "1:00pm", "2:30pm", "AMIC 110");
        addCourse(course);

        course = new Course(1, 2, "GEOG 101", "Dr. Naber", "5:00pm", "6:00pm", "Nick 130");
        addCourse(course);
        course = new Course(1, 2, "GYM 101", "Coach Jim", "10:00am", "12:00pm", "Junker 05");
        addCourse(course);

        course = new Course(1, 4, "GEOG 101", "Dr. Naber", "5:00pm", "6:00pm", "Nick 130");
        addCourse(course);
        course = new Course(1, 4, "GYM 101", "Coach Jim", "10:00am", "12:00pm", "Junker 05");
        addCourse(course);

    }

    public Weekday getWeekday(int weekId){
        for(Weekday weekday: mWeek){
            if(weekday.getmId() == weekId){
                return weekday;
            }
        }
        return null;
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

    public int requestID() {
        return mCourses.get(1).size()+1;
    }

    public List<Course> getCourses(int weekday) {
        return mCourses.get(weekday);
    }
}
