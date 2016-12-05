package com.example.daniel.madpakkenproject.Classes;

import android.app.Activity;
import android.support.v7.util.ListUpdateCallback;
import android.util.Log;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 05-12-2016.
 */

public class MenuConverter implements ResponseRecieved {

    List<MenuChangedListener> listeners = new ArrayList<>();
    HttpManager http;

    public void addListener(MenuChangedListener ml) {
        listeners.add(ml);
    }


    public void doProces() {
        http.getConnection("/MenuServlet");


    }

    public MenuConverter(Activity a) {
        http = new HttpManager(a);
        http.addListener(this);

    }

    @Override
    public void onResponse(String response) {
        Log.d("MenuC", "onResponse");
        //create new XStream
        XStream xstream = new XStream();
        //set custom tag name
        xstream.alias("menu", Menu.class);

        //used to store the returned da. lista
        ArrayList<Menu> menuList = new ArrayList<Menu>();

        //grap xml resualts and add them to our list


        //transform into xml
        try {
            menuList = (ArrayList) xstream.fromXML(response);
            Log.d("XML", "try " + menuList.get(0).getName() + " " + menuList.get(0).getDesc() + " " + menuList.get(0).getPrice());

            //!
            for(MenuChangedListener ml :listeners){
                Log.d("MenuC","onMenuChanged");
                ml.onMenuChanged(menuList);
            }
        } catch (ClassCastException cce) {
            Log.e("ERROR", "" + cce.toString());
        } catch (StreamException se) {
            Log.e("ERROR", "" + se.toString());
        } catch (Exception e) {
            Log.e("ERROR", "" + e.toString());
        }
    }
}
