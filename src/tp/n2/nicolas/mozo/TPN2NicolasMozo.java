/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo;

import java.util.ArrayList;
import java.util.Arrays;
import tp.n2.nicolas.mozo.classes.BeerConsumer;
import tp.n2.nicolas.mozo.classes.BeerHouse;
import tp.n2.nicolas.mozo.classes.BeerObservable;
import tp.n2.nicolas.mozo.classes.BeerOrder;
import tp.n2.nicolas.mozo.classes.BeerProducter;

/**
 *
 * @author Mozo
 */
public class TPN2NicolasMozo {
    // Class' Attributes
    private static BeerHouse tBeerHouse;
    private static Thread tProducterThread;
    private static Thread [] arrtConsumerThread;
    private static ArrayList<String> arrStringAvailableBeers = new ArrayList<String>(Arrays.asList("Pilsner","Weizenbier","Altbier","Kölsch","Bockbier"));
    private static final int CANTCONSUMERS = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // New observable
        BeerObservable tBeerObservable = new BeerObservable();
        // Attach observers
        tBeerObservable.attach(new BeerOrder());
        // New Container
        TPN2NicolasMozo.tBeerHouse = new BeerHouse();
        // New Thread with an assigned Producter
        TPN2NicolasMozo.tProducterThread = new Thread(new BeerProducter(TPN2NicolasMozo.tBeerHouse, 1, TPN2NicolasMozo.arrStringAvailableBeers));
        // New Thread with an assigned Consumer
        TPN2NicolasMozo.arrtConsumerThread = new Thread[TPN2NicolasMozo.CANTCONSUMERS];        
        // Start the execution of the producter
        TPN2NicolasMozo.tProducterThread.start();
        // Loop over all consumers
        for(int i = 0; i < TPN2NicolasMozo.CANTCONSUMERS; i++){
            // Create a new thread with a consumer
            TPN2NicolasMozo.arrtConsumerThread[i] = new Thread(new BeerConsumer(TPN2NicolasMozo.tBeerHouse, i));
            // Start execution of the consumer
            TPN2NicolasMozo.arrtConsumerThread[i].start();
        }
    }   
}