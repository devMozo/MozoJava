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
import java.util.Observer;

/**
 *
 * @author Mozo
 */
public abstract class Person implements Runnable, Observer{
    // Attributes
    private String strName = "";
    private int iID = 0;
    private GameTable oGameTable;
    protected boolean bHasFinished = false;
    /**
     * Class's COnstructor
     * @param strName
     */
    public Person(String strName) {
        this.strName = strName;
    }
    // Getters
    public String getStrName() {
        return strName;
    }
    public int getId() {
        return iID;
    }
    public GameTable getoGameTable() {
        return oGameTable;
    }
    // Setters
    public void setStrName(String strName) {
        this.strName = strName;
    }
    public void setId(int id) {
        this.iID = id;
    }
    public void setoGameTable(GameTable oGameTable) {
        this.oGameTable = oGameTable;
    }    
    /**
     * Save the person on the DB 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.sql.SQLException 
     */
    public synchronized void save() throws ClassNotFoundException, SQLException{
        // New Game's MySQl
        GameMySQL oGameMySQL = new GameMySQL();
        // Connect to the DB
        oGameMySQL.connect();
        // Get the connction's object
        Connection oConnection = oGameMySQL.getoConnect();
        // Query to save the person        
        String strQuery = "INSERT INTO people(name) VALUES('" + this.strName + "')";
        // Prepare the query and say that it'll need to save the inserted id
        PreparedStatement oPreparedStatement = oConnection.prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);
        // Execute query           
        oPreparedStatement.executeUpdate();
        // Get the gerated keys
        ResultSet oResultSet = oPreparedStatement.getGeneratedKeys();
        // If there's something
        if(oResultSet.next()){
            // Set the id
            this.iID = oResultSet.getInt(1);
        }  
    }
}
