package Classes;
package com.example.daniel.madpakkenproject.Classes;


import java.util.ArrayList;

public class MenuList extends ArrayList
{
    //private ArrayList<Menu> menuList = null;
    
    public MenuList (ArrayList<Menu> inputList)
    {
        //this.menuList = inputList;
        for ( Menu m: inputList)
        {
            add(m);
        }
    }
    
    public void setMenuList(ArrayList<Menu> list)
    {
        //this.menuList = list;
    }
    
    public ArrayList<Menu> getMenuList()
    {
        return this;
    }
}
