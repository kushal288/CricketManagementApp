package com.kushal288.cricket.data;

public enum PlayerRole
{

	BATSMAN("batsman"), BOWLER("bowler"), ALLROUNDER("allrounder");
	private final String text;

	private PlayerRole(final String text)
	{
		this.text = text;
	}

	public String toString()
	{
		return text;
	}

	public static PlayerRole get(String s)
	{
		s = s.toLowerCase();
		switch (s)
		{
		case "batsman":

			return BATSMAN;

		case "bowler":

			return BOWLER;
		case "allrounder":

			return ALLROUNDER;
		}
		return null;
	}
}
