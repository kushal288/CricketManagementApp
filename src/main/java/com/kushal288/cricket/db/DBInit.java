package com.kushal288.cricket.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInit
{

	public static void createNewDatabase(String fileName) throws ClassNotFoundException
	{

		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:db/" + fileName;

		try (Connection conn = DriverManager.getConnection(url))
		{
			if (conn != null)
			{
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		}
		catch (SQLException e)
		{

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		try
		{
			createNewDatabase("cricdb.db");
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
