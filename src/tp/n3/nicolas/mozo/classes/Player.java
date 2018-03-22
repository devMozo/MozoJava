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
        System.out.println(oCard.toString());
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
        // Show to the audience wich card we have
        System.out.println(this.getStrName() + "'s Cards:" + this.stkMyHand.toString());
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
                oCardToGet = oCurrentGameTable.getoCurrentCard();
                // Do I have the card? Fast!! If you take much time another player
                // can steal it!!
                if(oCardToGet != null && this.hasTheCardInMyHand(oCardToGet)){
                    // I get the card again 
                    oCardToGet = oCurrentGameTable.getoCurrentCard();
                    // The card is only for you :D
                    oCurrentGameTable.emptyCard();                           
                    // If there's not a card on the table
                    if(oCardToGet != null){
                        // Animation
                        System.out.println("The player "+ this.getStrName() +" gets: " + oCardToGet.toString());
                        // Remove the getted card from my hand
                        this.stkMyHand.remove(this.getPositionOfTheCard(oCardToGet));
                        System.out.println("Now he has: " + this.stkMyHand.toString() + "\n");
                        // If we have no more cards inside the deck
                        if(this.stkMyHand.size() <= 0){
                            // Finish the while loop
                            this.bHasFinished = true;
                            // Emit an event
                            oCurrentGameTable.notifyObservers(this);
                        }
                    }
                } 
            }
        }      
    }     

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
