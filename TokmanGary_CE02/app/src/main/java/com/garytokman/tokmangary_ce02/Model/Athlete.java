package com.garytokman.tokmangary_ce02.Model;

import java.io.Serializable;

// Gary Guerman Tokman
// JAVA 2 1609
// Athlete
public class Athlete implements Serializable {

    private String mName;
    private String mPosition;
    private int mAge;

    public Athlete(String name, String position, int age) {
        mName = name;
        mPosition = position;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public String getPosition() {
        return mPosition;
    }

    public int getAge() {
        return mAge;
    }

    @Override
    public String toString() {
        return "Name: " + mName + " Position: " + mPosition + " Age: " + mAge;
    }
}
