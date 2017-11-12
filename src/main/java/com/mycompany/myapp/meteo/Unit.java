/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.meteo;

/**
 *
 * @author Chak
 */
public class Unit {
    private String date;
    private double temp;
    private int humidite;
    private double vitesseVent;
    private double precipitation;



    /**
     *  @param date

     * @param temp temperature
     * @param humidite moisture
     * @param vitesseVent vv
     * @param precipitation
     */
    public Unit(String date, double temp, int humidite, double vitesseVent, double precipitation) {
        this.date = date;
        this.temp = temp;
        this.humidite = humidite;
        this.vitesseVent = vitesseVent;
        this.precipitation = precipitation;
    }

    /**
     *Setter for date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *Setter for temp
     * @param temp
     */
    public void setTemp(double temp) {

        this.temp = temp;
    }

    /**
     *Setter for humidite
     * @param humidite
     */
    public void setHumidite(int humidite) {
        this.humidite = humidite;
    }

    /**
     *Setter for vitesseVent
     * @param vitesseVent
     */
    public void setVitesseVent(double vitesseVent) {
        this.vitesseVent = vitesseVent;
    }

    /**
     *Getter for date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     *Getter for temp
     * @return temp
     */
    public double getTemp() {
        int i=(int) temp;
        return i;
    }

    /**
     *Getter for humidite
     * @return humidite
     */
    public int getHumidite() {
        return humidite;
    }

    /**
     *Getter for vitesseVent
     * @return vitesseVent
     */
    public double getVitesseVent() {
        return vitesseVent;
    }

    /**
     *This method converts from Kelvin to celsuis
     * @return temp in Celsius
     */
    public double getCelsius() {
        int s;
        double d= temp - 273.15;
        s=(int) d;

        return s;
    }
    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    /**
     *Display method
     *
     */
    public String aff(){
 // System.out.println(this.getDate()+" "+this.getTemp()+" "+this.getVitesseVent()+" "+this.getHumidite()+" ");
 return this.getDate()+" "+this.getTemp()+" "+this.getVitesseVent()+" "+this.getHumidite()+" ";
 }

}
