package com.deepaksharma.webaddicted.roomdatabase;

import android.app.Application;

/**
 * Created by deepaksharma on 23/8/18.
 */

public class GlobalClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }
}
