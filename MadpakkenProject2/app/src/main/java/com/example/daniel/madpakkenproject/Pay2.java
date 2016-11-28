package com.example.daniel.madpakkenproject;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pay2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);

        TextView showCartContent = (TextView)findViewById(R.id.showcart);

        final Controller ct = (Controller)getApplicationContext();

        final int CartSize = ct.getCart().getCartsize();

        String show = "";

        if (CartSize >0){
            for(int i=0;i<CartSize;i++) {
                String pName = ct.getCart().getProducts(i).getProductName();

                int pPrice = ct.getCart().getProducts(i).getProductPrice();

                String pDisc = ct.getCart().getProducts(i).getProductDesc();

                show += "Product Name: "+pName+" "+"Price : "+pPrice+""+"Description : "+pDisc+""+
                        "----------------------------------------";
            }
        }

        showCartContent.setText(show);

    }
}
