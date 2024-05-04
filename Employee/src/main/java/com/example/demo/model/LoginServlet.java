package com.example.demo.model;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/LoginServlet")
	public class LoginServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        String dbURL = "jdbc:oracle:thin:@localhost:1522:orcl"; 
	        String dbUser = "JITHENDRA"; //  your Oracle username
	        String dbPassword = "JITHU"; // your Oracle password

	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        PrintWriter out = response.getWriter();

	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	            String sql = "SELECT * FROM T_LOGIN WHERE F_USERNAME=? AND F_PWD=?";
	            statement = connection.prepareStatement(sql);
	            statement.setString(1, username);
	            statement.setString(2, password);
	            resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                out.println("<h1>Login successful!</h1>");
	            } else {
	                out.println("<h1>Invalid username or password.</h1>");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            out.println("<h1>Database connection error.</h1>");
	        } finally {
	            try {
	                if (resultSet != null) resultSet.close();
	                if (statement != null) statement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
