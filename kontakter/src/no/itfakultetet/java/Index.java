package no.itfakultetet.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		out = response.getWriter();
		out.append("<html>");
		out.append("<head>\n<title>Mine Kontakter</title>\n</head>");
		out.append("<body>"); 
		out.append("<h1>Mine Kontakter</h1>");
		out.append("<p>Dette er mine kontakter som tabell</p>");

		GetData data = new GetData();
		ResultSet resultSet = data.getRows();
		out.append("<table style=\"background:black; color:white;padding:4px;margin:2px;\">");
		try {
			while (resultSet.next()) {
				out.append("<tr><td>" + resultSet.getString("navn") + "</td>");
				out.append("<td>" + resultSet.getString("epost") + "</td>");
				out.append("<td>" + resultSet.getString("tel") + "</td></tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.append("<table>");
		out.append("</body>");
		out.append("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
