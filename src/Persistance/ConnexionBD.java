package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {

	final static String url = "jdbc:mysql://localhost:3306/ProjetUFR";
    final static String driverClassName="com.mysql.jdbc.Driver";
    final static String dbUser="root";
    final static String dbPwd="";
    
    private static ConnexionBD daoconnexion = null;

    public ConnexionBD(){

    }
    public static Connection getConnexion(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url,dbUser,dbPwd);
            System.out.println("connexion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static ConnexionBD getInstance() throws ClassNotFoundException, SQLException {

        if(daoconnexion == null)
            return new ConnexionBD();
        return daoconnexion;
    }

}
