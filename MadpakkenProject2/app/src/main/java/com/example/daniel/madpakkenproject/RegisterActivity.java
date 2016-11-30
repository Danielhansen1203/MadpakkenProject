package com.example.daniel.madpakkenproject;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class RegisterActivity extends AppCompatActivity {

    EditText Name,LastName,Email,Pass,ConPass;
    private Spinner school;
    Button reg_button;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = (EditText)findViewById(R.id.reg_name);
        LastName = (EditText)findViewById(R.id.reg_lastname);
        Email = (EditText)findViewById(R.id.reg_email);
        Spinner School = (Spinner) findViewById(R.id.reg_school);
       // School = () findViewById(R.id.reg_school);
        Pass = (EditText)findViewById(R.id.reg_password);
        ConPass = (EditText)findViewById(R.id.reg_con_pass);
        reg_button = (Button)findViewById(R.id.reg_button);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().equals("")||LastName.getText().toString().equals("")||Email.getText().toString().equals("")||Pass.getText().toString().equals(""))
                {
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Noget gik galt...");
                    builder.setMessage("Udfyld venligst alle felter..");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener()

                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

                else if (!(Pass.getText().toString().equals(ConPass.getText().toString())))
                {
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Noget gik galt...");
                    builder.setMessage("Adgangskode stemmer ikke over ens..");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener()

                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Pass.setText("");
                            ConPass.setText("");
                        }

                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else
                {
                    BackgroundTask backgroundTask = new BackgroundTask(RegisterActivity.this);
                    backgroundTask.execute("register",Name.getText().toString(),LastName.getText().toString(),Email.getText().toString(),Pass.getText().toString());
                }
            }
        });
    }
}
