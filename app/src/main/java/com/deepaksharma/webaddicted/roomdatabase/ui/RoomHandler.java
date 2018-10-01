package com.deepaksharma.webaddicted.roomdatabase.ui;

import android.view.View;

/**
 * Created by Deepak Sharma on 06-05-2018.
 */

public class RoomHandler {
    private RoomListener mRoomListener;
    public RoomHandler(RoomListener roomListener) {
    mRoomListener = roomListener;
    }

    public void addUserClick(View v) {
        mRoomListener.onaddUserClick();
    }

    public void viewUserClick(View v) {
        mRoomListener.onviewUserClick();
    }

    public void deleteUserClick(View v) {
        mRoomListener.ondeleteUserClick();
    }

    public void updateUserClick(View v) {
        mRoomListener.onupdateUserClick();
    }

    public void insertJsonObj(View v) {
        mRoomListener.onInserObjClick();
    }

    public void insertJsonArray(View v) {
        mRoomListener.insertJsonArray();
    }
}
