/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.util.Observable;

/**
 *
 * @author Mozo
 */
public class GameTable extends Observable{
    // Attributes
    private Card oCurrentCard;
    // Getter
    public synchronized Card getoCurrentCard() {
        // Return the current card
        return this.oCurrentCard;
    }
    // Setter
    public synchronized void setoCurrentCard(Card oCurrentCard) {
        // Set a new card
        this.oCurrentCard = oCurrentCard;
    } 
    /**
     * Emtpy card
     */
    public void emptyCard(){
        this.oCurrentCard = null;
    }
}
