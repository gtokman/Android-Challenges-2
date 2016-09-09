package com.garytokman.tokmangary_ce04.Model;

// Gary Tokman
// JAV2 - 1609
// MainActivity

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.garytokman.tokmangary_ce04.Database.PersonDatabase;
import com.garytokman.tokmangary_ce04.Database.PersonDatabaseSchema.PersonTable;
import com.garytokman.tokmangary_ce04.Helper.DateHelper;

import static com.garytokman.tokmangary_ce04.Fragments.PersonFormFragment.*;

public class People {
    private static People sPeople;
    private final SQLiteDatabase mDatabase;

    public static People getInstance(Context context) {
        if (sPeople == null) {
            sPeople = new People(context);
        }

        return sPeople;
    }

    private People(Context context) {
        mDatabase = new PersonDatabase(context).getWritableDatabase();
    }

    public void addPeople() {
        // Get ContentValues
        ContentValues contentValues = getContentValues();

        // Insert person
        mDatabase.insert(PersonTable.NAME, null, contentValues);
    }

    public Person getPerson(Cursor cursor) {

        String firstName = cursor.getString(cursor.getColumnIndex(PersonTable.Columns.FIRSTNAME));
        String lastName = cursor.getString(cursor.getColumnIndex(PersonTable.Columns.LASTNAME));
        int number = cursor.getInt(cursor.getColumnIndex(PersonTable.Columns.EMPLOYEE_ID));
        long hireDate = cursor.getLong(cursor.getColumnIndex(PersonTable.Columns.HIREDATE));
        String status = cursor.getString(cursor.getColumnIndex(PersonTable.Columns.STATUS));


        return new Person(firstName, lastName, number, DateHelper.longToDate(hireDate), status);
    }

    public void deletePerson(String where, String[] whereArgs) {
        mDatabase.delete(PersonTable.NAME, where, whereArgs);
    }

    public Cursor queryAllPeople() {

        // Table name, all columns = null, where, whereARgs, group by, having, order by
        return mDatabase.query(
                PersonTable.NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    private static ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(PersonTable.Columns.FIRSTNAME, person.getFirstName());
        contentValues.put(PersonTable.Columns.LASTNAME, person.getLastName());
        contentValues.put(PersonTable.Columns.EMPLOYEE_ID, person.getEmployeeNumber());
        contentValues.put(PersonTable.Columns.HIREDATE, person.getHireDate().getTime());
        contentValues.put(PersonTable.Columns.STATUS, person.getEmployeeStatus());

        return contentValues;
    }
}
