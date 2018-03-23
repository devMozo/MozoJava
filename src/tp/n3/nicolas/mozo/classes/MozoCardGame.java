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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mozo
 */
public class MozoCardGame implements Observer{
    // Attributes
    private int idGame;
    private Dealer oDealer;
    private ArrayList<Player> arrPlayers = new ArrayList();
    private GameTable oGameTable = new GameTable();
    // Static attributes
    public static final int MAXIMUN_CARD_PER_PLAYER = 3;
    public static final int MAXIMUN_MIXING_PER_GAME = 2;
    public static final int TOTAL_POINTS_OF_THE_GAME = 100;
    /**
     * Class's Contructor
     * @param oDealer 
     */
    public MozoCardGame(Dealer oDealer) {
        // Initialize game's dealer
        this.oDealer = oDealer;
        // Add the dealer to the observers' array
        this.oGameTable.addObserver(oDealer);
        this.oGameTable.addObserver(this);
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
    /**
     * On receive an event..
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        // IF is a direct message from the dealer
        if(arg instanceof Dealer || arg instanceof Player){
            this.setPoints();
            this.save();
        }  
    }
    /**
     * Save the game
     */
    private void save(){
        // New Game's MySQl
        GameMySQL oGameMySQL = new GameMySQL();
        try {
            // Connect to the DB
            oGameMySQL.connect();
            // Get the connction's object
            Connection oConnection = oGameMySQL.getoConnect();
            // Query to save the game with its dealer        
            String strQuery = "INSERT INTO games(id_dealer) VALUES('" + this.oDealer.getId() + "')";
            // Prepare the query and say that it'll need to save the inserted id
            PreparedStatement oPreparedStatement = oConnection.prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);
            // Execute query           
            oPreparedStatement.executeUpdate();
            // Get the gerated keys
            ResultSet oResultSet = oPreparedStatement.getGeneratedKeys();
            // If there's something
            if(oResultSet.next()){
                // Set the id
                this.idGame = oResultSet.getInt(1);
            }  
            // Initialize players' string
            String strPlayer = "(" + this.idGame + "," + this.arrPlayers.get(0).getId() + ", " + this.arrPlayers.get(0).getiPoints() + ")";
            // Prepare players' string
            for(int i = 1; i < this.arrPlayers.size(); i++){
                strPlayer += ",(" + this.idGame + "," + this.arrPlayers.get(i).getId() + ", " + this.arrPlayers.get(i).getiPoints() + ")";
            }
            // Now we are gonna the save all players that were in the game
            strQuery = "INSERT INTO games_players(id_game, id_player, points) VALUES " + strPlayer;
            // Prepare the query
            oPreparedStatement = oConnection.prepareStatement(strQuery);
            // Execute query           
            oPreparedStatement.executeUpdate();         
        // If something was wrong..
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MozoCardGame.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    /**
     * Set points to the players
     */
    private void setPoints() {
        // Sort the collection
        Collections.sort(this.arrPlayers, new SortPlayer());
        // Set the main point
        for (int i = 0; i < this.arrPlayers.size(); i++) {
            this.arrPlayers.get(i).setiPoints((MozoCardGame.TOTAL_POINTS_OF_THE_GAME/(i+1)));
        }
    }
}
