package com.rc.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDb {
	
	//  properties
	private static final String DB_URL = "jdbc:mysql://localhost/rccourse";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	protected Connection conn = null;
	
	//get & set methods
	
	//Constructor
	public UserDb(){
		
		//open connetion to the database
		
		
		//load the database driver into memory
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection to Database...");
			//
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Other Methods
		
		//get the user with the specified id
		public User getUser(int id){
			
			User user = null;
			
			try {
				Statement stmt = conn.createStatement();
				String sql;
				
				sql = "SELECT * FROM users WHERE id = " + id;
				//execute the sql
				ResultSet rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					Date dateOfBirth = rs.getDate("dateOfBirth");
					boolean registered = rs.getInt("registered") == 1;
									
					user = new User(id, firstName, lastName, registered, dateOfBirth.toString());
				}else {
					//record not found
					user = null;
				}
				//close db when finished
				rs.close();
			} catch (SQLException ex) {
				
			}
			return user;
		}
		
		public void create(User user) {
			try{
				String sql = "INSERT INTO users" +
						"(firstName, lastName, registered, dateOfBirth)" +
						"VALUES(?, ?, ?, ?)";
				
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setString(1, user.getFirstName());
				stmt.setString(2, user.getLastName());
				stmt.setBoolean(3, user.isRegistered());
				stmt.setString(4, user.getDateOfBirth());

				stmt.executeUpdate();
				
				ResultSet rs = stmt.getGeneratedKeys();
				
				if (rs.next()){
					user.setId(rs.getInt("GENERATED_KEY"));
					System.out.println(user);
				}
				rs.close();
				stmt.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
			
		}
		
		public void delete(int id){
			
			String sql = "DELETE FROM users WHERE id = ?";
			
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1,id);
				
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void update(User user) {
			
			String sql = "UPDATE users " +
						 "SET firstName = ?, " +
						 "lastName = ?, " +
						 "registered = ?, " +
						 "dateOfBirth = ? " +
						 "WHERE id = ? ";
			
			try{
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setString(1, user.getFirstName());
				stmt.setString(2, user.getLastName());
				stmt.setBoolean(3, user.isRegistered());
				stmt.setString(4, user.getDateOfBirth());
				
				stmt.setInt(5,  user.getId());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 	}
		
		public ArrayList<User> getAll() {
			//User[] users = new User[99];
			
			ArrayList<User> users = new ArrayList<>();
					
			try {
				Statement stmt = conn.createStatement();
				String sql;
				
				sql = "SELECT * FROM users";
				//execute the sql
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					Date dateOfBirth = rs.getDate("dateOfBirth");
					boolean registered = rs.getInt("registered") == 1;
								
					User user = new User(id, firstName, lastName, registered, dateOfBirth.toString());
					users.add(user);
				}
				//close db when finished
			rs.close();
			} catch (SQLException ex) {
				
			}
			return users;
		}
		
		public void close(){
			try{
				System.out.println("Closing Database");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	public static void main(String[] args) {
		
		UserDb userDb = new UserDb();
		
		User user = new User(-1, "Rory", "Breen", false, "1982-01-02");
		
		userDb.create(user);
		user = new User(6, "Chloe", "Costello", true, "2010-01-10");
		
		userDb.update(user);
		
		userDb.delete(11);
		
		//User user = userDb.getUser(3);
		
		//System.out.println(user);
		
		//ArrayList<User> userList = userDb.getAll();
		
		//for (User user : userList) {
		//	System.out.println(user);
		//}
		
		userDb.close();

	}

}
