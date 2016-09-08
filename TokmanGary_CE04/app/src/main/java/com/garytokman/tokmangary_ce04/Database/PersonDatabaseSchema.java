package com.garytokman.tokmangary_ce04.Database;

// Gary Tokman
// JAV2 - 1609
// PersonDataBaseSchema

public class PersonDatabaseSchema {

    public static final class PersonTable {

        public static final String NAME = "Person_Table";

        public static final class Columns {
            public static final String ID = "_id";
            public static final String FIRSTNAME = "firstName";
            public static final String LASTNAME = "lastName";
            public static final String EMPLOYEE_ID = "employeeId";
            public static final String HIREDATE = "hireDate";
            public static final String STATUS = "status";
        }
    }
}
