package no.itfakultetet.java;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App2 {  

	public static void main(String[] args) {
 
		
		GetData2 data = new GetData2();
		ResultSet resultSet = data.getRows();
		System.out.println("<table>");
		try {
			while (resultSet.next()) {
				System.out.print("<tr><td>" + resultSet.getString("navn") + "</td>");
				System.out.print("<td>" + resultSet.getString("epost") + "</td></tr>");
				System.out.println("<td>" + resultSet.getString("tel") + "</td></tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("</table>");
	}

}
