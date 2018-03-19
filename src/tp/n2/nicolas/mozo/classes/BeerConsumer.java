/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import tp.n2.nicolas.mozo.interfaces.IBeerObserver;

/**
 *
 * @author Mozo
 */
public class BeerConsumer implements Runnable{
    // Attributes
    private BeerHouse tBeerHouse;
    private int iConsumerID = 0;
    private final int WAITINGTIME = 400;
    /**
     * BeerConsumer's Constructor
     * @param ptBeerHouse
     * @param iConsumerID 
     */
    public BeerConsumer(BeerHouse ptBeerHouse, int iConsumerID) {
        this.tBeerHouse = ptBeerHouse;
        this.iConsumerID = iConsumerID;
    }
    /**
     * Override the run method that implements from the Runnable's Interface
     */
    @Override
    public void run() {
        // Unlimited time
        while(!this.tBeerHouse.isEmtpy()){
            // Try to make something in this round
            try {                
                // New observable
                BeerObservable tBeerObservable = new BeerObservable();
                // Get beer
                this.tBeerHouse.getBeer();
                // Notify to the observers
                tBeerObservable.notifyObservers();
                // Wait a second please..
                Thread.sleep(this.WAITINGTIME);
                // Nothing..
                //System.out.println("Una " + this.tBeerHouse.getBeer() + " para nuestro amigo con el ID: " + this.iConsumerID);
            } catch (InterruptedException ex) {
                Logger.getLogger(BeerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        // Send an elocuent message to the user
        // saying that there aren't more beers
        System.out.println("No hay mas birras papa...");
    }   
}
