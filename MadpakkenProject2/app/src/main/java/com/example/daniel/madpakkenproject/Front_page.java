package com.example.daniel.madpakkenproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Front_page extends AppCompatActivity {

    Button menu;
    Button design;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

       menu = (Button) findViewById(R.id.menu);
       design = (Button) findViewById(R.id.design);
       pay =  (Button) findViewById(R.id.pay);

       menu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Front_page.this, MenuActivity.class);
               startActivity(intent);
           }
       });

        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Front_page.this, DesignActivity.class);
                startActivity(intent);
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Front_page.this, PayActivity.class);
                startActivity(intent);
            }
        });
    }
}
