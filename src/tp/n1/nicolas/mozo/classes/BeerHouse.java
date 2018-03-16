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
public class BeerHouse {
    // Specify the counter of beers that are inside the container
    private int iBeers = 100;    
    /**
     * This method allows me to add a new/plus one element to the container
     * @throws InterruptedException 
     */
    public synchronized void putBeer() throws InterruptedException{
        // If the container is full
        while(this.iBeers > 100){
            // Sleep the thread
            wait();
        }
        // Plus one to the container's counter
        this.iBeers = this.iBeers + 1;
    }
    /**
     * Get the last beer inserted on the container
     * @return Beer's Counter
     */
    public synchronized int getBeer(){
        // Less one to the container
        this.iBeers = this.iBeers - 1;
        // Return this beers. 
        // Why I do plus one to the container? 
        // Because if I return the current beer's counter 
        // I would be passing the incorrect beer.
        return this.iBeers + 1;
    }    
}
