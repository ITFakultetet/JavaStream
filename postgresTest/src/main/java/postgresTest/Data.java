package postgresTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Data {

	private Connection conn;

	public Data() {
		String url = "jdbc:postgresql://s1.itfakultetet.no/brreg";
		Properties props = new Properties();
		props.setProperty("user", "kurs");
		props.setProperty("password", "kurs123");
//		props.setProperty("ssl","false");

		try {
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			System.out.println("Forbindelse ikke akseptert fordi " + e.getMessage());
			e.printStackTrace();
		}

//		String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
//		Connection conn = DriverManager.getConnection(url);

	} // end constructor

	public void getData(String navn) {

		Statement st;
		System.out.println("Orgnummer\tNavn");
		System.out.println("-----------------------------------------");

		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT orgnr, navn FROM enheter WHERE navn ilike '" + navn + "%'");
			while (rs.next()) {
				System.out.println(rs.getString("orgnr") + "\t" + rs.getString("navn"));
			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
