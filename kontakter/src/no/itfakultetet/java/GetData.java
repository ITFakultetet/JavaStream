package no.itfakultetet.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {
	
	public ResultSet getRows() {
        
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://s1.itfakultetet.no:5432/kurs", "kurs", "kurs123")) { 
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT concat(fornavn,' ',etternavn) as navn, epost, tel FROM public.kontakter");
            return resultSet;
        }catch (SQLException e) {
            System.out.println("Noe gikk galt med å hente data via SQL: ");
            e.printStackTrace();
        }
		return null;
    }
	
	
	
	
	
	
	
}
