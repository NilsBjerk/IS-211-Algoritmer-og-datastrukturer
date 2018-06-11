/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory3;


import java.util.LinkedList;

/**
 *
 * @author nilsf
 */
public class Baat {
 // felt og constructor – oppgave 1
    private String baatNavn;
    private int seilnr;
    private int sluttresultat;
    private final LinkedList<Integer> plassering = new LinkedList<>();
 
    
    public Baat()  {
       
    }
    
    public Baat(String baatNavn, int seilnr){
    this.baatNavn = baatNavn;
    this.seilnr = seilnr;
    }
 // eventuelle hjelpemetoder for oppgave 2 og 3
    
   
     
     public String getBaatNavn() {
        return baatNavn;
    }

    public void setBaatNavn(String baatNavn) {
        this.baatNavn = baatNavn;
    }

    public int getSeilnr() {
        return seilnr;
    }

    public void setSeilnr(int seilid) {
        this.seilnr = seilnr;
    }
   
    
    public int getSluttresultat()
    {
        return sluttresultat;
    }
    
     public void setsluttresultat(int sluttresultat) {
        this.sluttresultat = sluttresultat;
    }
   
     public void setPoeng(int poeng){
        plassering.addLast(poeng);
    
    }
     public LinkedList getPoeng(){
        return plassering;
    }

    
}