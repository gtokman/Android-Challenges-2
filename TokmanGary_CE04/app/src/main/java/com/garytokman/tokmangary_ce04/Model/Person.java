package com.garytokman.tokmangary_ce04.Model;

import java.io.Serializable;
import java.util.Date;

// Gary Tokman
// JAV2 - 1609
// Person

public class Person implements Serializable {

    private String mFirstName;
    private String mLastName;
    private int mEmployeeNumber;
    private Date mHireDate;
    private String mEmployeeStatus;

    public Person(String firstName, String lastName, int employeeNumber, Date hireDate, String employeeStatus) {
        mFirstName = firstName;
        mLastName = lastName;
        mEmployeeNumber = employeeNumber;
        mHireDate = hireDate;
        mEmployeeStatus = employeeStatus;
    }

    public Person() {
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

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public void setEmployeeNumber(int employeeNumber) {
        mEmployeeNumber = employeeNumber;
    }

    public void setHireDate(Date hireDate) {
        mHireDate = hireDate;
    }

    public void setEmployeeStatus(String employeeStatus) {
        mEmployeeStatus = employeeStatus;
    }
}
