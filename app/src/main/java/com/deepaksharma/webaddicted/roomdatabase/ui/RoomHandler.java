package com.deepaksharma.webaddicted.roomdatabase.ui;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 * Created by Deepak Sharma on 06-05-2018.
 */

public class RoomHandler extends BaseObservable {
    public ObservableField<String> edt_update = new ObservableField<>();
//    public ObservableField<String> edt_updateOnTextChange = new ObservableField<>();

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

    public void edt_updateOnTextChange(CharSequence s, int start, int before, int count) {
        Log.w("tag", "onTextChanged " + s);
    }
}
