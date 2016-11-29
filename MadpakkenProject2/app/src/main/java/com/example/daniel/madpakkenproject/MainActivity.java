package com.example.daniel.madpakkenproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button buttonl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonl = (Button) findViewById(R.id.buttonl);
        buttonl.setOnClickListener(this);

    }


    private void buttonlClick()
    {
        startActivity(new Intent("com.example.daniel.madpakkenproject.LoginActivity"));
}
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonl:
                buttonlClick();
                break;
        }
    }
}
