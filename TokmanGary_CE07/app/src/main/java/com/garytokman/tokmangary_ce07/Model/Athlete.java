package com.garytokman.tokmangary_ce07.Model;

import java.io.Serializable;

// Gary Tokman
// JAV2 - 1609
// Athlete

public class Athlete implements Serializable {

    private final String mName;
    private final String mPosition;
    private final int mJerseyNumber;

    public Athlete(String name, String position, int jerseyNumber) {
        mName = name;
        mPosition = position;
        mJerseyNumber = jerseyNumber;
    }

    public String getName() {
        return mName;
    }

    public String getPosition() {
        return mPosition;
    }

    public int getJerseyNumber() {
        return mJerseyNumber;
    }

    @Override
    public String toString() {
        return " Name: " + mName + " Position: " + mPosition + " #" + mJerseyNumber;
    }
}
