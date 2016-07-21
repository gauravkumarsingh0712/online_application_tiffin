package com.applicationframwork.android.defines;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 */
public interface AppDefines {

   //events for launching different screen
   int EVENT_ID_SPLASH_SCREEN = 0;
   int EVENT_ID_LOGIN_SCREEN = 1;
   int EVENT_ID_SELECT_DATE_SCREEN = 2;
   int EVENT_ID_SELECT_MENU_SCREEN = 3;
   int EVENT_ID_SELECT_PAYMENT_SCREEN = 4;
   int EVENT_ID_SELECT_DATE_VIEW_SCREEN = 5;

   //local url
   String SERVER_URL_API = "http://10.10.10.233/Ashu/";

   String HOME_URL = SERVER_URL_API+"First";
}
