package com.example.daniel.madpakkenproject;

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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class PayActivity extends AppCompatActivity {

    TextView m_response;
    TextView m_paynow;

    PayPalConfiguration m_configuration;
    String m_paypalClientID = "AQ0Zhk2BvZfTJliMIB4TmB0kw9Krhjl5sCyZwiuCs3RAyyiTJd_gPOcVwyRdyNDKiYdzDwgNBOAUgFHv";
    Intent m_service;
    int m_paypalRequestCode = 999;
    int getTotal = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        final LinearLayout showCartContent = (LinearLayout) findViewById(R.id.showcart);

        final Button btn3 = (Button)findViewById(R.id.third);

        final Controller ct = (Controller)getApplicationContext();

        final int CartSize = ct.getCart().getCartsize();


        final Button remove = new Button(this);

        if (CartSize >0){
            for(int i=0;i<CartSize;i++) {



                String pName = ct.getCart().getProducts(i).getProductName();

                final int pPrice = ct.getCart().getProducts(i).getProductPrice();

                getTotal += pPrice;

                final TextView show = new TextView(this);
                show.setText(pName+" Pris: "+pPrice);

                final LinearLayout la = new LinearLayout(this);

                la.setOrientation(LinearLayout.HORIZONTAL);

                final Button btn1 = new Button(this);


                btn1.setId(i+1);
                btn1.setText("Remove");

                la.addView(show);


                final int index = i;

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("TAG", "Index:"+index);

                        ModelProducts productsObject = ct.getProducts(index);
                        la.removeAllViews();
                    }
                });

                la.addView(btn1);

                showCartContent.addView(la);


            }



        }

        else {




        }

           /* btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(CartSize>0){

                        Intent i = new Intent(getBaseContext(),PayActivity.class);
                        startActivity(i);


                    }else
                        Toast.makeText(getApplicationContext(), "Shopping Cart is Empty", Toast.LENGTH_LONG).show();
                }
            });
        }*/



        m_response = (TextView) findViewById(R.id.response);
        m_paynow = (TextView) findViewById(R.id.paynow);
        m_paynow.setText("Betal i alt: "+getTotal+" Kr");

        m_configuration = new PayPalConfiguration()
                .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
                .clientId(m_paypalClientID);

        m_service = new Intent(this, PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        startService(m_service);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuinflater = getMenuInflater();
        mMenuinflater.inflate(R.menu.profile_menu, menu);
        return true;
    }

    void pay(View view)
    {
        PayPalPayment payment= new PayPalPayment(new BigDecimal(getTotal), "DKK", "Samlet pris fra Madpakken", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, m_paypalRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == m_paypalRequestCode)
        {
            if(resultCode == Activity.RESULT_OK);
            {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                if(confirmation != null)
                {
                    String state = confirmation.getProofOfPayment().getState();

                    if(state.equals("approved"))
                        m_response.setText("Betalingen er nu gennemført");

                    else
                        m_response.setText("Fejl i betalingen");
                }
                else
                    m_response.setText("Kunne ikke bekræfte");
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_frontpage) {
            Intent intent = new Intent(PayActivity.this, Front_page.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_pay) {
            Intent intent = new Intent(PayActivity.this, PayActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_profil) {
            Intent intent = new Intent(PayActivity.this, Profile_page.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_about_us) {
            Intent intent = new Intent(PayActivity.this, AboutUs.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
