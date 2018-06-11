Graph (breadth first search)
public class KontaktNett {
   // Oppgave 1a - feltdeklarasjonerr
   HashMap<String, Node> nodes = new HashMap<>();
   public KontaktNett() {
       this.basj = new Bæsj();
   }
   /**
    * Registrer en samtale i grafen
    * @param fra - navnet på personen som ringte
    * @param til - navnet på personen han ringte til
    */
   public void registrerSamtale(String fra, String til) {
       boolean hasEdge = false;
       for (Edge edge : nodes[fra].edges) {
           if (edge.name.equals(til)) {
               hasEdge = true;);
               edge.weight++;
               break;
           }
       }
       if (!hasEdge) {
           Edge edge = new Edge(nodes[til], nodes[fra], 1);
           nodes[fra].edges.add(edge);
       }
   }
   /**
    * Returner en liste over personer som en mistenkt har hatt tett
    * kontakt med.
    * @param mistenkt - navnet på den mistenkte personen
    * @param ant - antall ganger to personer må ringt hverandre
    * for å ha hatt tett kontakt
    */
   public List<String> finnDirekteKontakter(String mistenkt, int ant) {
       List<String> direkteKontakter = new ArrayList<>();
       for (Edge edge : nodes[mistenkt].edges) {
           if (edge.vekt >= ant && edge.fra.vekt >= ant) {
               if (!direkteKontater.cotains(edge.til.name){
                   direkteKontakter.add(edge.til.name);
               }
           }  // Teknkeemoji
       }
       return direkteKontakter
   }
   /**
    * Returner en liste over personer som en mistenkt har hatt
    * direkte eller indirekte tett kontakt med.
    * @param mistenkt - navnet på den mistenkte personen
    * @param ant - antall ganger to personer må ringt hverandre
    * for å ha hatt tett kontakt
    */
   public List<String> finnAlleKontakter(String mistenkt, int ant) {

   }


   public class Node {
       String navn;
       List<Edge> edges;
       public Node(String navn) {
           this.navn = navn;
       }
   }
   public class Edge {
       Node fra;     // jeg vil dø wew lad
       Node til;
       int vekt;     // registrere antall calls

       public Edge(Node fra, node til, int vekt) {
           this.fra = fra;
           this.til = til;
           this.vekt = vekt;
       }
   }
}
