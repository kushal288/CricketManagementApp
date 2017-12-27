package com.kushal288.cricket.data;

public class BowlingStats
{
	private Integer ballsBowled;
	private Integer wicketsTaken;
	private Integer maidens;
	private Integer runsGiven;
	private Integer fiveWkts;
	private Double bowlingAverage;
	private Double bowlingStrikeRate;

	public Integer getFiveWkts()
	{
		return fiveWkts;
	}

	public void setFiveWkts(Integer fiveWkts)
	{
		this.fiveWkts = fiveWkts;
	}

	public Integer getBallsBowled()
	{
		return ballsBowled;
	}

	public void setBallsBowled(Integer ballsBowled)
	{
		this.ballsBowled = ballsBowled;
	}

	public Integer getWicketsTaken()
	{
		return wicketsTaken;
	}

	public void setWicketsTaken(Integer wicketsTaken)
	{
		this.wicketsTaken = wicketsTaken;
	}

	public Integer getMaidens()
	{
		return maidens;
	}

	public void setMaidens(Integer maidens)
	{
		this.maidens = maidens;
	}

	public Integer getRunsGiven()
	{
		return runsGiven;
	}

	public void setRunsGiven(Integer runsGiven)
	{
		this.runsGiven = runsGiven;
	}

	public Double getBowlingAverage()
	{
		return bowlingAverage;
	}

	public void setBowlingAverage(Double bowlingAverage)
	{
		this.bowlingAverage = bowlingAverage;
	}

	public Double getBowlingStrikeRate()
	{
		return bowlingStrikeRate;
	}

	public void setBowlingStrikeRate(Double bowlingStrikeRate)
	{
		this.bowlingStrikeRate = bowlingStrikeRate;
	}

}
