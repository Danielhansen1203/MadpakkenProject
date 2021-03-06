package com.example.daniel.madpakkenproject;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

/**
 * Created by Daniel on 28-11-2016.
 */

//Creating an array whit products
public class Controller extends Application {
    private ArrayList<ModelProducts> myproducts = new ArrayList<ModelProducts>();
    private ModelCart myCart = new ModelCart();
    public ModelProducts getProducts(int pPosition){
        return myproducts.get(pPosition);
    }
    public void  setProducts(ModelProducts products){
        myproducts.add(products);
    }

    public void  removeProducts(){
        myproducts.clear();
    }

    public ModelCart getCart(){
        return myCart;
    }
    public int  getProductArraylistsize(){
        return myproducts.size();
    }
}
