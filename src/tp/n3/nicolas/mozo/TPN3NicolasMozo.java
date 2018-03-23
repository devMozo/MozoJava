/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo;

import tp.n3.nicolas.mozo.classes.Dealer;
import tp.n3.nicolas.mozo.classes.MozoCardGame;
import tp.n3.nicolas.mozo.classes.Player;

/**
 *
 * @author Mozo - Card's Game
 */
public class TPN3NicolasMozo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        MozoCardGame game = new MozoCardGame(new Dealer("Leandro", 1));
        
        Player jorge = new Player("Jorge", 4);        
        Player ale = new Player("Alenjandra", 6);
        Player betty = new Player("Beatriz", 8);
        Player manu = new Player("Manuel", 12);

        game.addPlayer(jorge);        
        game.addPlayer(ale);
        game.addPlayer(betty);
        game.addPlayer(manu);
        
        game.startGame();
    }
    
}
