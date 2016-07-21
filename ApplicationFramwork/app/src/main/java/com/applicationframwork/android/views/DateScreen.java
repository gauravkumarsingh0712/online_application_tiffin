package com.applicationframwork.android.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.applicationframwork.android.R;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.timessquare.CalendarPickerView;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gauravkumar.singh on 7/21/2016.
 */
public class DateScreen extends AppCompatActivity implements View.OnClickListener {

    TextView textViewOk;
    TextView textViewCancel;
    String dateString;
    ArrayList<String> setInput;
    String finalString;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.date_screen);

        initViews();


        dateSelectionScreen();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initViews() {
        textViewOk = (TextView) findViewById(R.id.txt_ok);
        textViewCancel = (TextView) findViewById(R.id.cancel);
        textViewOk.setOnClickListener(this);
        textViewCancel.setOnClickListener(this);

        setInput = new ArrayList<>();


    }

    private void dateSelectionScreen() {
        SimpleDateFormat dateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.getDefault());
        String start = "Thu july 18 09:28:56 GMT+00:00 2016";
        String end = "Mon Aug 25 09:28:56 GMT+00:00 2016";
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();
        Date startdate = null, enddate = null;
        try {
            startdate = dateformat.parse(start);
            enddate = dateformat.parse(end);

            calendar.init(startdate, enddate, Locale.ENGLISH)
                    .inMode(CalendarPickerView.SelectionMode.MULTIPLE).withSelectedDate(new Date());

            calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
                @Override
                public void onDateSelected(Date date) {

                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

                    fmt = new SimpleDateFormat("dd-MM-yyyy");
                     dateString = fmt.format(date);

                     setInput.add(dateString);

                    System.out.println("date is : " + dateString);
                }

                @Override
                public void onDateUnselected(Date date) {

                }
            });

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {

        if(v.equals(textViewCancel))
        {
            finish();
        }else if(v.equals(textViewOk))
        {
            StringBuilder sb= new StringBuilder();

            for(String tempString:setInput){
                sb.append("").append(tempString).append(",");
            }
//            for(String tempString:setInput){
//                finalString = "," + tempString + "," ;
//            }
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result", (Serializable) sb);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();


        }

    }
}
