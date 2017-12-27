package com.kushal288.cricket.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kushal288.cricket.application.AggregatedStats;
import com.kushal288.cricket.application.CricketCalculations;
import com.kushal288.cricket.application.PlayerStatistics;
import com.kushal288.cricket.data.BattingStats;
import com.kushal288.cricket.data.BowlingStats;
import com.kushal288.cricket.data.FieldingStats;
import com.kushal288.cricket.data.MatchTypes;
import com.kushal288.cricket.data.PlayerProfile;
import com.kushal288.cricket.data.PlayerRole;
import com.kushal288.cricket.data.PlayingStyle;

public class DBFunctions
{
	static Connection conn = null;

	static
	{
		// SQLite connection string
		String url = "jdbc:sqlite:db/cricdb.db";

		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
		}
		catch (SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static List<PlayerProfile> getPlayerProfiles(String name, String country)
	{
		List<PlayerProfile> profiles = new ArrayList<>();
		String sql = "SELECT playerID,name,country,age,battingStyle,bowlingStyle,playerRole FROM PlayerProfile WHERE name = ? AND country =?";
		// String sql = "SELECT * FROM PlayerProfile WHERE name = ? AND country =?";
		try (PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setString(1, name.toUpperCase());
			stmt.setString(2, country.toUpperCase());
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				PlayerProfile profile = new PlayerProfile();
				profile.setPlayerID(rs.getLong("playerID"));
				profile.setAge(rs.getInt("age"));
				profile.setBattingStyle(PlayingStyle.get(rs.getString("battingStyle")));
				profile.setBowlingStyle(PlayingStyle.get(rs.getString("bowlingStyle")));
				profile.setCountry(rs.getString("country"));
				profile.setName(rs.getString("name"));
				profile.setPlayerRole(PlayerRole.get(rs.getString("playerRole")));
				profiles.add(profile);

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return profiles;
	}

	public static List<PlayerStatistics> getPlayerStats(String name, String country)
	{
		List<PlayerStatistics> players = new ArrayList<>();
		List<PlayerProfile> profiles = getPlayerProfiles(name, country);
		for (PlayerProfile profile : profiles)
		{
			PlayerStatistics statistics = new PlayerStatistics();
			statistics.setPlayerProfile(profile);
			statistics.setAllStats(getAllStats(profile));
			players.add(statistics);
		}

		return players;
	}

	private static List<AggregatedStats> getAllStats(PlayerProfile profile)
	{
		List<AggregatedStats> list = new ArrayList<>();
		String sql = "SELECT id,playerID,matchesPlayed,matchType,battingStats,bowlingStats,fieldingStats FROM AggregatedStats WHERE playerID = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setLong(1, profile.getPlayerID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				AggregatedStats stats = new AggregatedStats();
				stats.setMatchesPlayed(rs.getInt("matchesPlayed"));
				stats.setMatchType(MatchTypes.get(rs.getString("matchType")));
				BattingStats battingStats = getBattingStats(rs.getInt("battingStats"));
				stats.setBattingStats(battingStats);

				BowlingStats bowlingStats = getBowlingStats(rs.getInt("bowlingStats"));
				stats.setBowlingStats(bowlingStats);
				FieldingStats fieldingStats = getFieldingStats(rs.getInt("fieldingStats"));
				stats.setFieldingStats(fieldingStats);

				list.add(stats);

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return list;
	}

	private static BattingStats getBattingStats(Integer statid)
	{
		if (statid == null || statid == 0)
		{
			return null;
		}
		BattingStats battingStats = new BattingStats();
		String sql = "SELECT innings,notOuts,runsScored,fours,sixes,halfCentury,centuries,ballsFaced FROM BattingStats WHERE id = ?";
		// String sql = "SELECT * FROM BattingStats WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setInt(1, statid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				battingStats.setBallsFaced(rs.getInt("ballsFaced"));
				battingStats.setCenturies(rs.getInt("centuries"));
				battingStats.setFours(rs.getInt("fours"));
				battingStats.setSixes(rs.getInt("sixes"));
				battingStats.setHalfCentury(rs.getInt("halfCentury"));
				battingStats.setInnings(rs.getInt("innings"));
				battingStats.setNotOuts(rs.getInt("notOuts"));
				battingStats.setRunsScored(rs.getInt("runsScored"));
				battingStats.setBattingAverage(
				                               CricketCalculations.calcBattingAverage(
				                                                                      battingStats.getRunsScored(),
				                                                                      battingStats.getInnings(),
				                                                                      battingStats.getNotOuts()));
				battingStats.setBattingStrikeRate(CricketCalculations.calcBattingStrikeRate(battingStats.getRunsScored(), battingStats.getBallsFaced()));

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return battingStats;
	}

	private static BowlingStats getBowlingStats(Integer statid)
	{
		if (statid == null || statid == 0)
		{
			return null;
		}
		BowlingStats stats = new BowlingStats();
		String sql = "SELECT ballsBowled,wicketsTaken,maidens,runsGiven,fiveWkts FROM BowlingStats WHERE id = ?";
		// String sql = "SELECT * FROM BattingStats WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setInt(1, statid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				stats.setBallsBowled(rs.getInt("ballsBowled"));
				stats.setFiveWkts(rs.getInt("fiveWkts"));
				stats.setMaidens(rs.getInt("maidens"));
				stats.setRunsGiven(rs.getInt("runsGiven"));
				stats.setWicketsTaken(rs.getInt("wicketsTaken"));
				stats.setBowlingAverage(CricketCalculations.calcBowlingAverage(stats.getRunsGiven(), stats.getWicketsTaken()));
				stats.setBowlingStrikeRate(CricketCalculations.calcBowlingStrikeRate(stats.getWicketsTaken(), stats.getBallsBowled()));

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return stats;
	}

	private static FieldingStats getFieldingStats(Integer statid)
	{
		if (statid == null || statid == 0)
		{
			return null;
		}
		FieldingStats stats = new FieldingStats();
		String sql = "SELECT catchesTaken,runOuts,stumpings FROM FieldingStats WHERE id = ?";
		// String sql = "SELECT * FROM BattingStats WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setInt(1, statid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				stats.setCatchesTaken(rs.getInt("catchesTaken"));
				stats.setRunOuts(rs.getInt("runOuts"));
				stats.setStumpings(rs.getInt("stumpings"));

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return stats;
	}

}
