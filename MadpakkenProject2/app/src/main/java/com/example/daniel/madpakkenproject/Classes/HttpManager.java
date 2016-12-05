package com.example.daniel.madpakkenproject.Classes;

import android.app.Activity;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 05-12-2016.
 */

public class HttpManager {

    List<ResponseRecieved> listeners = new ArrayList<>();

    RequestQueue requestQueue;
    StringRequest stringRequest;
    String url = "http://85.233.225.116:8080/MadpakkenprojectXML";

    public void getConnection(String u) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url+u,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        for (ResponseRecieved r : listeners) {
                            r.onResponse(response);
                            Log.d("HTTP", "onResponse");
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        requestQueue.start();

    }

    public void addListener(ResponseRecieved rr) {

        listeners.add(rr);
        Log.d("HTTP add Listener", "ResponseRecieved");
    }


    public HttpManager(Activity a) {
        requestQueue = Volley.newRequestQueue(a);
    }

// Add the request to the RequestQueue.


}
