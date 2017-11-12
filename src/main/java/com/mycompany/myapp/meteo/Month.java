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
public class Month {
    ArrayList<Day> listM;
   // ArrayList<Unit> moy;
    private int mo;

    /**
     *Constructor for this class
     * @param listM list of days in a month
     * @param mo number of the month
     */
    public Month(ArrayList<Day> listM, int mo) {
        this.listM = listM;
        this.mo = mo;
    }

    /**
     *Getter for the list of days in a month
     * @return
     */
    public ArrayList<Day> getListM() {
        return listM;
    }

    /**
     *Getter for the number of the month
     * @return
     */
    public int getMo() {
        return mo;
    }

    /**
     *Setter for the list of days in a month
     * @param listM
     */
    public void setListM(ArrayList<Day> listM) {
        this.listM = listM;
    }

    /**
     *Setter for number of the month
     * @param mo
     */
    public void setMo(int mo) {
        this.mo = mo;
    }

    /**
     *method for adding a day in a month
     * @param j a new day
     */
    public void addDay(Day j){
    this.listM.add(j);
    }

    /**
     *Verify if a certain day exists in a month
     * @param n the day to verify
     * @return true if the day exists else false
     */
    public boolean exist(int n){
          for(Day s:this.listM){
             if(s.getJ()==n)
                 return true;
          }
          return false;
     }

    /**
     *display method
     * @return
     */
    public String aff(){
        String s="";
        //System.out.println(this.getNum_st()+" :\n");

        for(Unit e:this.getMoy()){
        s=s+e.aff()+"\n";
        }
        return s;
    }

    /**
     *method for calculating the average(Moyenne) for the month based on the daily average
     * @return a list for average for each day
     */
    public ArrayList<Unit> getMoy() {

     ArrayList<Unit> mo=new  ArrayList<Unit>();

     if(this.listM !=null)
     {
     Unit u=new Unit("0",0,0,0, 0);

         for(Day j:this.listM){
            u=j.getListj().get(1);
            u.setVitesseVent(j.moynj());
            u.setTemp(j.moytj());
            u.setHumidite(j.moyhj());
            mo.add(u);
    }
                 return mo;
     }else
         return null;




}

    public Day findDay(int n){

        Day s;
        for (Day ss : listM){
            if(ss.getJ()==n) return ss;
        }

        return null;
    }

}
