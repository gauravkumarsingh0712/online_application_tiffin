package com.applicationframwork.android.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.applicationframwork.android.R;
import com.applicationframwork.android.controllers.AppController;
import com.applicationframwork.android.defines.AppDefines;

import java.util.Calendar;

/**
 * Created by gauravkumar.singh on 7/20/2016.
 */
public class SelectedDateScreen extends AppCompatActivity implements View.OnClickListener {

    Button selectDateButton;
    TextView selectedDates;
    TextView selectedDatesLists;
    Button menuButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.selected_date_screen);
        //getSupportActionBar().hide();

        initViews();
    }

    private void initViews() {


        selectDateButton = (Button) findViewById(R.id.select_date_button);
        selectDateButton.setOnClickListener(this);

        selectedDates = (TextView) findViewById(R.id.txt_selected_dates);
        selectedDatesLists = (TextView) findViewById(R.id.txt_selected);

        menuButton = (Button) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.equals(selectDateButton)) {

            Intent i = new Intent(this, DateScreen.class);
            startActivityForResult(i, 100);
            //AppController.getInstance().handleEvent(AppDefines.EVENT_ID_SELECT_DATE_VIEW_SCREEN);
           // openIssueDatePicker();
        }else if (v.equals(menuButton)) {
            if(selectedDates.getVisibility() == View.VISIBLE) {
                AppController.getInstance().handleEvent(AppDefines.EVENT_ID_SELECT_MENU_SCREEN);
            }else
            {
                Toast.makeText(this, "Please Select Date!", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void openIssueDatePicker() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);



//        DatePickerDialog datePickerDialog = new DatePickerDialog(SelectedDateScreen.this,
//                new DatePickerDialog.OnDateSetListener() {
//
//                    @Override
//                    public void onDateSet(DatePicker view, int year,
//                                          int monthOfYear, int dayOfMonth) {
//                        selectedDates.setVisibility(View.VISIBLE);
//                        selectedDatesLists.setVisibility(View.VISIBLE);
//                        selectedDatesLists.setText(Utils.getDateYYYYMMDDToDDMMYYYY(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth));
//                        selectedDatesLists.setError(null);
//
//                    }
//                }, mYear, mMonth, mDay);
//
//
//        datePickerDialog.show();



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                selectedDates.setVisibility(View.VISIBLE);
                        selectedDatesLists.setVisibility(View.VISIBLE);
                        selectedDatesLists.setText(result);
                        selectedDatesLists.setError(null);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}

