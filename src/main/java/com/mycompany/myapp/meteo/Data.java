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

     public Station findStation(int n){
        Station s;
        for (Station ss : stations){
            if(ss.getNum_st()==n) return ss;
        }

        return null;
     }

    public int getCodeStation (  String station_name) {
        String data="07005:ABBEVILLE,07015:LILLE_LESQUIN,07020:PTE_DE_LA_HAGUE,07027:CAEN_CARPIQUET,07037:ROUEN_BOOS,07072:REIMS_PRUNAY,07110:BREST_GUIPAVAS,07117:PLOUMANAC'H,07130:RENNES_ST_JACQUES,07139:ALENCON,07149:ORLY,07168:TROYES_BARBEREY,07181:NANCY_OCHEY,07190:STRASBOURG_ENTZHEIM,07207:BELLE_ILE_LE_TALUT,07222:NANTES_BOUGUENAIS,07240:TOURS,07255:BOURGES,0728:DIJON_LONGVIC,07299:BALE_MULHOUSE,07314:PTE_DE_CHASSIRON,07335:POITIERS_BIARD,07434:LIMOGES_BELLEGARDE,07460:CLERMONT_FD,07471:LE_PUY_LOUDES,07481:LYON_ST_EXUPERY,07510:BORDEAUX_MERIGNAC,07535:GOURDON,07558:MILLAU,07577:MONTELIMAR,07591:EMBRUN,07607:MONT_DE_MARSAN,07621:TARBES_OSSUN,07627:ST_GIRONS,07630:TOULOUSE_BLAGNAC,07643:MONTPELLIER,07650:MARIGNANE,07661:CAP_CEPET,07690:NICE,07747:PERPIGNAN,07761:AJACCIO,07790:BASTIA,61968:GLORIEUSES,61970:JUAN_DE_NOVA,61972:EUROPA,61976:TROMELIN,61980:GILLOT_AEROPORT,61996:NOUVELLE_AMSTERDAM,61997:CROZET,61998:KERGUELEN,67005:PAMANDZI,71805:ST_PIERRE,78890:LA_DESIRADE_METEO,78894:ST_BARTHELEMY_METEO,78897:LE_RAIZET_AERO,78922:TRINITE_CARAVEL,78925:LAMENTIN_AERO,81401:SAINT_LAURENT,81405:CAYENNE_MATOURY,81408:SAINT_GEORGES,81415:MARIPASOULA,89642:DUMONT_D'URVILLE";
        int pos = data.indexOf(station_name);
        if (pos <0) return -1;
        String resCode = data.substring(pos-6,pos-1);
        return Integer.parseInt( resCode );
    }
}
