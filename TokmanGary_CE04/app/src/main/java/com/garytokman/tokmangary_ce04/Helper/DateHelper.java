package com.garytokman.tokmangary_ce04.Helper;

// Gary Tokman
// JAV2 - 1609
// DateHelper

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

    public static Date stringToDate(String date) throws ParseException {
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);

        return format.parse(date);
    }

    public static String newDateFormat(Date date, String pattern) {

        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);

        return format.format(date);
    }

    public static Date longToDate(long date) {
        return new Date(date * 1000);
    }
}
