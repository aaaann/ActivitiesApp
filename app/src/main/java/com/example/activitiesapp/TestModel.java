package com.example.activitiesapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class TestModel implements Parcelable {

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    private String mText1;
    private String mText2;
    private List<String> mCollection1;
    private List<String> mCollection2;


    public TestModel(String text1, String text2, List<String> collection1, List<String> collection2) {
        mText1 = text1;
        mText2 = text2;
        mCollection1 = collection1;
        mCollection2 = collection2;
    }

    public String getText1() {
        return mText1;
    }

    public void setText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getText2() {
        return mText2;
    }

    public void setText2(String mText2) {
        this.mText2 = mText2;
    }

    public List<String> getCollection1() {
        return mCollection1;
    }

    public void setCollection1(List<String> mCollection1) {
        this.mCollection1 = mCollection1;
    }

    public List<String> getCollection2() {
        return mCollection2;
    }

    public void setCollection2(List<String> mCollection2) {
        this.mCollection2 = mCollection2;
    }

    protected TestModel(Parcel in) {
        mText1 = in.readString();
        mText2 = in.readString();
        mCollection1 = new ArrayList<>();
        mCollection2 = new ArrayList<>();
        in.readStringList(mCollection1);
        in.readStringList(mCollection2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mText1);
        dest.writeString(mText2);
        dest.writeStringList(mCollection1);
        dest.writeStringList(mCollection2);
    }
}
