/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author bonde
 */



public class ConnectionDAO
{
    private static final String SERVER_NAME = "10.176.111.31";
    private static final String DATABASE_NAME = "EASV-DB2";
    private static final String USER = "CS2018A_21";
    private static final String PASSWORD = "CS2018A_21";
    SQLServerDataSource ds;
    
    public ConnectionDAO()
    {
        ds = new SQLServerDataSource();
        ds.setServerName(SERVER_NAME);
        ds.setDatabaseName(DATABASE_NAME);
        ds.setUser(USER);
        ds.setPassword(PASSWORD);
    }
    
    public Connection getConnection() throws SQLServerException {
        Connection con = ds.getConnection();
        return con;
    }
}
