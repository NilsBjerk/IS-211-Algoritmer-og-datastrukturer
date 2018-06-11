/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory3;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
 
 
/**
 *
 * @author nilsf
 */
public class Regatta {
    // felt og constructor - oppgave 1
    Baat bat = new Baat();
    List<Baat> liste = new ArrayList<>();
    Random rnd = new Random();
    Scanner scr = new Scanner(System.in);
    String registrering;
    int antallDeltakere = 7;
   
   
    public Regatta() {
             
    }
 
    public void nySeilas() {
        long seed = System.nanoTime();
        Collections.shuffle(liste, new Random(seed));
    }
   
    public void registrerMaalgang() {
        for (int i = 0; i < liste.size(); i++) {
            int plassering = i + 1;
            liste.get(i).setPoeng(plassering);
        }
    }
    
    
    public void skrivResultatListe(int runder) {
    // oppgave 3
    liste.sort(Comparator.comparing(Baat::getSluttresultat));
        System.out.println("Final score after " + runder + " stages regatta:");
        System.out.format("%15s%15s%25s%15s\n", "Name", "Sail ID", "Stage results:", "Total score:");
        for (Baat baat : liste) {
            System.out.format("%15s%15d%25s%15d\n", baat.getBaatNavn(), baat.getSeilnr(), baat.getPoeng(), baat.getSluttresultat());
        }
        System.out.println("");
    }
    
   
    public void leggTilBaat(Baat x){
    liste.add(x);
    }
 
   
    public void sorterResultat() {
        for (Baat baat : liste) {
            int sum = 0;
        for (int i = 0; i < baat.getPoeng().size(); i++) {
            sum = sum + baat.getPoeng().get(i).hashCode();
             baat.setsluttresultat(sum);
        }
        }
    }
       
    
}