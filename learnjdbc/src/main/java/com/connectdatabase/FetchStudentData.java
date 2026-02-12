package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudentData {
	public static void main(String[] args) {
		
		String url ="jdbc:postgresql://localhost:5432/postgres";
		String un = "postgres";
		String pwd = "170804";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url,un,pwd);
			
			String sql = "select * from college";
			
			Statement stmt = connect.createStatement();
			
			ResultSet res = stmt.executeQuery(sql);
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+
						res.getString(3)+" "+res.getString(4));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
