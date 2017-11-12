/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.meteo;

import java.util.ArrayList;

/**
 *
 * @author Chak
 */
public class Year {
     ArrayList<Month> listY;
     private int year;

    /**
     *Constructor of the class
     * @param listY list of month in a year
     * @param year the number of the year
     */
    public Year(ArrayList<Month> listY, int year) {
        this.listY = listY;
        this.year = year;
    }

    /**
     *Getter for the list of months in a year
     * @return the months
     */
    public ArrayList<Month> getListY() {
        return listY;
    }

    /**
     *Getter for the number of the year
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     *verify if a certain month exists in a year
     * @param n the month
     * @return true if the month exists else false
     */
    public boolean exist(int n){
          for(Month s:this.listY){
             if(s.getMo()==n)
                 return true;
          }
          return false;
     }

    /**
     *Setter for the list of months in a year
     * @param listY the list of months
     */
    public void setListY(ArrayList<Month> listY) {
        this.listY = listY;
    }

    /**
     *Setter for the number of the year
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *method for adding a month to a year
     * @param m
     */
    public void addmonth(Month m){
         if(listY.size()<12)
         {
             this.listY.add(m);
         }
         else
          System.out.println("annee avec 13 mois!!!");

    }
}
