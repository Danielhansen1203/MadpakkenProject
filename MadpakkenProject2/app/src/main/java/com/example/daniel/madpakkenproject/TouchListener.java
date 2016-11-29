package com.example.daniel.madpakkenproject;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;

//Whatever object that has this on it can be dragged
final class TouchListener implements View.OnTouchListener
{
    //the index of the plate being dragged
    private String plateNum = "";

    public TouchListener()
    {
        if (plateNum.isEmpty())
        {
            plateNum = "-1";
        }
    }

    public TouchListener(String plateNumber)
    {
        this(); //scaffolding
        this.plateNum = plateNumber;
    }

    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
        //MotionEvent keeps track of and reports motions made by the user
        //in this case we check if the user is pressing down on the screen
        {
            //setup drag
            //used to temperately store the data the user grabs
            //it acts likes a clip board and is mostly used for copy paste
            //in this case we also use it as an extra tag
            ClipData data = ClipData.newPlainText(plateNum,"");

            //A view represents the basic building block for user interface components
            //it's just a block with some ui data in it
            //DragShadowBuilder creates an image that the system displays during the drag and drop operation. This is called a "drag shadow".
            //The default implementation for a DragShadowBuilder based on a View returns an image that has exactly the same appearance as the given View
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            //hides the non dragged view
            //view.setVisibility(View.INVISIBLE);

            //Start dragging the item touched
            //Recently deprecated in API 24
            //But since we are on API 15 we don't have a choice
            view.startDrag(data, shadowBuilder, view ,0);

            return true;
        }
        else
        {
            //show the object on it's original position
            view.setVisibility(View.VISIBLE);

            return false;
        }
    }
}
