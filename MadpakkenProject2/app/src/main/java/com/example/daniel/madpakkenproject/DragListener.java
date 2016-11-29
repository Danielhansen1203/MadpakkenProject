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
    private Activity activity;

    //We need to know what plate is being used
    private int pladeNumber = 0;

    public DragListener(Activity a)
    {
        this.activity = a;
    }

    public DragListener(Activity a, int PladeIndex)
    {
        this(a); //scaffolding
        this.pladeNumber = PladeIndex;
    }

    @Override
    public boolean onDrag(View v, DragEvent event)
    {
        //handle drag events
        //execute different actions depending on what's happening
        switch (event.getAction())
        {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:

                //When moving an ingredient that's already on a plate
                //we need the id of the plate it came from
                String otherPlateId = (String) event.getClipDescription().getLabel().toString();
                
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
                Object defaultPladeTag = DesignActivity.getdefaultPlateTag();
                dropTarget.setTag(defaultPladeTag);
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
                    currentIngredient.setTag(defaultPladeTag);
                    DesignActivity.setIngredientsOnPlatesIds(Integer.parseInt(otherPlateId), defaultPladeTag.toString());
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
                    //reset image on the old plate
                    ((ImageView) currentIngredient).setImageDrawable(DesignActivity.getPlateTemplate());

                    //transfer tag from old plate to new plate
                    //droptarget is the new plate
                    //currentIngredient is the old
                    dropTarget.setTag(currentIngredient.getTag());

                    //update tags
                    //set old tag on new plate
                    DesignActivity.setIngredientsOnPlatesIds(getPladeNumber(), dropTarget.getTag().toString());

                    //reset the tag on the old plate
                    currentIngredient.setTag(defaultPladeTag);

                    //reset old plate
                    DesignActivity.setIngredientsOnPlatesIds(Integer.parseInt(otherPlateId), currentIngredient.getTag().toString());
                    break;
                }

                //if an item has already been dropped here, the drop target will have a tag
                if(tag != null)
                {
                    try
                    {
                        //TODO fix this making an error all the time
                        //set the original ingredient visible again
                        int intTag = Integer.parseInt(tag.toString());
                        this.activity.findViewById(intTag).setVisibility(View.VISIBLE);
                    }
                    catch (NumberFormatException ne)
                    {
                        Log.e("ERROR: ", ne.toString());
                    }
                    /*
                    //set the original ingredient visible again
                    int intTag = Integer.parseInt(tag.toString());
                    this.activity.findViewById(intTag).setVisibility(View.VISIBLE);
                    //this.activity.findViewById((int)tag).setVisibility(View.VISIBLE);
                    */
                }

                //update the tag on the drop target
                //dropTarget.setTag(dropped.getId());
                dropTarget.setTag(currentIngredient.getTag());

                DesignActivity.setIngredientsOnPlatesIds(pladeNumber, dropTarget.getTag().toString());

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                break;
            default:
                break;
        }
        return true;
    }

    public int getPladeNumber()
    {
        return pladeNumber;
    }
}
