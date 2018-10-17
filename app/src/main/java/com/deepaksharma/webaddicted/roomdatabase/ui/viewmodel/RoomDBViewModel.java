package com.deepaksharma.webaddicted.roomdatabase.ui.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;


import com.deepaksharma.webaddicted.roomdatabase.GlobalClass;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import static com.deepaksharma.webaddicted.roomdatabase.utils.Utilities.randomBox;

public class RoomDBViewModel extends ViewModel {
private static final String TAG = RoomDBViewModel.class.getSimpleName();
    public String addUserInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        int Uid = randomBox();

        String strUserName = "Deepak Sharma -> " + Uid;
        String strUserMobileNo = "902461407 -> " + Uid;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Uid);
        userInfo.setName(strUserName);
        userInfo.setMobileno(strUserMobileNo);
        GlobalClass.getDbInstance().addUser(userInfo);

        stringBuilder.append("User Id -> " + Uid +
                "\nUser Name -> " + strUserName +
                "\nUser Mobile no -> " + strUserMobileNo + "\n\n");
        return stringBuilder + "";
    }

    public String updateUserInfo(int Uid) {
        StringBuilder stringBuilder = new StringBuilder();
        int newId = randomBox();
        String strUserName = "Deepak Sharma -> " + newId;
        String strUserMobileNo = "902461407 -> " + newId;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Uid);
        userInfo.setName(strUserName);
        userInfo.setMobileno(strUserMobileNo);
        GlobalClass.getDbInstance().updateUserInfo(userInfo);
        stringBuilder.append("User info update successfully." + "\nUser Id -> " + Uid +
                "\nUser Name -> " + strUserName +
                "\nUser Mobile no -> " + strUserMobileNo + "\n\n");
        return stringBuilder + "";
    }

    public String deleteUser(int userId) {
        StringBuilder stringBuilder = new StringBuilder();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        GlobalClass.getDbInstance().deleteUser(userInfo);
        return "User sucessfully deleted";
    }

    public String userInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        List<UserInfo> userInfo;
        userInfo = GlobalClass.getDbInstance().getUserInfo();
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

}
