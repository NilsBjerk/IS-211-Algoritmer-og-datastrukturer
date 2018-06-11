/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontaktnett;

import java.util.ArrayList;
/**
 *
 * @author nilsf
 */
public class Node {
    ArrayList<Edge> kanter;
    String navn;
    
    //private ArrayList<Edge> kanter;

    public Node(String navn){
        this.kanter = new ArrayList<>();
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Edge> getKanter() {
        return kanter;
    }

    public void leggTilKant (Edge kant) {
        kanter.add(kant);
    }
}
