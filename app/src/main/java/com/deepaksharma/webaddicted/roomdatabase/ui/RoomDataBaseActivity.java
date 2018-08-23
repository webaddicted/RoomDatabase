package com.deepaksharma.webaddicted.roomdatabase.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.deepaksharma.webaddicted.roomdatabase.R;
import com.deepaksharma.webaddicted.roomdatabase.databinding.ActivityMainBinding;
import com.deepaksharma.webaddicted.roomdatabase.db.MyAppDatabase;


public class RoomDataBaseActivity extends AppCompatActivity implements RoomListener {
    private ActivityMainBinding activityRoomDataBaseBinding;
    private RoomDBViewModel roomDBViewModel;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRoomDataBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityRoomDataBaseBinding.setHandler(new RoomHandler(this));
        roomDBViewModel = ViewModelProviders.of(this).get(RoomDBViewModel.class);
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "user_info")
                .allowMainThreadQueries().build();
    }

    @Override
    public void onaddUserClick() {
        Toast.makeText(this, "Add User", Toast.LENGTH_SHORT).show();
        activityRoomDataBaseBinding.txtAddUser.setText(roomDBViewModel.addUserInfo() + "");
    }

    @Override
    public void onviewUserClick() {
        activityRoomDataBaseBinding.txtViewUser.setText(roomDBViewModel.userInfo());
    }

    @Override
    public void ondeleteUserClick() {
        String deleteId = activityRoomDataBaseBinding.edtDeleteUserId.getText().toString();
        if (deleteId != null && deleteId.length() > 0) {
            activityRoomDataBaseBinding.edtDeleteUserId.setError(null);
            int deleteUid = Integer.parseInt(deleteId);
            activityRoomDataBaseBinding.txtDeleteUser.setText(roomDBViewModel.deleteUser(deleteUid));
        } else {
            activityRoomDataBaseBinding.edtDeleteUserId.setError("Please enter delete id.");
        }
    }


    @Override
    public void onupdateUserClick() {
        String updateId = activityRoomDataBaseBinding.edtUpdateUserId.getText().toString();
        if (updateId != null && updateId.length() > 0) {
            int updateUid = Integer.parseInt(activityRoomDataBaseBinding.edtUpdateUserId.getText().toString());
            activityRoomDataBaseBinding.txtUpdateUser.setText(roomDBViewModel.updateUserInfo(updateUid));
        }else {
            activityRoomDataBaseBinding.edtUpdateUserId.setError("Please enter update id.");
        }

    }
}
