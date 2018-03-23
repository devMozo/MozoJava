/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.util.Comparator;

/**
 *
 * @author Mozo
 */
public class SortPlayer implements Comparator<Player>{
    
    // Used for sorting in ascending order of the size of the hand
    @Override
    public int compare(Player a, Player b){
        return a.getStkMyHand().size() - b.getStkMyHand().size();
    }
}
