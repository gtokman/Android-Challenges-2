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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class People {
    private static People sPeople;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static People getInstance(Context context) {
        if (sPeople == null) {
            sPeople = new People(context);
        }

        return sPeople;
    }

    private People(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new PersonDatabase(context).getWritableDatabase();
    }

    public List<Person> getPeople() {
        return new ArrayList<>();
    }

    public void addPeople(Person person) {
        // Get ContentValues
        ContentValues contentValues = getContentValues(person);

        // Insert person
        mDatabase.insert(PersonTable.NAME, null, contentValues);
    }

    public Person getPerson(Cursor cursor) {

        String firstName = cursor.getString(cursor.getColumnIndex(PersonTable.Columns.FIRSTNAME));
        String lastName = cursor.getString(cursor.getColumnIndex(PersonTable.Columns.LASTNAME));
        int number = cursor.getInt(cursor.getColumnIndex(PersonTable.Columns.EMPLOYEE_ID));
        long hireDate = cursor.getLong(cursor.getColumnIndex(PersonTable.Columns.HIREDATE));
        String status = cursor.getString(cursor.getColumnIndex(PersonTable.Columns.STATUS));


        return new Person(firstName, lastName, number, new Date(hireDate * 1000), status);
    }

    public void deletePerson(Person person, String where, String[] whereArgs) {
        mDatabase.delete(PersonTable.NAME, where, whereArgs);
    }

    public void updatePeople(Person person) {
        // Update by unique employee id
        String employeeId = String.valueOf(person.getEmployeeNumber());
        ContentValues contentValues = getContentValues(person);

        mDatabase.update(PersonTable.NAME, contentValues,
                PersonTable.Columns.EMPLOYEE_ID + " = ?",
                new String[]{employeeId});
    }

    private Cursor queryAllPeople(String where, String[] whereArgs) {

        // Table name, all columns = null, where, whereARgs, group by, having, order by
        return mDatabase.query(
                PersonTable.NAME,
                null,
                where,
                whereArgs,
                null,
                null,
                null
        );

    }

    private static ContentValues getContentValues(Person person) {
        ContentValues contentValues = new ContentValues();
        // TODO: Convert date
        contentValues.put(PersonTable.Columns.FIRSTNAME, person.getFirstName());
        contentValues.put(PersonTable.Columns.LASTNAME, person.getLastName());
        contentValues.put(PersonTable.Columns.EMPLOYEE_ID, person.getEmployeeNumber());
        contentValues.put(PersonTable.Columns.HIREDATE, person.getHireDate().getTime());
        contentValues.put(PersonTable.Columns.STATUS, person.getEmployeeStatus());

        return contentValues;
    }


}
