package com.example.schedulerapp;

public class Weekday {

    private int mId;
    private String day;

    public Weekday(int mId, String day) {
        this.mId = mId;
        this.day = day;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
