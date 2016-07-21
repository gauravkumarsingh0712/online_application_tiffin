package com.applicationframwork.android.views;

import android.app.ProgressDialog;
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
import com.applicationframwork.android.models.LocalModel;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 */
public class LoginScreen extends AppCompatActivity implements AbstractView, View.OnClickListener {

    TextView txtUsername;
    TextView txtPassword;
    TextView txtForgetPassword;
    TextView txtRegistered;
    Button btnLogin;
    ProgressDialog progressDialog;

    boolean validationError = false;

    LocalModel localModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_screen);
        localModel = AppController.getInstance().getModelFacade().getLocalModel();
        getSupportActionBar().hide();

        initializeComponent();
    }

    public void initializeComponent() {
        txtUsername = (TextView) findViewById(R.id.txt_username);
        txtPassword = (TextView) findViewById(R.id.txt_password);
        txtForgetPassword =(TextView) findViewById(R.id.txt_forgot_your_password);
        txtRegistered =(TextView) findViewById(R.id.txt_not_yet_registered);

        txtForgetPassword.setOnClickListener(this);
        txtRegistered.setOnClickListener(this);


        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);


        txtUsername.setText("");
        txtPassword.setText("");

    }

    private void isUsernameEmpty(String username) {
        if (username.equalsIgnoreCase("")) {
            txtUsername.setError(getString(R.string.msg_field_cannot_left_blank));
            validationError = true;
        }
    }

    private void isPasswordEmtpy(String password) {
        if (password.equalsIgnoreCase("")) {
            txtPassword.setError(getString(R.string.msg_field_cannot_left_blank));
            validationError = true;
        }
    }

    @Override
    public void onClick(View v) {

        if (v.equals(btnLogin)) {
            validationError = false;
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();

            isUsernameEmpty(username);
            isPasswordEmtpy(password);

            if (!localModel.isEmailValid(username)) {
                txtUsername.setError(getString(R.string.msg_email_format_is_incorrect));
                validationError = true;

            }

            if (validationError) {
                return;
            }

//            progressDialog = new ProgressDialog(this);
//            progressDialog.setCancelable(true);
//            progressDialog.setMessage("Signing In ...");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.setProgress(0);
//            progressDialog.setMax(100);
//            progressDialog.show();
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show();
            AppController.getInstance().handleEvent(AppDefines.EVENT_ID_SELECT_DATE_SCREEN);
            finish();
        }else if(v.equals(txtForgetPassword))
        {
            Toast.makeText(this, "Coming Soon!", Toast.LENGTH_LONG).show();
        }else if(v.equals(txtRegistered))
        {
            Toast.makeText(this, "Coming Soon!", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void update() {


    }
}
