package com.deepaksharma.webaddicted.roomdatabase.utils;

import android.util.Log;
import android.widget.Toast;

import com.deepaksharma.webaddicted.roomdatabase.GlobalClass;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserDetailsObj;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class Utilities {
    private static final String TAG = Utilities.class.getSimpleName();

    public static int randomBox() {
        Random rand = new Random();
        int pickedNumber = rand.nextInt(100);
        return pickedNumber;
    }

    public static String loadJSONFromAsset(String resName) {
        String json = null;
        try {
            InputStream is = GlobalClass.getInstance().getAssets().open(resName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.d(TAG, "loadJSONFromAsset: " + ex.getMessage());
            return null;
        }
        return json;
    }

    public static Gson getGson() {
        Gson gson = null;
        if (gson == null)
            gson = new Gson();
        return gson;
    }

    public static void showToast(String message) {
        Toast.makeText(GlobalClass.getInstance(), message, Toast.LENGTH_SHORT).show();
    }
}
