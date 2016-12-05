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


    /*  public List<Menu> getMenus() {

          getConnection(url + "/MenuServlet");
          //create new XStream
          XStream xstream = new XStream();
          //set custom tag name
          xstream.alias("menu", Menu.class);

          //used to store the returned data
          ArrayList<Menu> menuList = new ArrayList<Menu>();

          //grap xml resualts and add them to our list


          //transform into xml
          try
          {
             // menuList = (ArrayList) xstream.fromXML(menuList);
              //tv.setText(a.get(0).getName());
              //Log.d("XML", "" + a.get(0).toString());
          }
          catch (IOException ioe)
          {
              Log.e("ERROR", "" + ioe.toString());
          }
          catch (ClassCastException cce)
          {
              Log.e("ERROR", "" + cce.toString());
          }
          catch (StreamException se)
          {
              Log.e("ERROR", "" + se.toString());
          }
          catch(Exception e)
          {
              Log.e("ERROR", "" + e.toString());
          }
      }


      }
  */
    public HttpManager(Activity a) {
        requestQueue = Volley.newRequestQueue(a);
   //     getConnection(url + "/MenuServlet");

    }

// Add the request to the RequestQueue.


}
