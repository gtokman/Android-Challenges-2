package com.garytokman.tokmangary_ce04.Model;

import java.io.Serializable;
import java.sql.Date;

// Gary Tokman
// JAV2 - 1609
// Person

public class Person implements Serializable {

    private final String mFirstName;
    private final String mLastName;
    private final int mEmployeeNumber;
    private final Date mHireDate;
    private final String mEmployeeStatus;

    public Person(String firstName, String lastName, int employeeNumber, Date hireDate, String employeeStatus) {
        mFirstName = firstName;
        mLastName = lastName;
        mEmployeeNumber = employeeNumber;
        mHireDate = hireDate;
        mEmployeeStatus = employeeStatus;
    }

    @Override
    public String toString() {
        return mFirstName + " " + mLastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getFullName() {
        return mFirstName + " " + mLastName;
    }

    public int getEmployeeNumber() {
        return mEmployeeNumber;
    }

    public Date getHireDate() {
        return mHireDate;
    }

    public String getEmployeeStatus() {
        return mEmployeeStatus;
    }
}
