package com.garytokman.tokmangary_ce02.Model;

// Gary Guerman Tokman
// JAVA 2 1609
// FootballPayer

public class FootballPlayer extends Athlete {

    private int mNumberOfTouchDowns;

    public FootballPlayer(String name, String position, int age, int numberOfTouchDowns) {
        super(name, position, age);
        mNumberOfTouchDowns = numberOfTouchDowns;
    }

    @Override
    public String toString() {
        return super.toString() + " TouchDowns: " + mNumberOfTouchDowns;
    }

    public int getNumberOfTouchDowns() {
        return mNumberOfTouchDowns;
    }
}
