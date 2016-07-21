package com.applicationframwork.android.views;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.applicationframwork.android.R;
import com.applicationframwork.android.controllers.AppController;
import com.applicationframwork.android.defines.AppDefines;
import com.applicationframwork.android.models.HomeModel;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 */
public class SplashScreen extends AppCompatActivity implements AbstractView {

    HomeModel homeModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);
        getSupportActionBar().hide();

        homeModel = AppController.getInstance().getModelFacade().getRemoteModel().getHomeModel();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                    startTimerToLaunchLoginScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        //launch login screen


    }

    public void startTimerToLaunchLoginScreen() {
        Handler handler = AppController.getInstance().getHandler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //Thread.sleep(3000);

                    AppController.getInstance().handleEvent(AppDefines.EVENT_ID_LOGIN_SCREEN);
                    finish();

//                    homeModel.registerView(SplashScreen.this);
//                    homeModel.loadHomeData();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void update() {


    }
}
