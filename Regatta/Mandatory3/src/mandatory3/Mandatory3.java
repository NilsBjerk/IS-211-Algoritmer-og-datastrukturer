/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory3;

/**
 *
 * @author nilsf
 */
public class Mandatory3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Sett antall løp som skal gjennomføres 
        int antallLop = 5;
        Regatta regatta = new Regatta();
        
        /// Registrer ønsket antall båter, med navn og seilnr ///
        
        Baat baat1 = new Baat ("Victoria" ,001);
        Baat baat2 = new Baat("Speed-devil", 002);
        Baat baat3 = new Baat("Medusa", 003);
        Baat baat4 = new Baat("Pengesluk", 004);
        Baat baat5 = new Baat("Svigermors Drøm", 005);
        Baat baat6 = new Baat("Balder", 006);
        Baat baat7 = new Baat("Skarven", 007);
        
        regatta.leggTilBaat(baat1);
        regatta.leggTilBaat(baat2);
        regatta.leggTilBaat(baat3);
        regatta.leggTilBaat(baat4);
        regatta.leggTilBaat(baat5);
        regatta.leggTilBaat(baat6);
        regatta.leggTilBaat(baat7);
        /////////////////////////////////////////////////////////
        
        for (int i = 0; i < antallLop; i++) {
            regatta.nySeilas();
            regatta.registrerMaalgang();
            
        }
        regatta.sorterResultat();
        regatta.skrivResultatListe(antallLop);
    }
    }


    

