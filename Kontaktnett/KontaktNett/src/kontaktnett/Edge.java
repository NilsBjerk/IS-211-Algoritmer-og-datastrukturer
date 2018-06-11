/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontaktnett;

/**
 *
 * @author nilsf
 */
public class Edge {
   Node fra;
   Node til;
    int samtaler;

    public Edge(Node fra, Node til, int samtaler) {
        this.fra = fra;
        this.til = til;
        this.samtaler = samtaler;
    }
    
    
     public Node getFra() {
        return fra;
    }

    public Node getTil() {
        return til;
    }

    public int getSamtaler() {
        return samtaler;
    }

    public void setSamtaler(int samtaler) {
        this.samtaler = samtaler;
    }
}

