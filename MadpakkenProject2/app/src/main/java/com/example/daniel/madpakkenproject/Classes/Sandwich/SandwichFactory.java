package com.example.daniel.madpakkenproject.Classes.Sandwich;

public class SandwichFactory
{
    private static SandwichFactory instance = null;

    private SandwichFactory()
    {

    }

    public static synchronized SandwichFactory getInstance()
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

        Sandwich s = new Sandwich(name, breadType, ingredient01, ingredient02, ingredient03, ingredient04, price);

        s.setName(name);
        s.setBreadType(breadType);
        s.setIngredient01(ingredient01);
        s.setIngredient02(ingredient02);
        s.setIngredient03(ingredient03);
        s.setIngredient04(ingredient04);
        s.setPrice(price);

        return s;
    }
}
