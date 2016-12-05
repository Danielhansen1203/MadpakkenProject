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
public class ChildList {
    
    private ArrayList<Child> childList = null;
    
    public ChildList (ArrayList<Child> inputList)
    {
        this.childList = inputList;
    }
    
    public void setChildList(ArrayList<Child> list)
    {
        this.childList = list;
    }
    
    public ArrayList<Child> getChildList()
    {
        return this.childList;
    }
    
}
