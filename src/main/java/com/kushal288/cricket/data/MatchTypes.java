package com.kushal288.cricket.data;

public enum MatchTypes
{

	TEST("TEST"), ODI("ODI"), T20("T20");

	private final String text;

	private MatchTypes(final String text)
	{
		this.text = text;
	}

	public String toString()
	{
		return text;
	}

	public static MatchTypes get(String s)
	{
		s = s.toUpperCase();
		switch (s)
		{
		case "TEST":
			return TEST;
		case "ODI":
			return ODI;
		case "T20":
			return T20;
		default:
			return null;
		}
	}
}
