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

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final LinearLayout layout = (LinearLayout) findViewById(R.id.linearmain);
        final Button btn = (Button)findViewById(R.id.second);

        final Controller ct = (Controller) getApplicationContext();

        ModelProducts products = null;


        for(int i=ct.getProductArraylistsize()+1; i<=7;i++){

            int Price =15+i;

            products = new ModelProducts("Menu " +i, "Description"+i, Price);

            ct.setProducts(products);

        }

        int productsize = ct.getProductArraylistsize();

        for (int j=0; j< productsize; j++){

            final String pName = ct.getProducts(j).getProductName();
            int pPrice = ct.getProducts(j).getProductPrice();

            LinearLayout la = new LinearLayout(this);

            la.setOrientation(LinearLayout.HORIZONTAL);

            TextView tv = new TextView(this);

            tv.setText(" " +pName+": ");

            la.addView(tv);

            TextView tv1 = new TextView(this);

            tv1.setText(" "+pPrice+" Kr ");

            la.addView(tv1);

            final Button btn1 = new Button(this);


            btn1.setId(j+1);
            btn1.setText("Tilføj til kurv");



            final int index = j;

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "Index:"+index);

                    ModelProducts productsObject = ct.getProducts(index);

                    if(ct.getCart().CheckProductInCart(productsObject)){
                        ct.getCart().setProducts(productsObject);
                        Toast.makeText(getApplicationContext(), "Du har tilføjet en ekstra af "+ pName, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Du har nu " + ct.getCart().getCartsize()+" ting i vognen", Toast.LENGTH_LONG).show();
                    }
                    if(!ct.getCart().CheckProductInCart(productsObject)) {


                        ct.getCart().setProducts(productsObject);

                        Toast.makeText(getApplicationContext(), "Du har nu " + ct.getCart().getCartsize()+" ting i vognen", Toast.LENGTH_LONG).show();

                    }



                }
            });
            la.addView(btn1);

            layout.addView(la);

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getBaseContext(),PayActivity.class);
                startActivity(in);
            }
        });



        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuinflater = getMenuInflater();
        mMenuinflater.inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_frontpage) {
            Intent intent = new Intent(MenuActivity.this, Front_page.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_pay) {
            Intent intent = new Intent(MenuActivity.this, PayActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_profil) {
            Intent intent = new Intent(MenuActivity.this, Profile_page.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_about_us) {
            Intent intent = new Intent(MenuActivity.this, AboutUs.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
