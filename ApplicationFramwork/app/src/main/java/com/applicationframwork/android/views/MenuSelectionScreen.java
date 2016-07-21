package com.applicationframwork.android.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.applicationframwork.android.R;
import com.applicationframwork.android.adapters.MenuAdapter;
import com.applicationframwork.android.controllers.AppController;
import com.applicationframwork.android.defines.AppDefines;

import java.util.ArrayList;

/**
 * Created by gauravkumar.singh on 7/21/2016.
 */
public class MenuSelectionScreen extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    Button paymentButton;
    MenuAdapter menuAdapter;
    ArrayList<String> menuArrayList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_screen);
      //  getSupportActionBar().hide();


        addDataMenuList();


        initViews();
        initListener();
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.menu_list);
        paymentButton = (Button) findViewById(R.id.payment_button);
        paymentButton.setOnClickListener(this);
    }

    private void initListener()
    {
        menuAdapter = new MenuAdapter(this,menuArrayList);
        listView.setAdapter(menuAdapter);

    }

    private void addDataMenuList()
    {
        menuArrayList = new ArrayList<>();
        menuArrayList.add("Panner");
        menuArrayList.add("Roti");
        menuArrayList.add("Daal");
        menuArrayList.add("Mix veg");
        menuArrayList.add("Daal Makhne");
        menuArrayList.add("Chole");
        menuArrayList.add("Rajma");
        menuArrayList.add("Rice");
        menuArrayList.add("Sweet");
        menuArrayList.add("Aalu");
        menuArrayList.add("aalu Gobhi");

    }

    @Override
    public void onClick(View v) {

        if(v.equals(paymentButton)) {
            AppController.getInstance().handleEvent(AppDefines.EVENT_ID_SELECT_PAYMENT_SCREEN);
        }
    }
}
