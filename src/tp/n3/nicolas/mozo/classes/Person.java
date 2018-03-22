/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.util.Observer;

/**
 *
 * @author Mozo
 */
public abstract class Person implements Runnable, Observer{
    // Attributes
    private String strName = "";
    private int id = 0;
    private GameTable oGameTable;
    protected boolean bHasFinished = false;
    /**
     * Class's COnstructor
     * @param strName
     * @param id
     */
    public Person(String strName, int id) {
        this.strName = strName;
        this.id = id;
    }
    // Getters
    public String getStrName() {
        return strName;
    }
    public int getId() {
        return id;
    }
    public GameTable getoGameTable() {
        return oGameTable;
    }
    // Setters
    public void setStrName(String strName) {
        this.strName = strName;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setoGameTable(GameTable oGameTable) {
        this.oGameTable = oGameTable;
    }    
}
