package com.example.daniel.madpakkenproject.Classes.Sandwich;

import android.util.Log;

public class SandwichFactory
{
    private static SandwichFactory instance = null;

    private SandwichFactory()
    {

    }

    public static SandwichFactory getInstance()
    {
        if (instance == null)
        {
            instance = new SandwichFactory();
        }

        return instance;
    }

    public Sandwich createSandwich(String name, String breadType, String ingredient01, String ingredient02, String ingredient03, String ingredient04, int price)
            throws IllegalArgumentException
    {
        if (breadType == null || ingredient01 == null || ingredient02 == null || ingredient03 == null || ingredient04 == null )
        {
            throw new IllegalArgumentException();
        }

        Log.d("Sandwich facory","Create new sandwich");
        Sandwich s = new Sandwich(name, breadType, ingredient01, ingredient02, ingredient03, ingredient04, price);

        Log.d("Sandwich facory","breadtype");
        s.setName(name);
        s.setBreadType(breadType);
        Log.d("Sandwich facory","ing1");
        s.setIngredient01(ingredient01);
        Log.d("Sandwich facory","ing2");
        s.setIngredient02(ingredient02);
        Log.d("Sandwich facory","ing3");
        s.setIngredient03(ingredient03);
        Log.d("Sandwich facory","ing4");
        s.setIngredient04(ingredient04);
        s.setPrice(price);

        Log.d("Sandwich facory","return sandwich");
        return s;
    }
}
