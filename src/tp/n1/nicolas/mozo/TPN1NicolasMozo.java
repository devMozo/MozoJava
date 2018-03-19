/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n1.nicolas.mozo;

import java.util.ArrayList;
import java.util.Arrays;
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
    private static ArrayList<String> arrStringAvailableBeers = new ArrayList<String>(Arrays.asList("Pilsner","Weizenbier","Altbier","Kölsch","Bockbier"));
    private static final int CANTCONSUMERS = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // New Container
        TPN1NicolasMozo.tBeerHouse = new BeerHouse();
        // New Thread with an assigned Producter
        TPN1NicolasMozo.tProducterThread = new Thread(new BeerProducter(TPN1NicolasMozo.tBeerHouse, 1, TPN1NicolasMozo.arrStringAvailableBeers));
        // New Thread with an assigned Consumer
        TPN1NicolasMozo.arrtConsumerThread = new Thread[TPN1NicolasMozo.CANTCONSUMERS];        
        // Start the execution of the producter
        TPN1NicolasMozo.tProducterThread.start();
        // Loop over all consumers
        for(int i = 0; i < TPN1NicolasMozo.CANTCONSUMERS; i++){
            // Create a new thread with a consumer
            TPN1NicolasMozo.arrtConsumerThread[i] = new Thread(new BeerConsumer(TPN1NicolasMozo.tBeerHouse, i));
            // Start execution of the consumer
            TPN1NicolasMozo.arrtConsumerThread[i].start();
        }
    }   
}
