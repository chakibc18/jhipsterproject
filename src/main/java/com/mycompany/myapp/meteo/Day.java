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
public class Day {
    private ArrayList<Unit> listj;
    private int j;

    /**
     *Constructor of the class
     * @param listJ list of units in a day
     * @param j day number
     */
    public Day(ArrayList<Unit> listJ, int j) {
        this.listj = listJ;
        this.j = j;
    }

    /**
     *method that calculate the average(Moyenne) temp of a day
     * @return the average
     */
    public double moytj(){
    double moy=0;

    for(Unit u:this.listj){
    moy=moy+u.getTemp();

    }
    moy=moy/this.listj.size();
    return moy;
    }

    /**
     *method that calculate the average(Moyenne) moisture of a day
     * @return the average
     */
    public int moyhj(){
    int moy=0;

    for(Unit u:this.listj){
    moy=moy+u.getHumidite();

    }
    moy=moy/this.listj.size();
    return moy;
    }

    /**
     *method that calculate the average(Moyenne) nebulosity of a day
     * @return the average
     */
    public double moynj(){
    double moy=0;

    for(Unit u:this.listj){
    moy=moy+u.getVitesseVent();

    }
    moy=moy/this.listj.size();
    return moy;
    }

    /**
     *Getter for the Units
     * @return the units
     */
    public ArrayList<Unit> getListj() {
        return listj;
    }

    /**
     *Getter for the number of the day
     * @return number of the day
     */
    public int getJ() {
        return j;
    }

    /**
     *Setter for the Units
     * @param listj
     */
    public void setListj(ArrayList<Unit> listj) {
        this.listj = listj;
    }

    /**
     *Setter for the number of the day
     * @param j
     */
    public void setJ(int j) {
        this.j = j;
    }

    /**
     *method for adding a unit to a day
     * @param u the new unit
     */
    public void addUnit(Unit u){
    this.listj.add(u);
    }

    /**
     *display method
     * @return
     */
    public String aff(){
        String s="";
        //System.out.println(this.getNum_st()+" :\n");

        for(Unit e: listj){
        s=s+e.aff()+"\n";
        }
        return s;
    }
}
