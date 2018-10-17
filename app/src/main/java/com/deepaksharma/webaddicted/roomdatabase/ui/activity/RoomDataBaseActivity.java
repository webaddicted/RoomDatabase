package com.deepaksharma.webaddicted.roomdatabase.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameBean;
import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameInsert;
import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameTemp;
import com.deepaksharma.webaddicted.roomdatabase.GlobalClass;
import com.deepaksharma.webaddicted.roomdatabase.R;
import com.deepaksharma.webaddicted.roomdatabase.databinding.ActivityMainBinding;
import com.deepaksharma.webaddicted.roomdatabase.ui.RoomHandler;
import com.deepaksharma.webaddicted.roomdatabase.ui.viewmodel.RoomDBViewModel;
import com.deepaksharma.webaddicted.roomdatabase.utils.Utilities;

import java.util.List;


public class RoomDataBaseActivity extends AppCompatActivity {
    private ActivityMainBinding activityRoomDataBaseBinding;
    private RoomDBViewModel roomDBViewModel;
    private static final String TAG = RoomDataBaseActivity.class.getSimpleName();
    RoomHandler roomHandler;//= new RoomHandler(this);
    GameBean gameBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRoomDataBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        roomDBViewModel = ViewModelProviders.of(this).get(RoomDBViewModel.class);
//        roomHandler = new RoomHandler();
         gameBean = Utilities.getGson().fromJson(Utilities.loadJSONFromAsset("game.json"), GameBean.class);
        activityRoomDataBaseBinding.setHandler(roomHandler);
    }


    public void onaddUserClick(View v) {
        Toast.makeText(this, "Add User", Toast.LENGTH_SHORT).show();
        activityRoomDataBaseBinding.txtAddUser.setText(roomDBViewModel.addUserInfo() + "");
    }


    public void onviewUserClick(View v) {
        activityRoomDataBaseBinding.txtViewUser.setText(roomDBViewModel.userInfo());
    }


    public void ondeleteUserClick(View v) {
        String deleteId = activityRoomDataBaseBinding.edtDeleteUserId.getText().toString();
        if (deleteId != null && deleteId.length() > 0) {
            activityRoomDataBaseBinding.edtDeleteUserId.setError(null);
            int deleteUid = Integer.parseInt(deleteId);
            activityRoomDataBaseBinding.txtDeleteUser.setText(roomDBViewModel.deleteUser(deleteUid));
        } else {
            activityRoomDataBaseBinding.edtDeleteUserId.setError("Please enter delete id.");
        }
    }



    public void onupdateUserClick(View v) {
        String updateId = activityRoomDataBaseBinding.edtUpdateUserId.getText().toString();
        if (updateId != null && updateId.length() > 0) {
            int updateUid = Integer.parseInt(activityRoomDataBaseBinding.edtUpdateUserId.getText().toString());
            activityRoomDataBaseBinding.txtUpdateUser.setText(roomDBViewModel.updateUserInfo(updateUid));
        } else {
            activityRoomDataBaseBinding.edtUpdateUserId.setError("Please enter update id.");
        }
    }


    public void onInserObjClick(View v) {


        Log.d(TAG, "onInserObjClick: "+gameBean.getResult().get(0).getTotalData());
        Utilities.showToast(gameBean.getMessage());
        for (int i = 0; i < gameBean.getResult().get(0).getData().size(); i++) {
            GameBean.ResultBean.DataBean dataBean = gameBean.getResult().get(0).getData().get(i);
            GameTemp gameTemp = new GameTemp();
            gameTemp.set_id(dataBean.get_id());
            gameTemp.setPlotHeight(dataBean.getPlotHeight());
            gameTemp.setPlotWidth(dataBean.getPlotWidth());
            gameTemp.setTemplate(dataBean.getTemplate());
            gameTemp.setTemplateSrc(dataBean.getTemplateSrc());
//            List<GameBean.ResultBean.DataBean.EnvObjBean> envObjBean =  dataBean.getEnvObj();
//            List<GameBean.ResultBean.DataBean.GameObjBean> gameObjBean = dataBean.getGameObj();
//            List<GameBean.ResultBean.DataBean.ZoneObjBean> zoneObjBean =  dataBean.getZoneObj();
            for (int j =0; j<dataBean.getEnvObj().size();j++) {
                dataBean.getEnvObj().get(j).setId_parent(gameTemp.get_id());
            }
            for (int j =0; j<dataBean.getGameObj().size();j++) {
                dataBean.getGameObj().get(j).setId_parent(gameTemp.get_id());
            }
            for (int j =0; j<dataBean.getZoneObj().size();j++) {
                dataBean.getZoneObj().get(j).setId_parent(gameTemp.get_id());
            }
            GlobalClass.getDbInstance().insertGame(gameTemp,  dataBean.getEnvObj(),  dataBean.getGameObj(),  dataBean.getZoneObj());
        }
//        GlobalClass.getDbInstance().insertUserObj(gameBean);
//        List<UserDetailsObj> getUserInfo = GlobalClass.getDbInstance().getUserObj();
//        Log.d(TAG, "insert object info onClick: " + getUserInfo.get(0).getMain().getPressure());
//        Toast.makeText(this, "Successfully inserted. \nPressure -> " + getUserInfo.get(0).getMain().getPressure(), Toast.LENGTH_SHORT).show();
    }


    public void insertJsonArray(View v) {
        List<GameInsert> gameInsert = GlobalClass.getDbInstance().getGameInfo();
        Log.d(TAG, "insertJsonArray: " + gameInsert.get(0).getGameTemp().getTemplate());
    }
}
