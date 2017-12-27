package com.kushal288.cricket.application;

public class CricketCalculations
{

	public static double calcBattingAverage(int runsScored, int innings, int notOuts)
	{
		return (double) runsScored / (double) (innings - notOuts);
	}

	public static double calcBattingStrikeRate(int runsScored, int ballsFaced)
	{
		return (double) runsScored * 100.00 / (double) (ballsFaced);
	}

	public static double calcBowlingAverage(int runsGiven, int wkts)
	{
		return (double) runsGiven / (double) (wkts);

	}

	public static double calcBowlingStrikeRate(int wkts, int ballsBowled)
	{
		return (double) ballsBowled / (double) (wkts);

	}

	public static double calcBowlingEconomyRate(int runsGiven, int ballsBowled)
	{
		return (double) runsGiven * 6.00 / (double) (ballsBowled);

	}

}
