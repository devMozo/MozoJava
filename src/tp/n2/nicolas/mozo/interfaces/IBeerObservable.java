/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.interfaces;

/**
 *
 * @author Mozo
 * Observable's Pattern
 */
public interface IBeerObservable {
    /**
     * Method to attach a new observer
     * @param tObserver 
     */
    public void attach(IBeerObserver tObserver);    
    /**
     * Method to deattach an observer
     * @param tObserver 
     */
    public void deattach(IBeerObserver tObserver);
    /**
     * Notify to the observers...
     */
    public void notifyObservers();
}
