package com.kushal288.cricket.application;

import java.util.Scanner;

public class CricApp
{

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
			if ("exit".equalsIgnoreCase(playerName))
				break;
			System.out.println("Enter Player Country - ");
			String country = in.nextLine();
			if ("exit".equalsIgnoreCase(country))
				break;

		}
		in.close();

	}
}
