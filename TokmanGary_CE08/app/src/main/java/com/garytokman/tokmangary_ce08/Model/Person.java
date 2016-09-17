package com.garytokman.tokmangary_ce08.Model;

import java.io.Serializable;
import java.util.Observable;

// Gary Tokman
// JAV2 - 1609
// Person

public class Person extends Observable implements Serializable {

    private String mFirstName;
    private String mLastName;
    private int mAge;

    public Person(String firstName, String lastName, int age) {
        mFirstName = firstName;
        mLastName = lastName;
        mAge = age;

        setChanged();
        notifyObservers();

    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getAge() {
        return mAge;
    }

    @Override
    public String toString() {
        return mFirstName + " " + mLastName + " " + mAge;
    }
}
