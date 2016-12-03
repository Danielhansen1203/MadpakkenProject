package com.example.daniel.madpakkenproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.daniel.madpakkenproject.Classes.Menu;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;

public class ReadXMLActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_xml);

        tv = (TextView) findViewById(R.id.xmlTextView);
        tv.setText("");

        readXML();
    }

    void readXML()
    {
        XmlPullParserFactory pullParserFactory;

        Log.d("try xml","");

        try
        {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getApplicationContext().getAssets().open("XML/MenuTest.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            ArrayList<Menu> menus = null;
            int eventType = parser.getEventType();
            Menu m = null;

            Log.d("read xml","" + parser.getEventType());

            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                String name = null;

                switch (eventType)
                {
                    case XmlPullParser.START_DOCUMENT:
                        menus = new ArrayList<>();
                        Log.d("START_DOCUMENT","");
                        break;
                    case XmlPullParser.START_TAG:
                        name = parser.getName();
                        Log.d("START_TAG","");
                        if (name == "list")
                        {
                            Log.d("list","");
                            m = new Menu();
                        }
                        else if (name != null)
                        {
                            if (name == "menu")
                            {
                                Log.d("menu","");
                                //break;
                            }
                            if (name == "name")
                            {
                                Log.d("name","");
                                m.setName(parser.nextText());
                            }
                            if (name == "Price")
                            {
                                Log.d("price","");
                                m.setPrice(parser.next());
                            }
                            if(name == "desc")
                            {
                                Log.d("desc","");
                                m.setDesc(parser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        Log.d("END_TAG","");
                        name = parser.getName();
                        if(name.equalsIgnoreCase("list") && m != null)
                        {
                            menus.add(m);
                        }
                }
                eventType = parser.next();
            }
            tv.append(PrintXml(menus));
        }
        catch (XmlPullParserException xe)
        {
            xe.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
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
        }

        return newMenu;
    }
}
