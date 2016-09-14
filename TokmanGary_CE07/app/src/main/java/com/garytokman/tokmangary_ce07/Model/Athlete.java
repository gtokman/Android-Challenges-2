package com.garytokman.tokmangary_ce07.Model;

import java.io.Serializable;

// Gary Tokman
// JAV2 - 1609
// Athlete

public class Athlete implements Serializable {

    private String mName;
    private String mPosition;
    private int mJerseyNumber;

    public Athlete(String name, String positon, int jerseyNumber) {
        mName = name;
        mPosition = positon;
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
        return mName + " " + mJerseyNumber;
    }
}
