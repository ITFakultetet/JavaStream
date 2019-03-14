package no.itfakultetet.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {

	public ResultSet getRows() {

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://s1.itfakultetet.no:5432/terje",
				"kurs", "kurs123")) {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT concat(fornavn,' ',etternavn) as navn, epost,tel FROM public.kontakter");
			return resultSet;

		} catch (SQLException e) {
			System.out.println("Noe gikk galt; ");
			e.printStackTrace();
		}
		return null;
	}

}
