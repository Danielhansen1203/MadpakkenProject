/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author mthy
 */
public class ProductList {
    
    private ArrayList<Product> productList = null;
    
    public ProductList (ArrayList<Product> inputList)
    {
        this.productList = inputList;
    }
    
    public void setProductList(ArrayList<Product> list)
    {
        this.productList = list;
    }
    
    public ArrayList<Product> getProductList()
    {
        return this.productList;
    }
    
}
