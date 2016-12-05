package com.example.daniel.madpakkenproject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.madpakkenproject.Classes.ChangedListener;
import com.example.daniel.madpakkenproject.Classes.MenuConverter;

import org.w3c.dom.Text;

import java.util.List;

public class MenuActivity extends AppCompatActivity implements ChangedListener {

    Controller ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ct = (Controller) getApplicationContext();
        final LinearLayout layout = (LinearLayout) findViewById(R.id.linearmain);
        final Button btn = (Button) findViewById(R.id.second);
        MenuConverter mc = new MenuConverter(this);
        mc.addListener(this);


        ModelProducts products = null;

//Creating an array of products


        int productsize = ct.getProductArraylistsize();

        for (int j = 0; j < productsize; j++) {

            final String pName = ct.getProducts(j).getProductName();
            int pPrice = ct.getProducts(j).getProductPrice();
            final String dDesc = ct.getProducts(j).getProductDesc();

            LinearLayout la = new LinearLayout(this);

            la.setOrientation(LinearLayout.VERTICAL);

            TextView tv = new TextView(this);

            tv.setText(" " + pName + ": ");

            la.addView(tv);

            TextView tv2 = new TextView(this);

            tv2.setText(" " + dDesc + "  ");

            la.addView(tv2);

            TextView tv1 = new TextView(this);

            tv1.setText(" " + pPrice + " Kr ");

            la.addView(tv1);

            final Button btn1 = new Button(this);


            btn1.setId(j + 1);
            btn1.setText("Tilføj til kurv");


            final int index = j;

            //The Button is told what to do
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "Index:" + index);

                    ModelProducts productsObject = ct.getProducts(index);

                    if (ct.getCart().CheckProductInCart(productsObject)) {
                        ct.getCart().setProducts(productsObject);
                        Toast.makeText(getApplicationContext(), "Du har tilføjet en ekstra af " + pName, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Du har nu " + ct.getCart().getCartsize() + " ting i vognen", Toast.LENGTH_LONG).show();
                    }
                    if (!ct.getCart().CheckProductInCart(productsObject)) {


                        ct.getCart().setProducts(productsObject);

                        Toast.makeText(getApplicationContext(), "Du har nu " + ct.getCart().getCartsize() + " ting i vognen", Toast.LENGTH_LONG).show();

                    }


                }
            });
            la.addView(btn1);

            layout.addView(la);

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getBaseContext(), PayActivity.class);
                startActivity(in);
            }
        });


        //Creating an toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mc.doProces();
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
        if (item.getItemId() == R.id.action_frontpage) {
            Intent intent = new Intent(MenuActivity.this, Front_page.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_pay) {
            Intent intent = new Intent(MenuActivity.this, PayActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_profil) {
            Intent intent = new Intent(MenuActivity.this, Profile_page.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_about_us) {
            Intent intent = new Intent(MenuActivity.this, AboutUs.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMenuChanged(List<com.example.daniel.madpakkenproject.Classes.Menu> menus) {
        Log.d("MenuA", "onMenuChanged");
        ct.removeProducts();
        for (int i = 0 ; i <= menus.size(); i++) {

            ModelProducts products = new ModelProducts(menus.get(i).getName(), menus.get(i).getDesc(), menus.get(i).getPrice());

            ct.setProducts(products);
        }


        }
    }

