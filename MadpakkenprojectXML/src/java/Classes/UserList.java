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
public class UserList {
    
    private ArrayList<User> userList = null;
    
    public UserList (ArrayList<User> inputList)
    {
        this.userList = inputList;
    }
    
    public void setUserList(ArrayList<User> list)
    {
        this.userList = list;
    }
    
    public ArrayList<User> getUserList()
    {
        return this.userList;
    }
    
}
