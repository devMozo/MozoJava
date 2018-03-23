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
public class Player extends Person{    
    // Attributes
    private Stack<Card> stkMyHand;
    private String strState = "";
    /**
     * Class's Constructor
     * @param strName
     * @param id 
     */
    public Player(String strName, int id) {
        // Call to the parent class
        super(strName, id);
        // Set the hand
        this.stkMyHand = new Stack();
    }
    /**
     * Class's Overloaded Constructor
     * @param strName
     * @param id 
     * @param stkHand 
     */
    public Player(String strName, int id, Stack<Card> stkHand) {
        // Call to the parent class
        super(strName, id);
        // Set the hand
        this.stkMyHand = stkHand;
    }
    /**
     * Get the cards that has in the hand
     * @return 
     */
    public Stack<Card> getStkMyHand() {
        return stkMyHand;
    }   
    /**
     * Add a card to the Player's Hand
     * @param oCard 
     */
    public void addCard(Card oCard){
        // Add the card
        this.stkMyHand.add(oCard);
    }
    /**
     * Check if the passed card has in my array
     * @param oCard
     * @return 
     */
    public boolean hasTheCardInMyHand(Card oCard){
        // By default the response is false
        boolean bResponse = false;
        // Loop over all array
        for (int i = 0; i < this.stkMyHand.size(); i++) {
            // If has the same value
            if(this.stkMyHand.get(i).getValue() == oCard.getValue()){
                // The response become true
                bResponse = true;
            }            
        }        
        // Return the response
        return bResponse;
    }
    /**
     * Check the position of the card in my hand
     * @param oCard
     * @return 
     */
    public int getPositionOfTheCard(Card oCard){
        // By default the response is false
        int iResponse = -1;
        // Loop over all array
        for (int i = 0; i < this.stkMyHand.size(); i++) {
            // If has the same value
            if(this.stkMyHand.get(i).getValue() == oCard.getValue()){
                // The response become true
                iResponse = i;
            }            
        }        
        // Return the response
        return iResponse;
    }
    /**
     * Oveeride the run() method
     */
    @Override
    public void run() {
        // To not create a lot of variables in memory inside the while loop
        // I create and initialize whit null this objects
        GameTable oCurrentGameTable = null;
        Card oCardToGet = null;        
        // If the game has not finished
        while(!this.bHasFinished){
            // Get the current table
            oCurrentGameTable = this.getoGameTable();
            // Syncronized block
            synchronized(this){
                // Get the current card
                oCardToGet = oCurrentGameTable.peekStkCards();
                // Do I have the card? Fast!! If you take much time another player
                // can steal it!!
                if(oCardToGet != null && this.hasTheCardInMyHand(oCardToGet)){
                    // I get the card again 
                    oCardToGet = oCurrentGameTable.popStkCards();                         
                    // If there's not a card on the table
                    if(oCardToGet != null){
                        // Get the position of the card
                        int iPositionCard = this.getPositionOfTheCard(oCardToGet);
                        // If is a valid integer
                        if(iPositionCard >= 0){
                            // Remove the getted card from my hand
                            this.stkMyHand.remove(iPositionCard);
                            // If we have no more cards inside the deck
                            if(this.stkMyHand.size() <= 0){
                                // Finish the while loop
                                this.bHasFinished = true;                            
                                // A changes has been produced
                                oCurrentGameTable.setChanged();
                                // Emit an event
                                oCurrentGameTable.notifyObservers(this);
                                // Show the winner
                                System.out.println("And the winner is... " + this.getStrName() + " and the finished result is: \n");
                            }
                        }
                    }
                } 
            }
        }     
    }     
    /**
     * On update is fired
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        // If the arg is an event
        if(arg instanceof GameEvents){
            // Get the current table
            GameTable oCurrentGameTable = this.getoGameTable();
            // Create the response
            GameEvents evtResponse = new GameEvents(((GameEvents) arg).getStrCode() + "RESPONSE", null);
            // Do we need to notify to someone?
            boolean bNotify = false;
            // What events did it send?
            switch(((GameEvents) arg).getStrCode()){
                case "CHECKSTATUSPLAYER":
                    // Send my hand :O
                    evtResponse.setoObject(this);
                    // Notify true
                    bNotify = true;
                break;
            }
            // If we need to notify
            if(bNotify){
                // A changes has been produced
                oCurrentGameTable.setChanged();
                // Emit an event
                oCurrentGameTable.notifyObservers(evtResponse);
            }
        }
        // IF is a direct message from the dealer
        if(arg instanceof Dealer){
            this.bHasFinished = true;   
        }      
    }
}
