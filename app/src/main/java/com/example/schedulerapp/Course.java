package com.example.schedulerapp;

public class Course {
    private int mId;
    private int mDay;
    private String mName;
    private String mProf;
    private String mStart;
    private String mEnd;
    private String mLocation;

    public Course(int mId, int mDay, String mName, String mProf, String mStart, String mEnd, String mLocation) {
        this.mId = mId;
        this.mDay = mDay;
        this.mName = mName;
        this.mProf = mProf;
        this.mStart = mStart;
        this.mEnd = mEnd;
        this.mLocation = mLocation;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmProf() {
        return mProf;
    }

    public void setmProf(String mProf) {
        this.mProf = mProf;
    }

    public String getmStart() {
        return mStart;
    }

    public void setmStart(String mStart) {
        this.mStart = mStart;
    }

    public String getmEnd() {
        return mEnd;
    }

    public void setmEnd(String mEnd) {
        this.mEnd = mEnd;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }
}
