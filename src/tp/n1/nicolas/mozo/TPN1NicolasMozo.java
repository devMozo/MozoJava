/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n1.nicolas.mozo;

import tp.n1.nicolas.mozo.classes.BeerConsumer;
import tp.n1.nicolas.mozo.classes.BeerHouse;
import tp.n1.nicolas.mozo.classes.BeerProducter;

/**
 *
 * @author Mozo
 */
public class TPN1NicolasMozo {
    // Class' Attributes
    private static BeerHouse tBeerHouse;
    private static Thread tProducterThread;
    private static Thread [] arrtConsumerThread;
    private static final int CANTCONSUMERS = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // New Container
        tBeerHouse = new BeerHouse();
        // New Thread with an assigned Producter
        tProducterThread = new Thread(new BeerProducter(tBeerHouse, 1));
        // New Thread with an assigned Consumer
        arrtConsumerThread = new Thread[CANTCONSUMERS];
        // Loop over all consumers
        for(int i = 0; i < CANTCONSUMERS; i++){
            // Create a new thread with a consumer
            arrtConsumerThread[i] = new Thread(new BeerConsumer(tBeerHouse, i));
            // Start execution of the consumer
            arrtConsumerThread[i].start();
        }
        // Start the execution of the producter
        tProducterThread.start();
    }   
}
