package com.garytokman.tokmangary_ce07.Database;

// Gary Tokman
// JAV2 - 1609
// DatabaseSchema

public class DatabaseSchema {

    public static final class AthleteTable {

        public static final String NAME = "athlete_table";

        public static final class Columns {
            public static final String ID = "_id";
            public static final String NAME = "name";
            public static final String POSITION = "position";
            public static final String JERSEY_NUMBER = "jersey_number";
        }
    }
}
