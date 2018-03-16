/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n1.nicolas.mozo.classes;

/**
 *
 * @author Mozo
 */
public class BeerConsumer implements Runnable{
    // Attributes
    private BeerHouse tBeerHouse;
    private int iConsumerID = 0;
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
        while(this.tBeerHouse.getBeer() > 0){
            // Nothing..
            System.out.println("Una birrita para nuestro amigo con el ID: " + this.iConsumerID);
        } 
        // Send an elocuent message to the user
        // saying that there aren't more beers
        System.out.println("No hay mas birras papa...");
    }   
}
