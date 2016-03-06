package com.health.rest;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.view.Viewable;

@Path("/insertData") 
public class insertData {
	@POST
	@Path("/insertHeartStat")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertReg(String data, @Context HttpServletRequest request,
		      @Context HttpServletResponse response)throws Exception{
		System.out.println(data);
		//System.exit(0);
		
		
		
		
		Connection conn = null;
		
		
			try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/heart", "root", "");
				//conn = DriverManager.getConnection("jdbc:mysql://127.6.130.2:3306/haleaandhearty", "adminr4LnXex", "J_JYgrV9G2M2");
				if(!conn.isClosed()){
					System.out.println("Connection Successful");
					
				}else{
					System.out.println("Connection Error!!");
				}
				 
			      System.out.println("Connection to server sucessfully");
			      //check whether server is running or not
			     // System.out.println("Server is running: "+jedis.ping());
			}
				catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			 
			JSONObject jsonObject = (JSONObject) obj;
	 
			String name = (String) jsonObject.get("name");
			
			String email = (String) jsonObject.get("email");
			String age = (String) jsonObject.get("age");
			String phone = (String) jsonObject.get("contact");
			String chestpain = (String) jsonObject.get("chpain");
			String gender = (String) jsonObject.get("gender");
			
			String restingbp = (String) jsonObject.get("restingbp");
			
			String oldpeak = (String) jsonObject.get("oldpeak");
			
			System.out.println(name+','+gender+','+email+','+age+','+phone+','+chestpain+','+restingbp+','+oldpeak);
			
	 
			String query = "INSERT into user(name,email,age,contact,chestpain,gender,resting_blood_pressure,oldpeak) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, age);
			stmt.setString(4, phone);
			stmt.setString(5, chestpain);
			stmt.setString(6, gender);
			stmt.setString(7, restingbp);
			stmt.setString(8, oldpeak);
			
			int rowcount = stmt.executeUpdate();
			String result="";
		if(rowcount>0)
		{
			
			System.out.println("Heart data added successfully!");
			result="Heart data added successfully!";
		}
		
		return result;
}

	
	
	
	
	// function to hash a string 
public String getHash(String str) throws Exception{
		
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        String hex = sb.toString();
        System.out.println(hex);
        return hex; 
}
	}