package com.dgiles.sportstest;

public class SportsModel {
    String sportName;
    String sportAbbreviation;
    String sportSeason;
    int image;

    public SportsModel(String sportName, String sportAbbreviation, String sportSeason, int image) {
        this.sportName = sportName;
        this.sportAbbreviation = sportAbbreviation;
        this.sportSeason = sportSeason;
        this.image = image;
    }

    public String getSportName() {
        return sportName;
    }

    public String getSportAbbreviation() {
        return sportAbbreviation;
    }

    public String getSportSeason() {
        return sportSeason;
    }

    public int getImage() {
        return image;
    }
}
