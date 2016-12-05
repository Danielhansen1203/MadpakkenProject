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
public class OrderList {
    
    private ArrayList<Order> orderList = null;
    
    public OrderList (ArrayList<Order> inputList)
    {
        this.orderList = inputList;
    }
    
    public void setOrderList(ArrayList<Order> list)
    {
        this.orderList = list;
    }
    
    public ArrayList<Order> getChildList()
    {
        return this.orderList;
    }
    
}
