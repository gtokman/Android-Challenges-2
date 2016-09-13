package com.garytokman.tokmangary_ce06.Database;

// Gary Tokman
// JAV2 - 1609
// DatabaseSchema

public class DatabaseSchema {

    public static final class ArticleTable {

        public static final String NAME = "ArticlesProvider";

        public static final class Columns {
            public static final String ID = "_id";
            public static final String TITLE = "title";
            public static final String THUMBNAIL = "thumbnail";
            public static final String BODY = "body";
        }
    }

}
