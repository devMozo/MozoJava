/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n3.nicolas.mozo.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mozo
 */
public class GameMySQL {
    // Attributes
    private Connection oConnect = null;
    private final String strUser = "root";
    private final String strPassword = "1234";
    private final String strTableName = "cardgame";
    /**
     * Class's constructor
     * @param strUser
     * @param strPassword
     * @param strTableName 
     */
    /*public GameMySQL(String strUser, String strPassword, String strTableName) {
    this.strUser = strUser;
    this.strPassword = strPassword;
    this.strTableName = strTableName;
    }   */
    /**
     * Get connection
     * @return Connection
     */
    public Connection getoConnect() {
        return oConnect;
    }
    /**
     * Connect to the DB
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void connect() throws ClassNotFoundException, SQLException {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // String connection
        String strConnection = new String("jdbc:mysql://localhost/" + this.strTableName + "?" + "user=" + this.strUser + "&password=" + this.strPassword);
        // Setup the connection with the DB
        this.oConnect = DriverManager.getConnection(strConnection);        
    }
    /**
     * Disconnect from the DB
     */
    public void disconnect(){       
        // Try to..
        try {
            // Close the current connection
            this.oConnect.close();
        // If something goes wrong..
        } catch (SQLException ex) {
            Logger.getLogger(GameMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
}
