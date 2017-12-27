package com.kushal288.cricket.application;

import com.kushal288.cricket.data.BattingStats;
import com.kushal288.cricket.data.BowlingStats;
import com.kushal288.cricket.data.FieldingStats;
import com.kushal288.cricket.data.MatchTypes;

public class AggregatedStats
{

	private Integer matchesPlayed;
	private MatchTypes matchType;
	private BattingStats battingStats;
	private BowlingStats bowlingStats;
	private FieldingStats fieldingStats;

	public Integer getMatchesPlayed()
	{
		return matchesPlayed;
	}

	public void setMatchesPlayed(Integer matchesPlayed)
	{
		this.matchesPlayed = matchesPlayed;
	}

	public MatchTypes getMatchType()
	{
		return matchType;
	}

	public void setMatchType(MatchTypes matchType)
	{
		this.matchType = matchType;
	}

	public BattingStats getBattingStats()
	{
		return battingStats;
	}

	public void setBattingStats(BattingStats battingStats)
	{
		this.battingStats = battingStats;
	}

	public BowlingStats getBowlingStats()
	{
		return bowlingStats;
	}

	public void setBowlingStats(BowlingStats bowlingStats)
	{
		this.bowlingStats = bowlingStats;
	}

	public FieldingStats getFieldingStats()
	{
		return fieldingStats;
	}

	public void setFieldingStats(FieldingStats fieldingStats)
	{
		this.fieldingStats = fieldingStats;
	}

}
