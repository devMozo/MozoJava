/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Mozo
 */
public class CardsDeck{
    // New cards' deck
    private Stack<Card> stkDeck;
    // New deck that will containt all discarded cards
    private Stack<Card> stkDiscardedCards;
    // Constructor of the class
    public CardsDeck() throws Exception {
        this.stkDeck = this.initialize();
        this.stkDiscardedCards = new Stack();
    }
    /**
     * Return the top card of the deck
     * @return Card
     */
    public Card getCard(){ 
        // Return the card
        return this.stkDeck.pop();
    }
    /**
     * Return the current size of the deck
     * @return 
     */
    public int getNumCards(){
        return this.stkDeck.size();
    }
    /**
     * Push a discarded card to the correct deck
     * @param oCard
     */
    public void discardCard(Card oCard){
        // Push to the top of the deck
        this.stkDiscardedCards.push(oCard);
    }
    /**
     * Inialize the main deck
     * @return 
     */
    private Stack initialize() throws Exception{
        // New auxiliary stack
        Stack stkAux = new Stack();
        // Loop over him and give the correct cards
        for (int i = 1; i <= 13; i++) {
            stkAux.push(new ClubCard(i));            
            stkAux.push(new DiamondCard(i));
            stkAux.push(new HeartCard(i));
            stkAux.push(new SpadeCard(i));
        }
        // Shuffle the cards
        return this.mixCards(stkAux);
    }
    /**
     * Shuffle a cards' deck
     * @param stkToMix
     * @return Shuffled Stack 
     */
    private Stack mixCards(Stack stkToMix){
        // Shuffle the deck
        Collections.shuffle(stkToMix);
        // And return it
        return stkToMix;
    }    
    /**
     * Override the Object's Method
     * @return 
     */
    @Override
    public String toString() {
        // New String
        String strResponse = new String();
        // Loop over all stack
        for(int i = 0; i < this.stkDeck.size(); i++){
            // I'm concatenating all generated string
            strResponse = strResponse.concat("\n").concat(this.stkDeck.get(i).toString());
        }
        // Return the resulted string
        return strResponse; 
    }   
}
