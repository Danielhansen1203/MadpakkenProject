package com.example.daniel.madpakkenproject.Classes.Sandwich;

enum E_breadType
{
    rugbrod,
    toastedRugbod,
    franskbrod,
    toasedFranskbrod,
    bolle,
    toastedBolle,
}

public class Sandwich
{


    private String ingredient01;
    private String ingredient02;
    private String ingredient03;
    private String ingredient04;

    //default
    public Sandwich()
    {
        this.breadType = E_breadType.rugbrod;
        this.ingredient01 = "salad";
        this.ingredient02 = "bacon";
        this.ingredient03 = "pepper";
        this.ingredient04 = "tomato";
    }

    public Sandwich(E_breadType breadType, String ingre1, String ingre2, String ingre3, String ingre4)
    {
        this.breadType = breadType;
        this.ingredient01 = ingre1;
        this.ingredient02 = ingre2;
        this.ingredient03 = ingre3;
        this.ingredient04 = ingre4;
    }

    public E_breadType getBreadType()
    {
        return breadType;
    }

    public void setBreadType(E_breadType breadType)
    {
        this.breadType = breadType;
    }

    private E_breadType breadType;

    public String getIngredient01()
    {
        return ingredient01;
    }

    public void setIngredient01(String ingredient01)
    {
        this.ingredient01 = ingredient01;
    }

    public String getIngredient02()
    {
        return ingredient02;
    }

    public void setIngredient02(String ingredient02)
    {
        this.ingredient02 = ingredient02;
    }

    public String getIngredient03()
    {
        return ingredient03;
    }

    public void setIngredient03(String ingredient03)
    {
        this.ingredient03 = ingredient03;
    }

    public String getIngredient04()
    {
        return ingredient04;
    }

    public void setIngredient04(String ingredient04)
    {
        this.ingredient04 = ingredient04;
    }

}
