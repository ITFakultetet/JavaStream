package no.itfakultetet.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {
	
	public ResultSet getRows() {
        
		//DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/kontakter/postgres" );

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://s1.itfakultetet.no:5432/kurs", "kurs", "kurs123")) { 
            // System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
        	//Class.forName("org.postgresql.Driver"); 
 
            // System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            // System.out.println("Reading car records...");
            // System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
            ResultSet resultSet = statement.executeQuery("SELECT concat(fornavn,' ',etternavn) as navn, epost, tel FROM public.kontakter");
            return resultSet;
        }catch (SQLException e) {
            System.out.println("SQLen gikk galt.");
            e.printStackTrace();
        }
		return null;
    }
	
	
	
	
	
	
	
}
