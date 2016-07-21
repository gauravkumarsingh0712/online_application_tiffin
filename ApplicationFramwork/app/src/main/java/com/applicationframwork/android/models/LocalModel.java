package com.applicationframwork.android.models;

import android.content.Context;

import com.applicationframwork.android.controllers.AppController;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 */
public class LocalModel implements IModel {
    private Context context;
    @Override
    public void initialize() {
        context = AppController.getInstance().getApplicationContext();
    }

    @Override
    public void destroy() {

    }

    public boolean isEmailValid(String email) {
        boolean isValid = false;


        if (email.contains("@")) {
            isValid = true;
        }
        return isValid;

      /*  String expression = "^[\\w\\.-]+[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        //expression="^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,4})$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;*/
    }
}
