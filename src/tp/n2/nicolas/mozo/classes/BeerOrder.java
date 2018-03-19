/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.classes;

import tp.n2.nicolas.mozo.interfaces.IBeerObserver;

/**
 *
 * @author Yo
 */
public class BeerOrder implements IBeerObserver{
    /** 
     * Update the orders..
     */
    @Override
    public void update() {
        // Nothing..
        System.out.println("Se realizo el pedido de una birra.");
    }    
}
