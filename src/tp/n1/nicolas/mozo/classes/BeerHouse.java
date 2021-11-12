/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n1.nicolas.mozo.classes;

import java.util.Stack;
/**
 *
 * @author Mozo
 */
public class BeerHouse {
    // Specify the counter of beers that are inside the container
    private Stack<String> stkStrBeers = new Stack<String>();    
    /**
     * This method allows me to add a new/plus one element to the container
     * @param strBeer
     * @throws InterruptedException 
     */
    public synchronized void putBeer(String strBeer) throws InterruptedException{
        // If the container is full
        while(this.stkStrBeers.size() > 100){
            // Sleep the thread
            wait();
        }
        // Push the beer to the Stack
        this.stkStrBeers.push(strBeer);
    }
    /**
     * Get the last beer inserted on the container
     * @return Last inserted Beer
     */
    public synchronized String getBeer(){
        // Return this beers the last inserted beer
        return this.stkStrBeers.pop();
    }    
    /**
     * Check if the stack of beer has been emptied
     * @return True|False
     */
    public Boolean isEmtpy(){
        // Check the status of the stack (Empty or not)
        return this.stkStrBeers.empty();
    }
}
