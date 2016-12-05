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
public class User {
    
    private String fName;
    private String lName;
    private String email;
    private String pWord;
    
    public String getfName()
    {
        return fName;
    }
    public String getlName()
    {
        return lName;
    }
    public String getEmail()
    {
        return email;
    }
    public String getpWord()
    {
        return pWord;
    }
    
    public void setfName(String f)
    {
        fName = f;
    }
    public void setlName(String l)
    {
        lName = l;
    }
    public void setEmail(String e)
    {
        email = e;
    }
    public void setpWord(String p)
    {
        pWord = p;
    }
}
