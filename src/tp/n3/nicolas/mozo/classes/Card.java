/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

/**
 *
 * @author Yo
 */
public abstract class Card {
    // Value of the card. From: 1 to 13
    protected int value = 0;
    private final int CONSTANT_MAX_VALUE = 13;
    private final int CONSTANT_MIN_VALUE = 1;
    // Card's Constructor
    public Card(int value) throws Exception {
        // Set the value through the setter
        this.setValue(value);
    }    
    // Get the value of the card
    public int getValue() {
        return value;
    }
    // Set the value of the card
    public void setValue(int value) throws Exception {
        // If the value is in the correct range of numbers
        if(value >= this.CONSTANT_MIN_VALUE && value <= this.CONSTANT_MAX_VALUE){
            // Set the value
            this.value = value;
        // If not..
        } else {
            // Throw an exception
            throw new Exception("Setted an incorrect card's value");
        }       
    }   
    /**
     * Override Object's Method
     * @return 
     */
    @Override
    public String toString() {
        return this.value + " of " + getClass().getName(); 
    }   
}
