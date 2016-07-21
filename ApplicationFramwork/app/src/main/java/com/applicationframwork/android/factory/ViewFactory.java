package com.applicationframwork.android.factory;

import com.applicationframwork.android.views.DateScreen;
import com.applicationframwork.android.views.LoginScreen;
import com.applicationframwork.android.views.MenuSelectionScreen;
import com.applicationframwork.android.views.PaymentScreen;
import com.applicationframwork.android.views.SelectedDateScreen;
import com.applicationframwork.android.views.SplashScreen;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 * Class using factory pattern to deliver the activity class reference to launch new screen
 */
public class ViewFactory {

    //instance of singleton task
    private static ViewFactory instance;

    // screen id to launch splash screen
    public static final int SPLASH_SCREEN = 0;
    public static final int LOGIN_SCREEN = 1;
    public static final int SELECT_DATE_SCREEN = 2;
    public static final int SELECT_MENU_SCREEN = 3;
    public static final int SELECT_PAYMENT_SCREEN = 4;
    public static final int SELECT_DATE_VIEW_SCREEN = 5;
    /**
     * To get reference of ViewFactory
     *
     * @return
     */
    public static ViewFactory getInstance() {
        if (instance == null) {
            synchronized (ViewFactory.class) {
                if (instance == null) {
                    instance = new ViewFactory();
                }
            }
        }
        return instance;
    }

    /**
     * To return activity class name.
     *
     * @param id
     * @return
     */
    public Class getActivityClass(int id) {
        switch (id) {
            case SPLASH_SCREEN: {
                return SplashScreen.class;
            }
            case LOGIN_SCREEN: {
                return LoginScreen.class;
            }
            case SELECT_DATE_SCREEN: {
                return SelectedDateScreen.class;
            }
            case SELECT_MENU_SCREEN: {
                return MenuSelectionScreen.class;
            }
            case SELECT_PAYMENT_SCREEN: {
                return PaymentScreen.class;
            }
            case SELECT_DATE_VIEW_SCREEN: {
                return DateScreen.class;
            }
        }
        return null;
    }
}
