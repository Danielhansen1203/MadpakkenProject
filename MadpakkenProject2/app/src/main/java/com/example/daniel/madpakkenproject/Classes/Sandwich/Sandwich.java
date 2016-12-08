package com.example.daniel.madpakkenproject.Classes.Sandwich;

import com.example.daniel.madpakkenproject.ModelProducts;

import java.io.Serializable;

enum E_breadType
{
    rugbrod,
    toastedRugbod,
    franskbrod,
    toasedFranskbrod,
    bolle,
    toastedBolle,
}

public class Sandwich extends ModelProducts implements Serializable
{

    private int price = 5;
    protected String name = "Desing selv";
    private String breadType;
    private String ingredient01;
    private String ingredient02;
    private String ingredient03;
    private String ingredient04;

    public Sandwich(String name, String breadType, String ingre1, String ingre2, String ingre3, String ingre4, int price)
    {
        super(name,breadType+ingre1+ingre2+ingre3+ingre4,price);
        this.name = name;
        this.price = price;
        this.breadType = breadType;
        this.ingredient01 = ingre1;
        this.ingredient02 = ingre2;
        this.ingredient03 = ingre3;
        this.ingredient04 = ingre4;
    }

    public String getBreadType()
    {
        return breadType;
    }

    public void setBreadType(String breadType)
    {
        this.breadType = breadType;
    }

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

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
