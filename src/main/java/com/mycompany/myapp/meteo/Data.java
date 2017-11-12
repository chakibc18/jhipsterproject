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
public class Data {
    ArrayList<Station> stations;

    /**
     *
     * @param stations
     */
    public Data(ArrayList<Station> stations) {
        this.stations = stations;
    }

    /**
     *
     * @return
     */
    public ArrayList<Station> getStations() {
        return stations;
    }

    /**
     *
     * @param stations
     */
    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    /**
     *
     * @param s
     */
    public void addStation(Station s){
        this.stations.add(s);
    }

    /**
     *
     * @param s
     */
    public void removeStation(Station s){
        this.stations.remove(s);
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean exist(int n){
          for(Station s:this.stations){
             if(s.getNum_st()==n)
                 return true;
          }
          return false;
     }

    /**
     *
     */
    public void display(){
       for(Station s:this.stations){
            s.aff();
          }

     }
}
