package com.applicationframwork.android.utils;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by gauravkumar.singh on 7/20/2016.
 */
public class Utils {


    public static final String getDateYYYYMMDDToDDMMYYYY(String date)
    {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {

            if (date != null) {
                Date dt = fmt.parse(date);
                fmt = new SimpleDateFormat("dd-MM-yyyy");
                return fmt.format(dt);
            }
        } catch (Exception e) {

        }
        return "";
    }

    public static final String getDateDDMMYYYYToYYYYMMDD(String date)
    {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        try {

            if (date != null && !date.equalsIgnoreCase("")) {
                Date dt = fmt.parse(date);
                fmt = new SimpleDateFormat("yyyy-MM-dd");
                return fmt.format(dt);
            }
        } catch (Exception e) {

        }
        return "";
    }


    public static final String getDate(String date) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {

            if (date != null) {
                Date dt = fmt.parse(date);

                return fmt.format(dt);
            }
        } catch (Exception e) {

        }
        return "";

    }

    public static final String getDateWithDay(String date)
    {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {

            if (date != null) {
                Date dt = fmt.parse(date);
                fmt = new SimpleDateFormat("E - dd MMM yyyy");
                return fmt.format(dt);
            }
        } catch (Exception e) {

        }
        return "";
    }

    public static final String getDate(Date date) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {

            if (date != null) {

                return fmt.format(date);
            }
        } catch (Exception e) {

        }
        return "";

    }

    public static String convertDateToUTC(String date)
    {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {

            if (date != null) {
                Date dt = fmt.parse(date);
                Date utc = new Date(dt.getTime() - Calendar.getInstance().getTimeZone().getRawOffset());
                System.out.println("-----> offset "+ Calendar.getInstance().getTimeZone().getRawOffset());
                System.out.println("-----> utc "+ utc.toString());
                System.out.println("-----> convertDateToUTC "+ dt.toString() );
                System.out.println("-----> convertDateToUTC "+ fmt.format(utc) );


            }
        } catch (Exception e) {

        }
        return new String();
    }

    public static String convertDateToLocal(String date)
    {
        return new String();
    }


    public static float convertToFloat(TextView textView) {
        if (textView.getText().toString().equalsIgnoreCase("")) {

            return 0.0f;
        } else {

            String value = textView.getText().toString();

            float fValue = Float.parseFloat(value);
            return fValue;
        }
    }
}