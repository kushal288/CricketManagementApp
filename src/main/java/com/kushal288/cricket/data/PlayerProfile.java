package com.kushal288.cricket.data;

public class PlayerProfile
{

	private transient Long playerID;
	private String name;
	private String country;
	private Integer age;
	private PlayingStyle battingStyle;
	private PlayingStyle bowlingStyle;
	private PlayerRole playerRole;

	public Long getPlayerID()
	{
		return playerID;
	}

	public void setPlayerID(Long playerID)
	{
		this.playerID = playerID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public PlayingStyle getBattingStyle()
	{
		return battingStyle;
	}

	public void setBattingStyle(PlayingStyle battingStyle)
	{
		this.battingStyle = battingStyle;
	}

	public PlayingStyle getBowlingStyle()
	{
		return bowlingStyle;
	}

	public void setBowlingStyle(PlayingStyle bowlingStyle)
	{
		this.bowlingStyle = bowlingStyle;
	}

	public PlayerRole getPlayerRole()
	{
		return playerRole;
	}

	public void setPlayerRole(PlayerRole playerRole)
	{
		this.playerRole = playerRole;
	}

}
