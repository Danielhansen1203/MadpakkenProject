package com.example.daniel.madpakkenproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView about = (TextView)findViewById(R.id.about_us);

        about.setText("Madpakken er en Skoleejet, app med hovedsæde i Ringsted. Appen blev grundlagt i 2016 af Samet"+
                ", Martin og Daniel og med de ikoniske madpakker er Appen en af Danmarks førende leverandører af madpakker." +
                "Inspireret af virksomhedens motto \"Det bedste er ikke for godt” (Only the best is good enough)" +
                "er Appen engageret i børns udvikling og har som mål at inspirere, udvikle og bespise dem, der skal bygge" +
                "fremtiden gennem kreativ mad. Madpakken produkter sælges i hele Danmark og kan opleves virtuelt i selve appen.");

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }

    //Creating the menu in the right corner
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuinflater = getMenuInflater();
        mMenuinflater.inflate(R.menu.profile_menu, menu);
        return true;
    }


    //Creating link to diffrent pages
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_frontpage) {
            Intent intent = new Intent(AboutUs.this, Front_page.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_pay) {
            Intent intent = new Intent(AboutUs.this, PayActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_profil) {
            Intent intent = new Intent(AboutUs.this, Profile_page.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_about_us) {
            Intent intent = new Intent(AboutUs.this, AboutUs.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
