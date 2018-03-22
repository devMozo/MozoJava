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
    
    public void sendCard(){
        
    }
    /**
     * Oveeride the run() method
     */
    @Override
    public void run() {
        
        System.out.println(this.getStrName() + "'s Cards:" + this.stkMyHand.toString());
                        
        /*while(this.stkMyHand.size() > 0){
            
            
            
        }     */      
    }     

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
