package com.applicationframwork.android.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.applicationframwork.android.controllers.AppController;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 * Application Class which is starting part of any android application
 */
public class AndroidApplication extends Application {

    //handler will be used as global variable in the application. wherever
    //it is required
    private Handler handler = new Handler();

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
    
    @Override
    public void onCreate() {
        super.onCreate();

        AppController.getInstance().setApplication(this);
        AppController.getInstance().setHandler(handler);

        AppController.getInstance().initialize();

    }

    @Override
    public void onLowMemory() {

        super.onLowMemory();
    }

    @Override
    public void onTerminate() {

        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {

        super.onTrimMemory(level);
    }
}
