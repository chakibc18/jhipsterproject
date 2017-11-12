/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.meteo;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/**
 *
 * @author Chak
 */
public class Station {
    private int num_st;
    ArrayList<Year> l;

    /**
     *Constructor for this Station
     * @param num_st number of Station
     * @param l listj of Units in the Station
     */
    public Station(int num_st, ArrayList<Year> l) {
        this.num_st = num_st;
        this.l = l;
    }

    /**
     *Getter for number of Station
     * @return number of Station
     */
    public int getNum_st() {
        return num_st;
    }

    /**
     *Getter for The Unit in the Station
     * @return The Units
     */
    public ArrayList<Year> getL() {
        return l;
    }

    /**
     *Setter for for this Station
     * @param num_st number of Station
     */
    public void setNum_st(int num_st) {
        this.num_st = num_st;
    }

    /**
     *Setter for The Unit in the Station
     * @param l The Units
     */
    public void setL(ArrayList<Year> l) {
        this.l = l;
    }

    /**
     *For Adding a year to The Station
     * @param e year
     */
    public void addYear(Year e){
    this.l.add(e);
    }

    /**
     *For removing a year to The Station
     * @param e year
     */
    public void removeYear(Year e){
    this.l.remove(e);
    }

    /**
     *Verify if  a year exists in this Station
     * @param n year
     * @return true if it exists else false
     */
    public boolean exist(int n){
          for(Year s:this.l){
             if(s.getYear()==n)
                 return true;
          }
          return false;
     }

    /**
     *Display method
     * @return
     */
    public String aff(){
        String s;
        System.out.println(this.getNum_st()+" :\n");
        s=this.getNum_st()+" :\n";

        return s;
    }

    /**
     * method that calculate the devitation(Ecart-type) and average(Moyenne totale)
     * @param units listj of data
     * @return three average(Moyenne) of (temp,h,n) and their devitations in an double listj
     */
    public  double[] deviation(ArrayList<Unit> units){

        double  moyenneT =0,moyenneN =0,moyenneH =0;
        double esperanceN=0, esperanceT=0,esperanceH =0;
        double ecartypeH;
        double ecartypeN;
        double ecartypeT ;
        double varianceH =0,varianceT =0,varianceN =0;
        int i=0;
        double []data= new double[10];
        int j;
        //max  diff de tempenregitre en france=85.1
        for (Unit u:units) {
            moyenneN =moyenneN+ u.getVitesseVent();
            moyenneT =moyenneT+ u.getTemp();
            moyenneH =moyenneH+ u.getHumidite();
          //  System.out.println(moyenneT);


        }

        moyenneN = moyenneN/units.size();
        moyenneT = moyenneT/units.size();
        moyenneH = moyenneH/units.size();
        //System.out.println(moyenneT);
        data[0]=moyenneT;
        data[1]=moyenneH;
        data[2]=moyenneN;

        for(Unit u:units) {

            esperanceN =esperanceN + pow(u.getVitesseVent() -moyenneN,2);
            esperanceT =esperanceT + pow(u.getTemp() -moyenneT,2);
            esperanceH =esperanceH + pow(u.getHumidite() -moyenneH,2);
            //System.out.println(pow(u.getVitesseVent() -moyenneN,2));
            //ca marche
        }
        esperanceN=esperanceN/units.size();
        esperanceT=esperanceT/units.size();
        esperanceH=esperanceH/units.size();
        System.out.println("************** "+esperanceN);
        ecartypeT = sqrt(esperanceT);
        ecartypeH = sqrt(esperanceH);
        ecartypeN = sqrt(esperanceN);


        data[3]=ecartypeT;
        data[4]=ecartypeH;
        data[5]=ecartypeN;
        System.out.println("partie des ecart :");
        for( j=3;j<6;j++) {

            System.out.println("data de "+j+" = "+data[j]);


        }

        return data;

    }


}
