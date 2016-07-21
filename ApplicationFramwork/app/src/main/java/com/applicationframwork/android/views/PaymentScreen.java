package com.applicationframwork.android.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.applicationframwork.android.R;

/**
 * Created by gauravkumar.singh on 7/21/2016.
 */
public class PaymentScreen extends AppCompatActivity implements View.OnClickListener {

    Button paymentButton;
    TextView textDebit;
    TextView textCredit;
    TextView textnet;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.payment_screen);
        //  getSupportActionBar().hide();

        initViews();
        initListener();
    }

    private void initViews() {
        paymentButton = (Button) findViewById(R.id.payment_button);
        paymentButton.setOnClickListener(this);

        textDebit = (TextView) findViewById(R.id.txt_debit);
        textCredit = (TextView) findViewById(R.id.txt_credit);
        textnet = (TextView) findViewById(R.id.txt_net);

        textDebit.setOnClickListener(this);
        textCredit.setOnClickListener(this);
        textnet.setOnClickListener(this);

    }

    private void initListener() {


    }


    @Override
    public void onClick(View v) {
        if(v.equals(paymentButton))
        {
            Toast.makeText(this, "Successfully Payment!", Toast.LENGTH_LONG).show();
        }else if(v.equals(textDebit))
        {
            Toast.makeText(this, "Coming Soon!", Toast.LENGTH_LONG).show();
        }else if(v.equals(textCredit))
        {
            Toast.makeText(this, "Coming Soon!", Toast.LENGTH_LONG).show();
        }else if(v.equals(textnet))
        {
            Toast.makeText(this, "Coming Soon!", Toast.LENGTH_LONG).show();
        }
    }
}