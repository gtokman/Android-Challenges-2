package com.garytokman.tokmangary_ce04.Helper;

// Gary Tokman
// JAV2 - 1609
// DateHelper

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

    private static final String TAG = "DateHelper";
    private static final String PATTERN1 = "MM/dd/yyyy";

    public static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(PATTERN1, Locale.US);

        return format.parse(date);
    }

    public static Date longToDate(long date) {
        return new Date(date * 1000);
    }
}
