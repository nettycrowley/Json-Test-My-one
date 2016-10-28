package com.rc.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class DbTest {
	
	private static final String DB_URL = "jdbc:mysql://localhost/rccourse";
	private static final String USER = "root";
	private static final String PASS = "root";

	public static void main(String[] args) {
		
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			//load the database driver into memory
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connection to Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM users";
			
			//execute the sql
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				
				System.out.println("" + id + ":" + firstName  + " " + lastName);
			}
			
			
			//close db when finished
			conn.close();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
