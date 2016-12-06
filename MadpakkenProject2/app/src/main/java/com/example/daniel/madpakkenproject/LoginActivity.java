package com.example.daniel.madpakkenproject;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    AlertDialog.Builder builder;
    private boolean loggedIn = false;

    public void onClick(View v)
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        buttonLogin = (Button) findViewById(R.id.login_button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //editTextEmail.trim().length() > 0 && editTextPassword.trim() > 0
                //Email.getText().toString().equals("")||Pass.getText().toString().equals("")
                if(editTextEmail.toString().equals("")||editTextPassword.toString().equals(""))
                {
                    // login user
                    checkLogin(editTextEmail, editTextPassword);
                    builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Noget gik galt...");
                    builder.setMessage("Udfyld venligst alle felter..");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.dismiss();
                        }

                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else
                {
                    BackgroundTask backgroundTask = new BackgroundTask(LoginActivity.this);
                    backgroundTask.execute("login",editTextEmail.getText().toString(),editTextPassword.getText().toString());
                }
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivityForResult(intent, 0);

            }
        });



        Button buttonReg = (Button) findViewById(R.id.buttonReg);
        buttonReg.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
                startActivityForResult(intent, 0);
            }
        });


    }

    private void checkLogin(EditText editTextEmail, EditText editTextPassword) {
    }
}
