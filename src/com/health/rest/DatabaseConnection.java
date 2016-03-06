package com.health.rest;
import java.sql.*;

public class DatabaseConnection {
	

	
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/heart";
	   //static final String DB_URL = "jdbc:mysql://127.6.130.2:3306/haleaandhearty";
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   //static final String USER = "adminr4LnXex";
	   //static final String PASS = "J_JYgrV9G2M2";
	   
	   Connection conn = null;
	   Statement stmt = null;
	   
	   
	   public Connection getConnection() 
	   {
		   try
		   {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   	} 
		   catch (ClassNotFoundException e) 
		   {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } 
		   catch (SQLException e) 
		   {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   	} 
		   
		   
		   
		   
		   return conn;
	   }
	   
	   
	   public Person getData(String name)
	   {
		   Person p = new Person();
		   	try {
				stmt = conn.createStatement();
				 String sql;
			      sql = "SELECT * FROM user WHERE name = '"+name+"'";
			      ResultSet rs = stmt.executeQuery(sql);
			     
				while(rs.next())
				{
					p.setAge(rs.getInt("age"));
					p.setName(rs.getString("name"));
					p.setEmail(rs.getString("email"));
					p.setCheastpain(rs.getInt("chestpain"));
					p.setGender(rs.getInt("gender"));
					p.setOldpeak(rs.getFloat("oldpeak"));
					p.setRestingbloodpressure(rs.getInt("resting_blood_pressure"));
					p.setMaxHeartRate(rs.getInt("maxheartrate"));
				
					
					
				}
				
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    return p;
			   
		   
		   
	   }
	   
	   
}

