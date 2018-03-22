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
public class Dealer extends Person{
    // Attributes
    private CardsDeck stkCards;
    /**
     * Class's Constructor
     * @param strName
     * @param id 
     * @throws java.lang.Exception 
     */
    public Dealer(String strName, int id) throws Exception {
        // Call to the parent class
        super(strName, id);
        // Initialize the cards' deck
        this.stkCards = new CardsDeck();
    }
    /**
     * Class's Overload Constructor
     * @param strName
     * @param id
     * @param stkCards 
     */
    public Dealer(String strName, int id, CardsDeck stkCards){
        // Call to the parent class
        super(strName, id);
        // Initialize the cards' deck
        this.stkCards = stkCards;
    }
    /**
     * Get deck
     * @return Cards' Deck
     */
    public CardsDeck getStkCards() {     
        return stkCards;
    }
    /**
     * Oveeride the run() method
     */
    @Override
    public void run() {
        // To not create a lot of variables in memory inside the while loop
        // I create and initialize whit null this objects
        GameTable oCurrentGameTable = null;
        Card oCardToPut = null;        
        // If the game has not finished
        while(!this.bHasFinished){
            // Get the current table
            oCurrentGameTable = this.getoGameTable();
            // If there's not a card on the table
            if(oCurrentGameTable.getoCurrentCard() == null){
                // Get a new card from the deck
                oCardToPut = this.stkCards.getCard();
                // Animation
                System.out.println("The dealer puts: " + oCardToPut.toString() + "\n");
                // Put the card on the table
                oCurrentGameTable.setoCurrentCard(oCardToPut);
                // If we have no more cards inside the deck
                if(this.stkCards.getNumCards() <= 0){
                    // Finish the while loop
                    this.bHasFinished = true;
                    // Emit an event
                    oCurrentGameTable.notifyObservers(this);
                }
            }
        }       
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
