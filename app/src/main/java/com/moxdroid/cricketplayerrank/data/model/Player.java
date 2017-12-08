package com.moxdroid.cricketplayerrank.data.model;

import java.io.Serializable;

/**
 * Created by macstudent on 2017-11-30.
 */

public class Player implements Serializable
{

    private int _id;
    private String playerName;
    private String gender;
    private String birthDate;
    private String playerCategory;
    private String teamCountry;
    private int noOfTestMatch;
    private int noOfOneDayMatch;
    private int noOfCatches;
    private int noOfRuns;
    private int noOfWickets;
    private int noOfStumpings;
    private int totalPoints;

    public Player()
    {
    }

    public Player(String playerName, String gender, String birthDate, String playerCategory, String teamCountry, int noOfTestMatch, int noOfOneDayMatch, int noOfCatches, int noOfRuns, int noOfWickets, int noOfStumpings)
    {
        this.playerName = playerName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.playerCategory = playerCategory;
        this.teamCountry = teamCountry;
        this.noOfTestMatch = noOfTestMatch;
        this.noOfOneDayMatch = noOfOneDayMatch;
        this.noOfCatches = noOfCatches;
        this.noOfRuns = noOfRuns;
        this.noOfWickets = noOfWickets;
        this.noOfStumpings = noOfStumpings;
    }

    public Player(int _id, String playerName, String gender, String birthDate, String playerCategory, String teamCountry, int noOfTestMatch, int noOfOneDayMatch, int noOfCatches, int noOfRuns, int noOfWickets, int noOfStumpings, int totalPoints)
    {
        this._id = _id;
        this.playerName = playerName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.playerCategory = playerCategory;
        this.teamCountry = teamCountry;
        this.noOfTestMatch = noOfTestMatch;
        this.noOfOneDayMatch = noOfOneDayMatch;
        this.noOfCatches = noOfCatches;
        this.noOfRuns = noOfRuns;
        this.noOfWickets = noOfWickets;
        this.noOfStumpings = noOfStumpings;
        this.totalPoints = totalPoints;
    }

    public int get_id()
    {
        return _id;
    }

    public void set_id(int _id)
    {
        this._id = _id;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getPlayerCategory()
    {
        return playerCategory;
    }

    public void setPlayerCategory(String playerCategory)
    {
        this.playerCategory = playerCategory;
    }

    public String getTeamCountry()
    {
        return teamCountry;
    }

    public void setTeamCountry(String teamCountry)
    {
        this.teamCountry = teamCountry;
    }

    public int getNoOfTestMatch()
    {
        return noOfTestMatch;
    }

    public void setNoOfTestMatch(int noOfTestMatch)
    {
        this.noOfTestMatch = noOfTestMatch;
    }

    public int getNoOfOneDayMatch()
    {
        return noOfOneDayMatch;
    }

    public void setNoOfOneDayMatch(int noOfOneDayMatch)
    {
        this.noOfOneDayMatch = noOfOneDayMatch;
    }

    public int getNoOfCatches()
    {
        return noOfCatches;
    }

    public void setNoOfCatches(int noOfCatches)
    {
        this.noOfCatches = noOfCatches;
    }

    public int getNoOfRuns()
    {
        return noOfRuns;
    }

    public void setNoOfRuns(int noOfRuns)
    {
        this.noOfRuns = noOfRuns;
    }

    public int getNoOfWickets()
    {
        return noOfWickets;
    }

    public void setNoOfWickets(int noOfWickets)
    {
        this.noOfWickets = noOfWickets;
    }

    public int getNoOfStumpings()
    {
        return noOfStumpings;
    }

    public void setNoOfStumpings(int noOfStumpings)
    {
        this.noOfStumpings = noOfStumpings;
    }

    public int getTotalPoints()
    {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints)
    {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "_id=" + _id +
                ", playerName='" + playerName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", playerCategory='" + playerCategory + '\'' +
                ", teamCountry='" + teamCountry + '\'' +
                ", noOfTestMatch=" + noOfTestMatch +
                ", noOfOneDayMatch=" + noOfOneDayMatch +
                ", noOfCatches=" + noOfCatches +
                ", noOfRuns=" + noOfRuns +
                ", noOfWickets=" + noOfWickets +
                ", noOfStumpings=" + noOfStumpings +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
