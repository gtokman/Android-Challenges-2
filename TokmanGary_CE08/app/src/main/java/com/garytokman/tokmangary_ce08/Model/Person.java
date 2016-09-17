package com.garytokman.tokmangary_ce08.Model;

import java.io.Serializable;

// Gary Tokman
// JAV2 - 1609
// Person

public class Person implements Serializable {

    private final String mFirstName;
    private final String mLastName;
    private final int mAge;

    public Person(String firstName, String lastName, int age) {
        mFirstName = firstName;
        mLastName = lastName;
        mAge = age;

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
