/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.meteo;


import java.io.File;
import java.io.BufferedReader;
import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;


/**
 *
 * @author Chak
 */
public class Meteo {

    /**
     * this method verify if the file exists, else it will get the file and decompress it
     * in the data directory
     * @param s date parameter
     * @return File downloaded or already existing
     */
    public  File getData(String s){
        String path=new File(".").getAbsolutePath();
        path=path.replace(".","");
        // path=path+"data\\";
        File f = new File(path+s+".csv");
        if (f.exists()) {
            String sf = f.toString();
            //System.out.println("String representation of path is : " + s);
        } else {
            getFile("https://donneespubliques.meteofrance.fr/donnees_libres/Txt/Synop/Archive/synop."+s+".csv.gz",s);
            // System.out.println(path+s+"csv.gz");
            decompressGzipFile(path+s+".csv.gz",s+".csv");
            System.out.println(supr(path+s+".csv.gz"));

            //j.setText("");
            // System.out.println("File cannot exists: ");
        }

        return f;
    }

    /**
     *This method integates the downloaded files into our model class "Data.java"
     * @param f the file on the disk
     * @return string
     */
    public  Data filtostr(File f)
    {   int x=1;
        double t;
        int u;
        String ss="";
        double n;
        double p;
        Data data=new Data(new ArrayList<Station>());

        try {FileInputStream fstream = new FileInputStream(f);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine="";
            String ligne;
            while ((ligne =br.readLine()) != null) {
                if(x<0){
                    String[] motsDeLaLigne = ligne.split(";");
                    if("mq".equals(motsDeLaLigne[7])){t=-273;}else{
                        t=Double.parseDouble(motsDeLaLigne[7]);}
                    if("mq".equals(motsDeLaLigne[9])){u=0;}else{
                        u=Integer.parseInt(motsDeLaLigne[9]);}
                    if("mq".equals(motsDeLaLigne[6])){n=0;}else{
                        n=Double.parseDouble(motsDeLaLigne[6]);}
                    if("mq".equals(motsDeLaLigne[38])){p=0;}else{
                        p=Double.parseDouble(motsDeLaLigne[38]);}

                    if(data.exist(Integer.parseInt(motsDeLaLigne[0]))){




                        Unit e=new Unit(motsDeLaLigne[1],t,u,n, p);


                        for(Station s:data.getStations()){

                            if(s.getNum_st()==Integer.parseInt(motsDeLaLigne[0])){
                                ss="";
                                for(int i =0;i<8;i++){
                                    ss=ss+motsDeLaLigne[1].substring(i, i+1);
                                }
                                if(s.exist(Integer.parseInt(ss)/10000))
                                {  for(Year ann:s.getL()){
                                    if(ann.getYear()==(Integer.parseInt(ss)/10000)){
                                        if(ann.exist((Integer.parseInt(ss)%10000)/100)){
                                            for(Month m:ann.getListY()){
                                                if(m.getMo()==((Integer.parseInt(ss)%10000)/100)){
                                                    if(m.exist(Integer.parseInt(ss)%100)){
                                                        for(Day j:m.getListM()){
                                                            if(j.getJ()==(Integer.parseInt(ss)%100)){
                                                                j.addUnit(e);

                                                            }

                                                        }

                                                    }else{ Day jr=new Day(new ArrayList<Unit>(),(Integer.parseInt(ss)%100));jr.addUnit(e); m.addDay(jr);  }

                                                }

                                            }

                                        }else{
                                            Month m=new Month(new ArrayList<Day>(),((Integer.parseInt(ss)%10000)/100));
                                            Day j=new Day(new ArrayList<Unit>(),(Integer.parseInt(ss)%100)); j.addUnit(e);
                                            m.addDay(j);ann.addmonth(m); }


                                    }
                                }

                                }
                                else{
                                    Year an=new Year(new ArrayList<Month>(),(Integer.parseInt(ss)/10000));
                                    Month m=new Month(new ArrayList<Day>(),((Integer.parseInt(ss)%10000)/100));
                                    Day j=new Day(new ArrayList<Unit>(),(Integer.parseInt(ss)%100));
                                    j.addUnit(e);
                                    m.addDay(j);
                                    an.addmonth(m);
                                    s.addYear(an);

                                }
                            }

                        }
                    }
                    else{

                        Unit e=new Unit(motsDeLaLigne[1],t,u,n, p);
                        ss="";
                        for(int i =0;i<8;i++){
                            ss=ss+motsDeLaLigne[1].substring(i, i+1);
                        }


                        Year an=new Year(new ArrayList<Month>(),(Integer.parseInt(ss)/10000));
                        Month m=new Month(new ArrayList<Day>(),(Integer.parseInt(ss)%10000)/100);
                        Day j=new Day(new ArrayList<Unit>(),(Integer.parseInt(ss)%100));


                        j.addUnit(e);
                        m.addDay(j);
                        an.addmonth(m);
                        Station s=new Station(Integer.parseInt(motsDeLaLigne[0]),new ArrayList<Year>());
                        s.addYear(an);
                        data.addStation(s);

                    }









                    //System.out.println("s= \n"+strLine+"\n");
                    strLine="";
                }else{x--;
                    strLine=""; }
            }

            in.close();
            return data;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return data;
        }

    }

    /**
     *This method download the compressed file and is called in the upper method Getdata
     * @param host the download link
     * @param name the selected date for the download of the data
     */
    public  void getFile(String host,String name)
    {
        InputStream input = null;
        FileOutputStream writeFile = null;

        try
        {
            URL url = new URL(host);
            URLConnection connection = url.openConnection();
            int fileLength = connection.getContentLength();
            input = connection.getInputStream();
            String fileName = name+".csv.gz";
            writeFile = new FileOutputStream(fileName);
            byte[] buffer = new byte[1024];
            int read;
            if (fileLength == -1)
            {
                System.out.println("Invalide URL or file.");
                //j.showMessageDialog(null,"Erreur Connexion Indisponible!!");
            }



            while ((read = input.read(buffer)) > 0)
                writeFile.write(buffer, 0, read);
            writeFile.flush();

        }
        catch (IOException e)
        {
            System.out.println("Error while trying to download the file.");
            e.printStackTrace();
            //j.showMessageDialog(null,"Erreur Connexion Indisponible!!");
        }
        finally
        {
            try
            {
                writeFile.close();
                input.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private  void decompressGzipFile(String gzipFile, String newFile) {
        try {
            FileInputStream fis = new FileInputStream(gzipFile);
            GZIPInputStream gis = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = gis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            //close resources
            fos.close();
            gis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *This method delete the file
     * @param lien path to the file for deleting
     */
    public  boolean supr(String lien){
        File MyFile = new File(lien);
        if(MyFile.delete())return true;
        return false;
    }


    public boolean verifySport(String sport, int level,Day day){

       // SKI, VOILE, PLAGE, SURF, WAKE, VELO, COURSEAPIED
       // determine si possible de faire un sport
        switch(sport){
            case "SKI" :
                switch (level){
                    case 0 :
                            for(Unit u : day.getListj())
                            {
                                if(u.getVitesseVent()>11) return false;
                            }
                        break;
                    case 1 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>38) return false;
                        }

                        break;
                    case 2 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>61) return false;
                        }
                        break;
                        default: break;


                }
                break;
            case "VOILE" :
                switch (level){
                    case 0 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>38 ||u.getVitesseVent()<12) return false;
                        }
                        break;
                    case 1 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>11||u.getVitesseVent()<0) return false;
                        }
                        break;
                    case 2 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>88) return false;
                        }
                        break;
                    default: break;


                }

                break;
            case "PLAGE" :
                for(Unit u : day.getListj())
                {
                    if(u.getVitesseVent()>40 ||u.getHumidite()>70||u.getTemp()<25||u.getTemp()>35||u.getPrecipitation()>1) return false;
                }

                break;
            case "SURF" :
                switch (level){
                    case 0 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>19 ||u.getVitesseVent()<0) return false;
                        }
                        break;
                    case 1 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>38||u.getVitesseVent()<20) return false;
                        }
                        break;
                    case 2 :
                        for(Unit u : day.getListj())
                        {
                            if(u.getVitesseVent()>74||u.getVitesseVent()<39) return false;
                        }
                        break;
                    default: break;


                }
                break;
            case "WAKE" :
                for(Unit u : day.getListj())
                {
                    if(u.getVitesseVent()>11||u.getPrecipitation()>1) return false;
                }
                break;
            case "VELO" :
                for(Unit u : day.getListj())
                {
                    if(u.getVitesseVent()>40||u.getPrecipitation()>1) return false;
                }
                break;
            case "COURSEAPIED" :
                for(Unit u : day.getListj())
                {
                    if(u.getVitesseVent()>40 || u.getPrecipitation()>1) return false;
                }
                break;

        }



        return false;
    }

}
