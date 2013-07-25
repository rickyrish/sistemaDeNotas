/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ricardo
 */
public class conexiondb {
    private static String dbserver="localhost";
    private static String dbname="datosnotas";
    private static String dbuser="root";
    private static String dbpass="123456";

    /**
     * @return the dbserver
     */
    public static String getDbserver() {
        return dbserver;
    }

    /**
     * @return the dbname
     */
    public static String getDbname() {
        return dbname;
    }

    /**
     * @return the dbuser
     */
    public static String getDbuser() {
        return dbuser;
    }

    /**
     * @return the dbpass
     */
    public static String getDbpass() {
        return dbpass;
    }
    
    
}
