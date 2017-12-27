package com.kushal288.cricket.db;

import com.kushal288.cricket.application.AggregatedStats;
import com.kushal288.cricket.application.PlayerStatistics;
import com.kushal288.cricket.data.PlayerProfile;

public class RetrievePlayerDetails
{

	private static PlayerProfile getPlayerProfile(String name, String country)
	{

		PlayerProfile profile = null;

		return null;
	}

	public static PlayerStatistics getPlayerStats(String name, String country)
	{

		PlayerProfile profile = getPlayerProfile(name, country);
		PlayerStatistics statistics = new PlayerStatistics();
		statistics.setPlayerProfile(profile);
		statistics.setAllStats(null);

		return statistics;
	}

	private static AggregatedStats getAllStats(PlayerProfile profile)
	{

	}
}
