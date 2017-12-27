package com.kushal288.cricket.application;

import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kushal288.cricket.db.DBFunctions;

public class CricApp
{

	public static final Gson gson = new GsonBuilder().create();

	/*public static void main(String[] args)
	{
		PlayerStatistics profile = DBFunctions.getPlayerStats("Sachin Tendulkar", "India");
		System.out.println(gson.toJson(profile));
	}*/

	public static void main(String[] args)
	{

		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch (ClassNotFoundException e)
		{

			e.printStackTrace();
		}
		System.out.println("Type \"exit\" and press enter to exit!");
		Scanner in = new Scanner(System.in);

		while (true)
		{

			System.out.println("Enter Player name - ");
			String playerName = in.nextLine();
			while (playerName == null || playerName.isEmpty())
			{
				System.out.println("No input received! Enter Player name - ");
				playerName = in.nextLine();
			}
			if ("exit".equalsIgnoreCase(playerName))
				break;
			System.out.println("Enter Player Country - ");
			String country = in.nextLine();
			while (country == null || country.isEmpty())
			{
				System.out.println("No input received! Enter Player Country - ");
				country = in.nextLine();
			}
			if ("exit".equalsIgnoreCase(country))
				break;
			List<PlayerStatistics> profile = DBFunctions.getPlayerStats(playerName, country);
			if (profile.isEmpty())
			{
				System.out.println("No records Found for the provided inputs!");
			}
			System.out.println(gson.toJson(profile));

		}
		in.close();

	}
}
