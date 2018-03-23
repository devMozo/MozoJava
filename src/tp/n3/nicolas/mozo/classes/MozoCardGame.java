/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.util.ArrayList;

/**
 *
 * @author Mozo
 */
public class MozoCardGame{
    // Attributes
    private int idGame;
    private Dealer oDealer;
    private ArrayList<Player> arrPlayers = new ArrayList();
    private GameTable oGameTable = new GameTable();
    
    public static final int MAXIMUN_CARD_PER_PLAYER = 3;
    public static final int MAXIMUN_MIXING_PER_GAME = 2;
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
    public void startGame(){
        // Initialize dealer        
        // Give a game table to the user
        this.oDealer.setoGameTable(this.oGameTable);
        // Assign a thread to the dealer
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
        for(int i = 0; i < MozoCardGame.MAXIMUN_CARD_PER_PLAYER; i++){
            // Loop over all players
            for(int j = 0; j < this.arrPlayers.size(); j++){                
                // Set a card
                this.arrPlayers.get(j).addCard(this.oDealer.getStkCards().getCard());
            } 
        }        
    }
}
