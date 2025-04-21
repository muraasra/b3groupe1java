package tppoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class DbConnection {
	 String BDD = "tpjava2";
	    String url = "jdbc:mysql://localhost:3306/" + BDD;
	    String user = "root";
	    String passwd = "";
	    Connection con;
	    Statement st;
	    
	    
	    
		protected void connection(){

	        // L'essaie de connexion à votre base de donées
	        try {
	            //Class.forName("com.mysql.jdbc.Driver");
	           con= DriverManager.getConnection(url, user, passwd);
	           st=(Statement) con.createStatement();
	            System.out.println("Base de données connectée....");
	        } catch (Exception e){
	            e.printStackTrace();
	            System.out.println("Erreur de connxion à la base de données");
	            System.exit(0);
	            
	        }

					

}

}
