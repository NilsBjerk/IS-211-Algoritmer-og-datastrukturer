

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontaktnett;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nilsf
 */
public class KontaktNett {
    private ArrayList<Node> noder;
    
    public KontaktNett(){
        noder = new ArrayList<>();
    }
    
    /**
     * Registrer en samtale i grafen
     * @param fra - navnet på personen som ringte
     * @param til - navnet på personen han ringte til
     */
    public void registrerSamtale(String fra, String til){
        for (Node n : noder){
            ArrayList<Edge> kanter = n.getKanter();
            for (Edge e : kanter){
                if (e.getFra().getNavn().equals(fra) & e.getTil().getNavn().equals(til)){
                    e.setSamtaler(e.getSamtaler() + 1);
                }
            }
       }
    }

    /**
     * Returner en liste over personer som en mistenkt har hatt tett
     * kontakt med.
     * @param mistenkt - navnet på den mistenkte personen
     * @param ant - antall ganger to personer må ringt hverandre
     * for å ha hatt tett kontakt
     */
     public List<Node> finnDirekteKontakter(String mistenkt, int ant) {
        // oppgave 2a
        List<Node> kontakter = new ArrayList<>();
        System.out.println("Direkte kontakt:");
        for (Node n : noder){
            if(n.getNavn().equals(mistenkt)){
                ArrayList<Edge> edges = n.getKanter();
                for (Edge e : edges){
                    if (e.getSamtaler() >= ant){
                        Node navn = e.getTil();
                        String direkteKontakt = e.getTil().getNavn();
                        kontakter.add(navn);
                        System.out.println(mistenkt + " har vært i kontakt med " + direkteKontakt + " " +e.getSamtaler() + " ganger.");   
                    }
                }
            }
        }
        return kontakter;
    }
  
    /**
     * Returner en liste over personer som en mistenkt har hatt
     * direkte eller indirekte tett kontakt med.
     * @param mistenkt - navnet på den mistenkte personen
     * @param ant - antall ganger to personer må ringt hverandre
     * for å ha hatt tett kontakt
     */
    public List<Node> finnAlleKontakter(String mistenkt, int ant) {
           List<Node> kontakter = new ArrayList<>();
           List<Node> indirekteKontakter = new ArrayList<>();
           System.out.println("\nAlle former for kontakt:");
           for (Node n : noder){
                if(n.getNavn().equals(mistenkt)){
                    ArrayList<Edge> edges = n.getKanter();
                    for (Edge e : edges){
                        if (e.getSamtaler() >= ant){
                            Node navn = e.getTil();
                            String direktekontakt = e.getTil().getNavn();
                            kontakter.add(navn);
                            System.out.println(mistenkt + " har vært i direkte kontakt med " + direktekontakt + " " + e.getSamtaler() + " ganger.");
                        }
                    }
                }
            }
            
            for (Node no : kontakter){
                ArrayList<Edge> edges = no.getKanter();
                for(Edge ed : edges){
 
                    if(ed.getSamtaler() >= ant){
                        Node navn = ed.getTil();
                        indirekteKontakter.add(navn);
                    }
                }
            }
            for(Node node : indirekteKontakter){
                String indirektenavn = node.getNavn();
                if(!indirektenavn.equals(mistenkt)){
                    System.out.println(mistenkt + " har vært i indirekte kontakt med " + indirektenavn);
                }
            }
                   
        return indirekteKontakter;
   }
    

   public void leggeTilData(){
       
        Node per = new Node("Per");
        Node pal = new Node ("Pål");
        Node narren = new Node ("Narren");
        Node kongen = new Node ("Kongen");
        Node prinsessa = new Node ("Prinsessa");
        Node espen = new Node ("Espen");
        
        //Per
        Edge per1 = new Edge(per, pal, 11);
        Edge per2 = new Edge(per, narren, 7);
        Edge per3 = new Edge(per, espen, 9);
        per.leggTilKant(per1);
        per.leggTilKant(per2);
        per.leggTilKant(per3);
        noder.add(per);
        
        //Pål
        Edge pal1 = new Edge (pal, per, 12);
        Edge pal2 = new Edge (pal, narren, 15);
        pal.leggTilKant(pal1);
        pal.leggTilKant(pal2);
        noder.add(pal);
        
        //Narren
        Edge narr1 = new Edge (narren, per, 6);
        Edge narr2 = new Edge (narren, pal, 17);
        Edge narr3 = new Edge (narren, kongen, 21);
        Edge narr4 = new Edge (narren, prinsessa, 19);
        narren.leggTilKant(narr1);
        narren.leggTilKant(narr2);
        narren.leggTilKant(narr3);
        narren.leggTilKant(narr4);
        noder.add(narren);
        
        //Kongen
        Edge kong1 = new Edge (kongen, prinsessa, 3);
        Edge kong2 = new Edge (kongen, narren, 0);
        kongen.leggTilKant(kong1);
        kongen.leggTilKant(kong2);
        noder.add(kongen);
        
        //Prinsessa
        Edge prin1 = new Edge (prinsessa, kongen, 14);
        Edge prin2 = new Edge (prinsessa, espen, 143);
        Edge prin3 = new Edge (prinsessa, narren, 0);
        prinsessa.leggTilKant(prin1);
        prinsessa.leggTilKant(prin2);
        prinsessa.leggTilKant(prin3);
        noder.add(prinsessa);
        
        //Espen
        Edge esp1 = new Edge (espen, prinsessa, 115);
        Edge esp2 = new Edge (espen, per, 0);
        espen.leggTilKant(esp1);
        espen.leggTilKant(esp2);
        noder.add(espen);
               
    }

}