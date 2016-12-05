/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.daniel.madpakkenproject.Classes;

/**
 *
 * @author Daniel
 */
public class Menu 
{
    private String name;
    private int price;
    private String desc;
    
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }
    public String getDesc()
    {
        return desc;
    }
    public void setName(String n)
    {
        name = n;
    }
        public void setPrice(int value)
    {
        price = value;
    }
    public void setDesc(String d)
    {
        desc = d;
    }
}
