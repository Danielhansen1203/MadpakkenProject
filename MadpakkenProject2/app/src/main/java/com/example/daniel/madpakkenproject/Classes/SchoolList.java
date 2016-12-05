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
public class SchoolList {
    
    private ArrayList<School> schoolList = null;
    
    public SchoolList (ArrayList<School> inputList)
    {
        this.schoolList = inputList;
    }
    
    public void setSchoolList(ArrayList<School> list)
    {
        this.schoolList = list;
    }
    
    public ArrayList<School> getSchoolList()
    {
        return this.schoolList;
    }
    
}
