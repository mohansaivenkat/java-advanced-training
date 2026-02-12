package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepsToConnectDatabase {
	
	
	public static void main(String[] args) {
		//load the driver class
		
		String url ="jdbc:postgresql://localhost:5432/postgres";
		String un = "postgres";
		String pwd = "170804";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			// establishing connection
			
			Connection connect = DriverManager.getConnection(url, un, pwd);
			
			
			String sql="insert into college values (102,'Rohan','rohan@gmail.com','male')";
			
			String sql2="update college set id=103 where name='Mohan'";
			
			String sql3="delete from college where id=103";
			
			//create statement
			Statement stmt = connect.createStatement();
			//execute statement
			stmt.execute(sql3);
			
			connect.close();
			
			System.out.println("Class Loaded");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
