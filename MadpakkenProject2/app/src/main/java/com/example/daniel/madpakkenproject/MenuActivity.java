package com.example.daniel.madpakkenproject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final LinearLayout layout = (LinearLayout)findViewById(R.id.linearmain);
        final Button btn = (Button)findViewById(R.id.second);

        final Controller ct = (Controller) getApplicationContext();

        ModelProducts products = null;

        for(int i=1; i<=7;i++){

            int Price =15+i;

            products = new ModelProducts("Product item" +i, "Description"+i, Price);

            ct.setProducts(products);

        }

        int productsize = ct.getProductArraylistsize();

        for (int j=0; j< productsize; j++){

            String pName = ct.getProducts(j).getProductName();
            int pPrice = ct.getProducts(j).getProductPrice();

            LinearLayout la = new LinearLayout(this);

            la.setOrientation(LinearLayout.HORIZONTAL);

            TextView tv = new TextView(this);

            tv.setText(" " +pName+" ");

            la.addView(tv);

            TextView tv1 = new TextView(this);

            tv1.setText("$"+pPrice+" ");

            la.addView(tv1);

            final Button btn1 = new Button(this);

            btn1.setId(j+1);
            btn1.setText("Add To Cart");

            final int index = j;

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "Index:"+index);

                    ModelProducts productsObject = ct.getProducts(index);

                    if(!ct.getCart().CheckProductInCart(productsObject)) {

                        btn1.setText("Item added");
                        ct.getCart().setProducts(productsObject);

                        Toast.makeText(getApplicationContext(), "New CartSize:" + ct.getCart().getCartsize(), Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(getApplicationContext(), "Products"+(index+1),Toast.LENGTH_LONG).show();
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






    }
}
