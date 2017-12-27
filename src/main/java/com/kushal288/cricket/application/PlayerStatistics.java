package com.kushal288.cricket.application;

import java.util.List;

import com.kushal288.cricket.data.PlayerProfile;

public class PlayerStatistics
{

	private PlayerProfile playerProfile;
	private List<AggregatedStats> allStats;

	public PlayerProfile getPlayerProfile()
	{
		return playerProfile;
	}

	public void setPlayerProfile(PlayerProfile playerProfile)
	{
		this.playerProfile = playerProfile;
	}

	public List<AggregatedStats> getAllStats()
	{
		return allStats;
	}

	public void setAllStats(List<AggregatedStats> allStats)
	{
		this.allStats = allStats;
	}

}
