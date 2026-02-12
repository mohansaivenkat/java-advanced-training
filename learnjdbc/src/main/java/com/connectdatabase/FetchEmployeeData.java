package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchEmployeeData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url ="jdbc:postgresql://localhost:5432/postgres";
		String un = "postgres";
		String pwd = "170804";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url, un, pwd);
			
			String sql = "select * from employee";
			
			PreparedStatement stmt = connect.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				System.out.println(res.getString(1)+" "+res.getInt(2)+" "+
						res.getInt(3)+" "+res.getString(4));
			}
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
