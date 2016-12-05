package com.example.daniel.madpakkenproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.daniel.madpakkenproject.Classes.HttpManager;
import com.example.daniel.madpakkenproject.Classes.Menu;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;

import java.io.IOException;
import java.util.ArrayList;

public class ReadXMLActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_xml);
        HttpManager ht = new HttpManager(this);
        tv = (TextView) findViewById(R.id.xmlTextView);
        tv.setText("");

        readXML();
    }

    void readXML()
    {
        //create new XStream
        XStream xstream = new XStream();
        //set custom tag name
        xstream.alias("menu", Menu.class);

        ArrayList<Menu> a = new ArrayList<>();

        Log.d("TRYING","");

        try
        {
            a = (ArrayList) xstream.fromXML(getResources().getAssets().open("XML/MenuTest.xml"));
            tv.setText(a.get(0).getName());
            Log.d("XML", "" + a.get(0).toString());
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

    private String PrintXml(ArrayList<Menu> input)
    {
        String newMenu = "none";

        Log.d("input.size", "" + input.size());

        for (int i = 0; i <= input.size(); i++)
        {
            newMenu = "";
            newMenu += input.get(i).getName() + "/n";
            newMenu += input.get(i).getDesc() + "/n";
            newMenu += input.get(i).getPrice() + "/n";
            newMenu += input.size();
        }

        return newMenu;
    }
}
