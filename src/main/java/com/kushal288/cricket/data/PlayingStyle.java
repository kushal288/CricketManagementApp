package com.kushal288.cricket.data;

public enum PlayingStyle
{

	LEFT_HANDED("left"), RIGHT_HANDED("right"), DUAL("dual"), UNKNOWN("unknown");

	private final String text;

	private PlayingStyle(final String text)
	{
		this.text = text;
	}

	public String toString()
	{
		return text;
	}

	public static PlayingStyle get(String s)
	{
		s = s.toLowerCase();
		switch (s)
		{
		case "left":
			return LEFT_HANDED;
		case "right":
			return RIGHT_HANDED;
		default:
			return null;
		}
	}
}
