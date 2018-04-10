package com.example.shriji.interviewp1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

    private String mID;
    private String mName;
    private String mEmail;
    private String mPassword;

    public UserModel() {
    }

    public UserModel(String name, String email, String password) {
        mName = name;
        mEmail = email;
        mPassword = password;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mID);
        dest.writeString(this.mName);
        dest.writeString(this.mEmail);
        dest.writeString(this.mPassword);
    }

    protected UserModel(Parcel in) {
        this.mID = in.readString();
        this.mName = in.readString();
        this.mEmail = in.readString();
        this.mPassword = in.readString();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
