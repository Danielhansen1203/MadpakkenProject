package com.example.daniel.madpakkenproject.Classes.Sandwich;

public class SandwichFactory
{
    private SandwichFactory instance = null;

    private SandwichFactory()
    {
        if (instance == null)
        {
            instance = new SandwichFactory();
        }
    }

    public Sandwich createSandwich(E_breadType breadType, String ingredient01, String ingredient02, String ingredient03, String ingredient04)
    {
        Sandwich s = new Sandwich();

        s.setBreadType(breadType);
        s.setIngredient01(ingredient01);
        s.setIngredient02(ingredient02);
        s.setIngredient03(ingredient03);
        s.setIngredient04(ingredient04);

        return s;
    }
}
