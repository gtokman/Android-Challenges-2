package com.garytokman.tokmangary_ce02.Model;

// Gary Guerman Tokman
// JAVA 2 1609
// BaseballPlayer

public class BaseballPlayer extends Athlete {

    private int mNumberOfHomeRuns;

    public BaseballPlayer(String name, String position, int age, int numberOfHomeRuns) {
        super(name, position, age);
        mNumberOfHomeRuns = numberOfHomeRuns;
    }

    @Override
    public String toString() {
        return super.toString() + " Homeruns: " + mNumberOfHomeRuns;
    }

    public int getNumberOfHomeRuns() {
        return mNumberOfHomeRuns;
    }
}
