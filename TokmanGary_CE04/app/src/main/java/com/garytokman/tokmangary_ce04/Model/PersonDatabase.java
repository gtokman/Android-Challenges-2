package com.garytokman.tokmangary_ce04.Model;

// Gary Tokman
// JAV2 - 1609
// PersonDataBase

public class PersonDatabase {

    private static PersonDatabase sPersonDatabase = new PersonDatabase();

    public static PersonDatabase getInstance() {
        return sPersonDatabase;
    }


}
