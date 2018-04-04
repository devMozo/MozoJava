/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mozo
 */
public class CarMechanic extends Mechanic{
    // Attributes
    private ArrayList<Car> arrCars = new ArrayList();
    /**
     * Update the Cars' Array
     * @param o 
     */
    @Override
    public void update(Object o) {
        // Check that the object is a car
        if(o instanceof Car){
            // Casting object to an appropiate execution
            Car tCar = (Car)o;
            // New HashMap with the result of the exist() operation
            HashMap hsmpResult = this.exist(tCar.getiID());
            // If the response of the method is true
            if((Boolean)hsmpResult.get("response")){
                // Before updated
                System.out.println("\n\nBEFORE:\n\n" + this.arrCars.get((int)hsmpResult.get("pos")).toString());
                // Update it
                this.modify(tCar, (int)hsmpResult.get("pos"));
                // After updated
                System.out.println("\n\nAFTER:\n\n" + this.arrCars.get((int)hsmpResult.get("pos")).toString());
            // If not..
            } else {
                // Add the car to the array
                this.add(tCar);
                System.out.println("New");
            }
        }
    }
    /**
     * Method to check if the car exists inside the Cars' Array
     * @param iID
     * @return 
     */
    private HashMap exist(int iID){
        // New HashMap's Object
        HashMap hsmpResponse = new HashMap();
        // Set its default value, that the id wasn't found
        hsmpResponse.put("response", false);
        // Initialize a counter
        int i = 0;
        // If the counter is less than the size of the array
        // and the response stored inside the HashMap is false yet
        while(i < this.arrCars.size() && (Boolean)hsmpResponse.get("response").equals(false)){
            // Check if the IDs are the same
            if(this.arrCars.get(i).getiID() == iID){
                // Update the response to break the while
                hsmpResponse.put("response", true);
                // Save the position
                hsmpResponse.put("pos", i);
            // If not..
            } else {
                // Increase the counter
                i++;
            }
        }   
        // Return the hashmap
        return hsmpResponse;
    }
    /**
     * Add a car only with the object
     * @param tCar 
     */
    private void add(Car tCar){
        // Push to the array
        this.arrCars.add(tCar);
    }
    /**
     * Modify a car with only the object
     * @param tCar 
     */
    private void modify(Car tCar){
        // New hashmap
        HashMap hsmpResponse = this.exist(tCar.getiID());
        // Check if exists
        if((Boolean)hsmpResponse.get("response")){
            // Call to the other modify() funcions to a correct performance
            this.modify(tCar, (int)hsmpResponse.get("pos"));
        // If not exists...
        } else {
            // Add new
            this.add(tCar);
        }
    }
    /**
     * Modify a car with the object and the position of the car that will be replaced
     * @param tCar
     * @param iPosition 
     */
    private void modify(Car tCar, int iPosition){
        this.arrCars.set(iPosition, tCar);
    }
}
