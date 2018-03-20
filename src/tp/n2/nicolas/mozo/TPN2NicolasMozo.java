/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo;

import java.util.ArrayList;
import java.util.Arrays;
import tp.n2.nicolas.mozo.classes.Car;
import tp.n2.nicolas.mozo.classes.GarageObservable;
import tp.n2.nicolas.mozo.classes.Mechanic;

/**
 *
 * @author Mozo
 */
public class TPN2NicolasMozo {
    // Class' Attributes
    //private static BeerHouse tBeerHouse;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // New observable
        GarageObservable tBeerObservable = new GarageObservable();
        // Attach observers
        tBeerObservable.attach(new Mechanic());
        // New Car's Model
        Car tCar = new Car(tBeerObservable);
        // Set some data to the car
        tCar.setFltWheelPresion((float) 0.1234);
        tCar.setiNumDoors(123);
        tCar.setiOilLevel(12);
        tCar.setiWaterLevel(3);
        tCar.setStrCarName("Fiat Duna");
    }   
}