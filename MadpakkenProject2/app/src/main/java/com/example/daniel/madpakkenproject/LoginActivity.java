package com.example.daniel.madpakkenproject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.paypal.android.sdk.payments.LoginActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    // Creating JSON Parser object
    LoginActivity jParser = new LoginActivity();

    JSONObject json;
    private static String url_login = "http://85.233.225.116/:8080/madpakken/login_servlet";
    //JSONArray incoming_msg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewsById();
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // execute method invokes doInBackground() where we open a Http URL connection using the given Servlet URL
                //and get output response from InputStream and return it.
                new Login().execute();

            }
        });
    }
    private void findViewsById() {

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        buttonLogin = (Button) findViewById(R.id.login_button);
    }
    private class Login extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... args) {
            // Getting username and password from user input
            String username = args[0];
            String pass = args[1];
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("u",editTextEmail));
            params.add(new BasicNameValuePair("p",editTextPassword));
            json = jParser.makeHttpRequest(url_login, "GET", params);
            String s=null;

            String s=null;

            try {
                s= json.getString("info");
                Log.d("Msg", json.getString("info"));
                if(s.equals("success")){
                    Intent login = new Intent(getApplicationContext(), Menu.class);
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                    finish();
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
/* */
            return null;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}