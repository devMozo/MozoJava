/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.classes;

import java.util.ArrayList;
import java.util.Observer;
import tp.n2.nicolas.mozo.interfaces.IBeerObservable;
import tp.n2.nicolas.mozo.interfaces.IBeerObserver;

/**
 *
 * @author Mozo
 */
public class BeerObservable implements IBeerObservable{
    // Array that will contain all observers
    private static ArrayList<IBeerObserver> arrObservers = new ArrayList();
    /**
     * Attach a new observer to the static array
     * @param tObserver 
     */
    @Override
    public void attach(IBeerObserver tObserver) {
        // Add
        BeerObservable.arrObservers.add(tObserver);
    }
    /**
     * Deattach an observer from the static array
     * @param tObserver 
     */
    @Override
    public void deattach(IBeerObserver tObserver) {
        // Remove
        BeerObservable.arrObservers.remove(tObserver);
    }
    /**
     * Notify to all observers
     */
    @Override
    public void notifyObservers() {
        // Loop over all observers
        for(int i = 0; i < BeerObservable.arrObservers.size(); i++){
            // Access to the update method
            arrObservers.get(i).update();
        }        
    }    
}
