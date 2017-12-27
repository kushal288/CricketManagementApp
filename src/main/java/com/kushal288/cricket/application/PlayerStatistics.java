package com.kushal288.cricket.application;

import java.util.Map;

import com.kushal288.cricket.data.MatchTypes;
import com.kushal288.cricket.data.PlayerProfile;

public class PlayerStatistics
{

	private PlayerProfile playerProfile;
	private Map<MatchTypes, AggregatedStats> allStats;

	public PlayerProfile getPlayerProfile()
	{
		return playerProfile;
	}

	public void setPlayerProfile(PlayerProfile playerProfile)
	{
		this.playerProfile = playerProfile;
	}

	public Map<MatchTypes, AggregatedStats> getAllStats()
	{
		return allStats;
	}

	public void setAllStats(Map<MatchTypes, AggregatedStats> allStats)
	{
		this.allStats = allStats;
	}

}
