/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.util.Observable;
import java.util.Stack;

/**
 *
 * @author Mozo
 */
public class GameTable extends Observable{
    // Attributes
    private Stack<Card> stkCardsOnTheTable = new Stack();
    /**
     * Peek a card from the top of the table's deck
     * @return Copy of the current top card
     */
    public synchronized Card peekStkCards() {
        // By default the card's value is null
        Card oResponse = null;
        // If the stack is not empty
        if(!this.stkCardsOnTheTable.empty()){
            // Return the current card and remove from the stack
            oResponse = this.stkCardsOnTheTable.peek();
        }
        // Return the current card's value
        return oResponse;
    }
    /**
     * Pop a card from the top of the table's deck
     * @return The card of the top of the stack
     */
    public synchronized Card popStkCards(){
        // By default the card's value is null
        Card oResponse = null;
        // If the stack is not empty
        if(!this.stkCardsOnTheTable.empty()){
            // Return the current card and remove from the stack
            oResponse = this.stkCardsOnTheTable.pop();
        }
        // Return the current card's value
        return oResponse;
    }
    /**
     * Push a card to the top of the table's deck
     * @param oCurrentCard 
     */
    public synchronized void pushStkCards(Card oCurrentCard) {
        // Set a new card
        this.stkCardsOnTheTable.push(oCurrentCard);
    } 
    /**
     * Get all cards
     * @return Stack of cards
     */
    public Stack getStkCards(){
        return this.stkCardsOnTheTable;
    }
    /**
     * Clear the table
     */
    public void clearStkCards(){
        this.stkCardsOnTheTable.clear();
    }
    /**
     * Override the method to be accessed by the objects
     */
    @Override
    protected synchronized void setChanged() {
        super.setChanged(); //To change body of generated methods, choose Tools | Templates.
    }   
}
