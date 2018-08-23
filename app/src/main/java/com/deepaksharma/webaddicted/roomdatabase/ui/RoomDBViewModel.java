package com.deepaksharma.webaddicted.roomdatabase.ui;

import android.arch.lifecycle.ViewModel;


import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserInfo;

import java.util.List;
import java.util.Random;

public class RoomDBViewModel extends ViewModel {

    public String addUserInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        int Uid = randomBox();

        String strUserName = "Deepak Sharma -> " + Uid;
        String strUserMobileNo = "9024061407 -> " + Uid;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Uid);
        userInfo.setName(strUserName);
        userInfo.setMobileno(strUserMobileNo);
        RoomDataBaseActivity.myAppDatabase.myDao().addUser(userInfo);

        stringBuilder.append("User Id -> " + Uid +
                "\nUser Name -> " + strUserName +
                "\nUser Mobile no -> " + strUserMobileNo + "\n\n");
        return stringBuilder + "";
    }

    public String updateUserInfo(int Uid) {
        StringBuilder stringBuilder = new StringBuilder();
        int newId = randomBox();
        String strUserName = "Deepak Sharma -> " + newId;
        String strUserMobileNo = "902401407 -> " + newId;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Uid);
        userInfo.setName(strUserName);
        userInfo.setMobileno(strUserMobileNo);
        RoomDataBaseActivity.myAppDatabase.myDao().updateUserInfo(userInfo);
        stringBuilder.append("User info update successfully." + "\nUser Id -> " + Uid +
                "\nUser Name -> " + strUserName +
                "\nUser Mobile no -> " + strUserMobileNo + "\n\n");
        return stringBuilder + "";
    }

    public String deleteUser(int userId) {
        StringBuilder stringBuilder = new StringBuilder();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        RoomDataBaseActivity.myAppDatabase.myDao().deleteUser(userInfo);
        return "User sucessfully deleted";
    }

    public String userInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        List<UserInfo> userInfo;
        userInfo = RoomDataBaseActivity.myAppDatabase.myDao().getUserInfo();
        if (userInfo != null && userInfo.size() > 0) {
            for (int i = 0; i < userInfo.size(); i++) {
                stringBuilder.append("User Id -> " + userInfo.get(i).getId() +
                        "\nUser Name -> " + userInfo.get(i).getName() +
                        "\nUser Mobile no -> " + userInfo.get(i).getMobileno() + "\n\n");
            }
        } else {
            return "No record available in database.";
        }
        return stringBuilder + "";
    }


    public static int randomBox() {
        Random rand = new Random();
        int pickedNumber = rand.nextInt(100);
        return pickedNumber;
    }
}
