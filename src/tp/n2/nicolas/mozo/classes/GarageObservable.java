/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.classes;

import java.util.ArrayList;
import java.util.Observer;
import tp.n2.nicolas.mozo.interfaces.IGarageObservable;
import tp.n2.nicolas.mozo.interfaces.IGarageObserver;

/**
 *
 * @author Mozo
 */
public class GarageObservable implements IGarageObservable{
    // Array that will contain all observers
    private static ArrayList<IGarageObserver> arrObservers = new ArrayList();
    /**
     * Attach a new observer to the static array
     * @param tObserver 
     */
    @Override
    public void attach(IGarageObserver tObserver) {
        // Add
        GarageObservable.arrObservers.add(tObserver);
    }
    /**
     * Deattach an observer from the static array
     * @param tObserver 
     */
    @Override
    public void deattach(IGarageObserver tObserver) {
        // Remove
        GarageObservable.arrObservers.remove(tObserver);
    }
    /**
     * Notify to all observers
     */
    @Override
    public void notifyObservers(Object o) {
        // Loop over all observers
        for(int i = 0; i < GarageObservable.arrObservers.size(); i++){
            // Access to the update method
            arrObservers.get(i).update(o);
        }        
    }    
}
