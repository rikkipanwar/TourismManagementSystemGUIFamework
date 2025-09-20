package com.tekpyramid.tms.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con;
	
	public void getDbConnection(String url, String usename, String password) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, usename, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeDbConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
