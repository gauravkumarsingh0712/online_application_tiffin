package com.applicationframwork.android.controllers;

import android.content.Context;
import android.os.Handler;

import com.applicationframwork.android.app.AndroidApplication;
import com.applicationframwork.android.defines.AppDefines;
import com.applicationframwork.android.factory.ViewFactory;
import com.applicationframwork.android.models.ModelFacade;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 * Singleton Class
 */
public class AppController {

    //singleton instance
    private static AppController instance;

    //ModelFacade Reference
    private ModelFacade modelFacade;

    //Reference to android Application class object
    private AndroidApplication application;
    //Handler object reference
    private Handler handler;

    /**
     * Private constructor to achieve singleton design patterns
     */
    private AppController() {
        modelFacade = new ModelFacade();
    }


    /**
     * To get singleton reference of AppController class
     *
     * @return
     */
    public static AppController getInstance() {
        if (instance == null) {
            synchronized (AppController.class) {
                if (instance == null) {
                    instance = new AppController();
                }
            }

        }
        return instance;
    }

    /**
     * This function should called only once.
     * Initialize the required objects
     */
    public void initialize() {

        modelFacade.initialize();
    }

    /**
     * Destory all the required object
     */
    public void destroy() {
        modelFacade.destroy();
    }

    /**
     * Set Android application reference
     *
     * @param application
     */
    public void setApplication(AndroidApplication application) {
        this.application = application;
    }

    /**
     * Get the Android application reference
     *
     * @return
     */
    public AndroidApplication getApplication() {
        return application;
    }

    /**
     * To get the application context refernce to be used in different posstion
     *
     * @return
     */
    public Context getApplicationContext() {

        return application.getApplicationContext();
    }

    /**
     * To get the reference of the ModelFacade Class
     *
     * @return
     */
    public ModelFacade getModelFacade() {
        return modelFacade;
    }

    /**
     * Function to set the Handler reference
     *
     * @param handler
     */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * Function to get the Handler Reference
     *
     * @return
     */
    public Handler getHandler() {
        return handler;
    }

    /**
     * HandleEvent function to manage events inside the appliction.
     * this functions should be used for various background events and activity launch activity
     *
     * @param eventID
     */
    public void handleEvent(int eventID) {
        handleEvent(eventID, null);
    }

    /**
     * HandleEvent function to manage events inside the appliction.
     * this functions should be used for various background events and activity launch activity
     *
     * @param eventID      eventID to process the particular events
     * @param eventObjects eventObjects to be passed to next activyt
     */
    public void handleEvent(int eventID, Object eventObjects) {

        Class className;
        switch (eventID) {
            case AppDefines.EVENT_ID_SPLASH_SCREEN: {
                //to launch splash screen.
                className = ViewFactory.getInstance().getActivityClass(ViewFactory.SPLASH_SCREEN);
                ActivityUIController.getInstance().launchActivity(className, eventID, eventObjects);
            }
            break;

            case AppDefines.EVENT_ID_LOGIN_SCREEN: {
                //to launch login screen.
                className = ViewFactory.getInstance().getActivityClass(ViewFactory.LOGIN_SCREEN);
                ActivityUIController.getInstance().launchActivity(className, eventID, eventObjects);
            }
            break;
            case AppDefines.EVENT_ID_SELECT_DATE_SCREEN: {
                //to launch login screen.
                className = ViewFactory.getInstance().getActivityClass(ViewFactory.SELECT_DATE_SCREEN);
                ActivityUIController.getInstance().launchActivity(className, eventID, eventObjects);
            }
            break;
            case AppDefines.EVENT_ID_SELECT_MENU_SCREEN: {
                //to launch login screen.
                className = ViewFactory.getInstance().getActivityClass(ViewFactory.SELECT_MENU_SCREEN);
                ActivityUIController.getInstance().launchActivity(className, eventID, eventObjects);
            }
            break;
            case AppDefines.EVENT_ID_SELECT_PAYMENT_SCREEN: {
                //to launch login screen.
                className = ViewFactory.getInstance().getActivityClass(ViewFactory.SELECT_PAYMENT_SCREEN);
                ActivityUIController.getInstance().launchActivity(className, eventID, eventObjects);
            }
            break;
            case AppDefines.EVENT_ID_SELECT_DATE_VIEW_SCREEN: {
                //to launch login screen.
                className = ViewFactory.getInstance().getActivityClass(ViewFactory.SELECT_DATE_VIEW_SCREEN);
                ActivityUIController.getInstance().launchActivity(className, eventID, eventObjects);
            }
            break;
        }

    }


}
