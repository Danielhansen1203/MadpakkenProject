package com.example.daniel.madpakkenproject;

import java.io.Serializable;

/**
 * Created by Daniel on 28-11-2016.
 */

//Creating products
public class ModelProducts implements Serializable {
    private String productName;
    private String productDesc;
    private int productPrice;
    public ModelProducts(String productName,String productDesc,int productPrice){
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }



    public String getProductName(){
        return productName;
    }

    public String getProductDesc(){
        return productDesc;
    }

    public int getProductPrice(){
        return productPrice;
    }
}
