package com.example.daniel.madpakkenproject;

import android.app.Activity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

//Whatever object that has this on it can accept
//another object being dropped on it
class DragListener implements View.OnDragListener
{
    //We must have the current activity (page)
    Activity activity;

    public DragListener(Activity a)
    {
        this.activity = a;
    }

    @Override
    public boolean onDrag(View v, DragEvent event)
    {

        //handle drag events
        //execute different actions depending on what's happening
        switch (event.getAction())
        {
            case DragEvent.ACTION_DRAG_STARTED:

                Log.i("","DRAG_STARTED");
                Log.d("", event.toString());

                break;
            case DragEvent.ACTION_DRAG_ENTERED:

                //Log.i("","DRAG_ENTERED");

                break;
            case DragEvent.ACTION_DRAG_EXITED:

                //Log.i("","DRAG_EXITED");

                break;
            case DragEvent.ACTION_DROP:

                //get the current ingredient being dropped
                View currentIngredient = (View) event.getLocalState();
                //get the image view of ingredient being dropped
                ImageView dropped = (ImageView) currentIngredient;
                //our chosen drop target (plate)
                ImageView dropTarget = (ImageView) v;

                //Id's of the plates
                List<Integer> plateIds = new ArrayList<Integer>();
                plateIds.add(DesignActivity.getIngredientChoice01().getId());
                plateIds.add(DesignActivity.getIngredientChoice02().getId());
                plateIds.add(DesignActivity.getIngredientChoice03().getId());
                plateIds.add(DesignActivity.getIngredientChoice04().getId());

                //Id's of the ingredients
                List<Integer> ingredientIds = new ArrayList<Integer>();
                ingredientIds.add(DesignActivity.getIngredient_bacon().getId());
                ingredientIds.add(DesignActivity.getIngredient_cheese().getId());
                ingredientIds.add(DesignActivity.getIngredient_egg().getId());
                ingredientIds.add(DesignActivity.getIngredient_salad().getId());
                ingredientIds.add(DesignActivity.getIngredient_tomato().getId());

                //get the tag of the drop target
                Object stag = plateIds.get(0);
                dropTarget.setTag(stag);
                Object tag = dropTarget.getTag();

                //prevent plates form being dropped on ech other
                if( dropped.getDrawable().getConstantState().equals(this.activity.getResources().getDrawable(R.drawable.plate).getConstantState()))
                {
                    break;
                }

                //check if something is dropped on the remove ingredient imageview
                //then reset the plate it came from
                if(dropTarget.getId() == R.id.imageView_null && !ingredientIds.contains(currentIngredient.getId()))
                {
                    //in this case the plate is 'currentIngredient'
                    ((ImageView) currentIngredient).setImageDrawable(DesignActivity.getPlateTemplate());
                    currentIngredient.setTag(stag);
                    break;
                }
                //prevent ingredients from being dropped in the remove ingredient imageview
                else if(dropTarget.getId() == R.id.imageView_null)
                {
                    break;
                }

                //change the icon to the ingredient being dropped on it
                dropTarget.setImageDrawable(dropped.getDrawable());



                //if an ingredient is dragged from one plate to another
                //reset the first plate
                if(plateIds.contains(dropped.getId()))
                {
                    ((ImageView) currentIngredient).setImageDrawable(DesignActivity.getPlateTemplate());
                    currentIngredient.setTag(stag);
                }

                //if an item has already been dropped here, the drop target will have a tag
                if(tag != null)
                {
                    //set the original ingredient visible again
                    this.activity.findViewById((int)tag).setVisibility(View.VISIBLE);
                    Log.d("ID", tag.toString());
                }

                //update the tag on the drop target
                dropTarget.setTag(dropped.getId());

                DesignActivity.setIngredientsOnPlatesIds(0, (int)dropTarget.getTag());

                //Log.i("","DRAG_DROP");

                break;
            case DragEvent.ACTION_DRAG_ENDED:

                //Log.i("","DRAG_ENDED");

                break;
            default:

                //Log.i("","DRAG_default");

                break;
        }
        return true;
    }
}
