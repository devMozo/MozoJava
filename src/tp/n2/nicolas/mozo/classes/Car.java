/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.classes;

/**
 *
 * @author Mozo
 */
public class Car{
    // Attributes
    private int iID = 0;
    private int iNumDoors = 0;
    private int iOilLevel = 0;
    private int iWaterLevel = 0;
    private float fltWheelPresion = (float) 0.0;
    private String strCarName = "";
    private final GarageObservable tGarage;
    /**
     * Car's Constructor
     * @param tGarage
     */
    public Car(GarageObservable tGarage) {
        this.tGarage = tGarage;
    }   
    // Getters
    public int getiID() {
        return iID;
    }    
    public int getiNumDoors() {
        return iNumDoors;
    }
    public int getiOilLevel() {
        return iOilLevel;
    }
    public int getiWaterLevel() {
        return iWaterLevel;
    }
    public float getFltWheelPresion() {
        return fltWheelPresion;
    }
    public String getStrCarName() {
        return strCarName;
    }
    // Setters
    public void setiID(int iID) {
        this.iID = iID;
        // Trigger an event saying that the states has been modified
        this.tGarage.notifyObservers(this);
    }    
    public void setiNumDoors(int iNumDoors) {
        this.iNumDoors = iNumDoors;
        // Trigger an event saying that the states has been modified
        this.tGarage.notifyObservers(this);
    }
    public void setiOilLevel(int iOilLevel) {
        this.iOilLevel = iOilLevel;
        // Trigger an event saying that the states has been modified
        this.tGarage.notifyObservers(this);
    }
    public void setiWaterLevel(int iWaterLevel) {
        this.iWaterLevel = iWaterLevel;
        // Trigger an event saying that the states has been modified
        this.tGarage.notifyObservers(this);
    }
    public void setFltWheelPresion(float fltWheelPresion) {
        this.fltWheelPresion = fltWheelPresion;
        // Trigger an event saying that the states has been modified
        this.tGarage.notifyObservers(this);
    }
    public void setStrCarName(String strCarName) {
        this.strCarName = strCarName;
        // Trigger an event saying that the states has been modified
        this.tGarage.notifyObservers(this);
    } 
    /**
     * Override the toString() function to return the correct string
     * @return 
     */
    @Override
    public String toString() {
        // Custom string
        return "--------------- Car Changed ---------------" +
               "\nID: " + this.iID +
               "\nNumber of Doors: " + this.iNumDoors +
               "\nOil Level: " + this.iOilLevel +
               "\nWater Level: " + this.iWaterLevel +
               "\nPresion: " + this.fltWheelPresion +
               "\nCar Name: " + this.strCarName;
    }    
}
