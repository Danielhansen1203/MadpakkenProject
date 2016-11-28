package com.example.daniel.madpakkenproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DesignActivity extends AppCompatActivity {

    //debug
    private Button button;
    private TextView infobox;

    //setup drop targets
    private static ImageView ingredientChoice01, ingredientChoice02, ingredientChoice03, ingredientChoice04,
    //setup ingredients
    ingredient_bacon, ingredient_egg, ingredient_salad, ingredient_cheese, ingredient_tomato,
    //other
    removeIngredient;

    //stores the icon used to reset a plate when an ingredient is moved
    private static Drawable plateTemplate;

    //hashtable to store all id's of ui elements
    //public Dictionary uiIds;

    //store what ingredients is on the 4 plates
    private static String[] ingredientsOnPlatesIds;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        //assign variables to their XML counter parts
        ingredientChoice01 = (ImageView) findViewById(R.id.imageView_ingredient_target_01);
        ingredientChoice02 = (ImageView) findViewById(R.id.imageView_ingredient_target_02);
        ingredientChoice03 = (ImageView) findViewById(R.id.imageView_ingredient_target_03);
        ingredientChoice04 = (ImageView) findViewById(R.id.imageView_ingredient_target_04);

        ingredient_bacon = (ImageView) findViewById(R.id.imageView_ingredient_bacon);
        ingredient_egg = (ImageView) findViewById(R.id.imageView_ingredient_egg);
        ingredient_salad = (ImageView) findViewById(R.id.imageView_ingredient_salad);
        ingredient_cheese = (ImageView) findViewById(R.id.imageView_ingredient_cheese);
        ingredient_tomato = (ImageView) findViewById(R.id.imageView_ingredient_tomato);

        removeIngredient = (ImageView) findViewById(R.id.imageView_null);

        //make ingredients draggable
        ingredient_bacon.setOnTouchListener(new TouchListener());
        ingredient_egg.setOnTouchListener(new TouchListener());
        ingredient_salad.setOnTouchListener(new TouchListener());
        ingredient_cheese.setOnTouchListener(new TouchListener());
        ingredient_tomato.setOnTouchListener(new TouchListener());

        //make drop targets accept drops
        ingredientChoice01.setOnDragListener(new DragListener(this));
        ingredientChoice02.setOnDragListener(new DragListener(this));
        ingredientChoice03.setOnDragListener(new DragListener(this));
        ingredientChoice04.setOnDragListener(new DragListener(this));

        //allow ingredients to be dragged off the plates
        ingredientChoice01.setOnTouchListener(new TouchListener());
        ingredientChoice02.setOnTouchListener(new TouchListener());
        ingredientChoice03.setOnTouchListener(new TouchListener());
        ingredientChoice04.setOnTouchListener(new TouchListener());

        //used to remove ingredients from the plates
        removeIngredient.setOnDragListener(new DragListener(this));

        //setup icon id's
        /*uiIds = new Hashtable();
        uiIds.put("BaconID", ingredient_bacon.getId());
        uiIds.put("CheeseID", ingredient_cheese.getId());
        uiIds.put("EggID", ingredient_egg.getId());
        uiIds.put("SaladID", ingredient_salad.getId());
        uiIds.put("TomatoID", ingredient_tomato.getId());
        uiIds.put("plate01ID", ingredientChoice01.getId());
        uiIds.put("plate02ID", ingredientChoice02.getId());
        uiIds.put("plate03ID", ingredientChoice03.getId());
        uiIds.put("plate04ID", ingredientChoice04.getId());*/

        //tag test
        Object baconTag = "bacon";
        Object eggTag = "egg";
        Object saladTag = "salad";
        Object cheeseTag = "cheese";
        Object tomatoTag = "tomato";
        Object pladeTag = "plade";
        ingredient_bacon.setTag(baconTag);
        ingredient_egg.setTag(eggTag);
        ingredient_salad.setTag(saladTag);
        ingredient_cheese.setTag(cheeseTag);
        ingredient_tomato.setTag(tomatoTag);
        ingredientChoice01.setTag(pladeTag);
        ingredientChoice02.setTag(pladeTag);
        ingredientChoice03.setTag(pladeTag);
        ingredientChoice04.setTag(pladeTag);

        ingredientsOnPlatesIds = new String[4];
        ingredientsOnPlatesIds[0] = ingredientChoice01.getTag().toString();
        ingredientsOnPlatesIds[1] = ingredientChoice02.getTag().toString();
        ingredientsOnPlatesIds[2] = ingredientChoice03.getTag().toString();
        ingredientsOnPlatesIds[3] = ingredientChoice04.getTag().toString();

        //crate last to ensure it gets all the same settings as a normal plate
        plateTemplate  =  ingredientChoice01.getDrawable();

        //test/debug
        button = (Button) findViewById(R.id.button);
        infobox = (TextView) findViewById(R.id.info);
    }

    //region GETTERS
    public static ImageView getIngredientChoice01()
    {
        return ingredientChoice01;
    }
    public static ImageView getIngredientChoice02()
    {
        return ingredientChoice02;
    }
    public static ImageView getIngredientChoice03()
    {
        return ingredientChoice03;
    }
    public static ImageView getIngredientChoice04()
    {
        return ingredientChoice04;
    }

    public static ImageView getIngredient_bacon()
    {
        return ingredient_bacon;
    }
    public static ImageView getIngredient_egg()
    {
        return ingredient_egg;
    }
    public static ImageView getIngredient_salad()
    {
        return ingredient_salad;
    }
    public static ImageView getIngredient_cheese()
    {
        return ingredient_cheese;
    }
    public static ImageView getIngredient_tomato()
    {
        return ingredient_tomato;
    }

    public static ImageView getRemoveIngredient()
    {
        return removeIngredient;
    }

    public static Drawable getPlateTemplate()
    {
        return plateTemplate;
    }

    public String[] getIngredientsOnPlatesIds ()
    {
        return ingredientsOnPlatesIds;
    }
    public static void setIngredientsOnPlatesIds (int index, String newTag)
    {
        if (index > ingredientsOnPlatesIds.length -1)
        {
            return;
        }
        else
        {
            ingredientsOnPlatesIds[index] = newTag;
        }
    }
    //endregion

    public void onClick(View view)
    {
        infobox.setText("");
        infobox.append("BaconTag: " + ingredient_bacon.getTag());
        infobox.append(" | ");
        infobox.append("PlateTag: " + ingredientChoice01.getTag());
    }

}
