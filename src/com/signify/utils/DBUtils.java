/**
 * 
 */
package com.signify.utils;

/**
 * @author BHAVISH
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
 
	private static Connection connection = null;
	
	public static Connection getConnection(){
		
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
            	//System.out.println("in stream ");
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
                
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
            	/*String driver = "com.mysql.jdbc.Driver"; 
            	String url =  "jdbc:mysql://localhost/crs-database";
            	String user = "root";
            	String password = "Password@1";*/
                //Class.forName(driver);
                //System.out.println("URL--> " +url + "user-->" +user + "password-->" +password);
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            
             catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }


}
