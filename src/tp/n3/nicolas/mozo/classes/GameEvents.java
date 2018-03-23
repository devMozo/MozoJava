/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

/**
 *
 * @author Mozo
 * Thanks JavaScript
 * This is for all the people that hate or can't understand you.
 * In specially all POO's fans..
 */
public class GameEvents {
    // Attributes of the event
    private String strCode = "";
    private Object oObject = new Object();
    // Class's constructor
    public GameEvents(String iCode, Object oObject) {
        this.strCode = iCode;
        this.oObject = oObject;
    }
    // Getters
    public String getStrCode() {
        return strCode;
    }
    public Object getoObject() {
        return oObject;
    }
    // Setters   
    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }
    public void setoObject(Object oObject) {
        this.oObject = oObject;
    }    
}