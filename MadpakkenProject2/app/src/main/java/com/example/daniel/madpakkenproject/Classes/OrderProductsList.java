/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.daniel.madpakkenproject.Classes;

import java.util.ArrayList;

/**
 *
 * @author mthy
 */
public class OrderProductsList {
    
    private ArrayList<OrderProducts> orderProductsList = null;
    
    public OrderProductsList (ArrayList<OrderProducts> inputList)
    {
        this.orderProductsList = inputList;
    }
    
    public void setOrderProductsList(ArrayList<OrderProducts> list)
    {
        this.orderProductsList = list;
    }
    
    public ArrayList<OrderProducts> getOrderProductsList()
    {
        return this.orderProductsList;
    }
    
}
