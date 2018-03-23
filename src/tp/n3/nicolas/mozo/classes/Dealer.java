/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * @throws java.lang.Exception 
     */
    public Dealer(String strName) throws Exception {
        // Call to the parent class
        super(strName);
        // Initialize the cards' deck
        this.stkCards = new CardsDeck();
    }
    /**
     * Class's Overload Constructor
     * @param strName
     * @param stkCards 
     */
    public Dealer(String strName, CardsDeck stkCards){
        // Call to the parent class
        super(strName);
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
        int iCounterMixing = 0;
        // If the game has not finished
        while(!this.bHasFinished){
            // Get the current table
            oCurrentGameTable = this.getoGameTable();
            // Get a new card from the deck
            oCardToPut = this.stkCards.getCard();
            // Animation
            System.out.println("\nThe dealer puts: " + oCardToPut.toString() + "\n");
            // Put the card on the table
            oCurrentGameTable.pushStkCards(oCardToPut);
            // Sleep for a second to give to the players a time to process the card
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Dealer.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Get status of the players
            GameEvents evtCheckStatus = new GameEvents("CHECKSTATUSPLAYER", null);
            // A changes has been produced
            oCurrentGameTable.setChanged();
            // Emit an event
            oCurrentGameTable.notifyObservers(evtCheckStatus);
            // If the dealear has not more cards
            if(this.stkCards.getNumCards() == 0){
                // If we come to the maximum mixings per game
                if(iCounterMixing == MozoCardGame.MAXIMUN_MIXING_PER_GAME){                    
                    // Finish the while loop
                    this.bHasFinished = true;                            
                    // A changes has been produced
                    oCurrentGameTable.setChanged();
                    // Emit an event
                    oCurrentGameTable.notifyObservers(this);
                    // Show a message saying that was a tie
                    System.out.println("\n No winners, it's a tie!!!\n");
                } else {
                    // Show a message that the deck is mixing..
                    System.out.println("\nMIXING...\n");
                    // Get all cards from the table
                    Stack<Card> oTableCards = oCurrentGameTable.getStkCards();
                    // Set all table's cards to the dealer
                    this.stkCards.setNewDeck(oTableCards);
                    // Clear the table
                    oCurrentGameTable.clearStkCards();
                    // Plus one counter mixing
                    iCounterMixing++;
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
                case "CHECKSTATUSPLAYERRESPONSE":
                    // Get the player
                    Player oPlayer = (Player) ((GameEvents) arg).getoObject();
                    // Print the size of the player's stack
                    System.out.println("The player " + oPlayer.getStrName() + " has " + oPlayer.getStkMyHand().size() + " card/s " + oPlayer.getStkMyHand().toString() );
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
        // If is a direct message from the Player
        if(arg instanceof Player){
            this.bHasFinished = true;            
        }  
    }
    /**
     * Override the method to save inside the DB
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Override
    public void save() throws ClassNotFoundException, SQLException {
        // Call the parent class
        super.save(); 
        // New Game's MySQl
        GameMySQL oGameMySQL = new GameMySQL();
        // Connect to the DB
        oGameMySQL.connect();
        // Get the connction's object
        Connection oConnection = oGameMySQL.getoConnect();
        // Query to save the dealer        
        String strQuery = "INSERT INTO dealers(id_people) VALUES(" + this.getId() + ")";
        // Prepare the query and say that it'll need to save the inserted id
        PreparedStatement oPreparedStatement = oConnection.prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);
        // Execute query           
        oPreparedStatement.executeUpdate();
        // Get the gerated keys
        ResultSet oResultSet = oPreparedStatement.getGeneratedKeys();
        // If there's something
        if(oResultSet.next()){
            // Set the id
            this.setId(oResultSet.getInt(1));
        } 
    } 
}
