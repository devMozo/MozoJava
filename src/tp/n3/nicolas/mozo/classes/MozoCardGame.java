/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mozo
 */
public class MozoCardGame implements Runnable, Observer{
    // Attributes
    private int idGame;
    private Dealer oDealer;
    private ArrayList<Player> arrPlayers = new ArrayList();
    private GameTable oGameTable = new GameTable();
    private int MAXIMUN_CARD_PER_PLAYER = 5;
    private boolean bHasFinished = false;
    /**
     * Class's Contructor
     * @param oDealer 
     */
    public MozoCardGame(Dealer oDealer) {
        // Initialize game's dealer
        this.oDealer = oDealer;
        // Add the dealer to the observers' array
        this.oGameTable.addObserver(oDealer);
    }
    /**
     * Add a new player
     * @param oPlayer 
     */
    public void addPlayer(Player oPlayer){
        // Add the player
        this.arrPlayers.add(oPlayer);        
        // Add the player to the observers' array
        this.oGameTable.addObserver(oPlayer);
    }
    /**
     * Left the game begin..
     */
    private void startGame(){
        // Initialize dealer        
        // Give a game table to the user
        this.oDealer.setoGameTable(this.oGameTable);
        // Initialize its attention :O ¿AI?
        new Thread(this.oDealer).start();
        // Loop over all players
        for(int i = 0; i < this.arrPlayers.size(); i++){
            // Give a game table to the user
            this.arrPlayers.get(i).setoGameTable(this.oGameTable);
        } 
        // Distribute cards
        this.assignCardsPerPlayer();
        // I need to reloop all array to initialize threads
        for(int i = 0; i < this.arrPlayers.size(); i++){
            // Initialize its attention :O ¿AI?
            new Thread(this.arrPlayers.get(i)).start();
        }
    }
    /**
     * Distributes the cards from the deck that is inside the dealer
     */
    private void assignCardsPerPlayer(){
        // Loop until the counter come to the maximum card per player..
        for(int i = 0; i < this.MAXIMUN_CARD_PER_PLAYER; i++){
            // Loop over all players
            for(int j = 0; j < this.arrPlayers.size(); j++){                
                // Set a card
                this.arrPlayers.get(j).addCard(this.oDealer.getStkCards().getCard());
            } 
        }        
    }
    /**
     * Thread's Method
     */
    @Override
    public void run() {
        // Game begins..
        this.startGame();
        // If the party hasn't finished
        while(!this.bHasFinished){
            // Nothing..
        }    
        // Send the result to the DB
        System.out.println("Partida terminada..");
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
