/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.daniel.madpakkenproject.Classes;

/**
 *
 * @author mthy
 */
public class Product {
     private String name;
    private int price;
    private int stock;
    
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }
    public int getStock()
    {
        return stock;
    }
    public void setName(String n)
    {
        name = n;
    }
        public void setPrice(int value)
    {
        price = value;
    }
    public void setStock(int s)
    {
        stock = s;
    }
}
