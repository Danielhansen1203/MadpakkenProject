package com.example.daniel.madpakkenproject.Classes;

import android.app.Activity;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.thoughtworks.xstream.XStream;

/**
 * Created by Daniel on 05-12-2016.
 */

public class HttpManager  {

    RequestQueue requestQueue;
    StringRequest stringRequest;
    String url ="85.233.225.116:8080/MadpakkenprojectXML";



public HttpManager() {

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    XStream xstream = new XStream();

                    response.substring(0,500));
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mTextView.setText("That didn't work!");
        }
    });
// Add the request to the RequestQueue.
    requestQueue.add(stringRequest);
    requestQueue.start();

}



}
