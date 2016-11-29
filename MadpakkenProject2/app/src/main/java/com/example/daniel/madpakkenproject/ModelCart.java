package com.example.daniel.madpakkenproject;

import java.util.ArrayList;

/**
 * Created by Daniel on 28-11-2016.
 */

//This class puts products in our cart so we can see how many we got
public class ModelCart {
    private ArrayList<ModelProducts> cartItems = new ArrayList<ModelProducts>();
    public ModelProducts getProducts(int position){
        return cartItems.get(position);
    }
    public void setProducts(ModelProducts Products){
        cartItems.add(Products);
    }
    public void removeProducts(ModelProducts Products){cartItems.remove(Products);}
    public void removeAllProducts(ModelProducts Products){cartItems.removeAll(cartItems);}
    public int getCartsize(){


        return cartItems.size();
    }


    public boolean CheckProductInCart(ModelProducts aproduct){
        return cartItems.contains(aproduct);
    }
}