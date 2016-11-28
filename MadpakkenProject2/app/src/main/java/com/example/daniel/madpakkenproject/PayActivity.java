package com.example.daniel.madpakkenproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        TextView showCartContent = (TextView)findViewById(R.id.showcart);

        final Button btn3 = (Button)findViewById(R.id.third);

        final Controller ct = (Controller)getApplicationContext();

        final int CartSize = ct.getCart().getCartsize();

        String show = "";


        if (CartSize >0){
            for(int i=0;i<CartSize;i++) {
                String pName = ct.getCart().getProducts(i).getProductName();

                int pPrice = ct.getCart().getProducts(i).getProductPrice();

                String pDisc = ct.getCart().getProducts(i).getProductDesc();

                getTotal += pPrice;


                show += "Product Name: "+pName+" "+"Price : "+pPrice+""+"Description : "+pDisc+""+
                        "------------------------------------------------"+"";


            }



            showCartContent.setText(show);

        }

        else {
            show = "Der er intet i kurven";

            showCartContent.setText(show);
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
}
