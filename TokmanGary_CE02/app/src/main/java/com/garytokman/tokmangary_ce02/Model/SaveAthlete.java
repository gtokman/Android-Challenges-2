package com.garytokman.tokmangary_ce02.Model;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

// Gary Guerman Tokman
// JAVA 2 1609
// SaveAthlete

public class SaveAthlete {

    private static final String FILE_NAME = "AthleteFile";
    private static final String TAG = "SaveAthlete";
    private List<Athlete> mAthletes;
    private File mFile;

    public SaveAthlete(Context context, List<Athlete> athletes) {
        mAthletes = athletes;
        mFile = new File(context.getFilesDir(), FILE_NAME);
    }

    public SaveAthlete(Context context) {
        mFile = new File(context.getFilesDir(), FILE_NAME);
    }

    public void setAthletes(List<Athlete> athletes) {
        mAthletes = athletes;
    }

    public void SaveAthletes() {
        try {
            // Create stream
            FileOutputStream fileOutputStream = new FileOutputStream(mFile);

            // Wrap
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write to file
            objectOutputStream.writeObject(mAthletes);

            Log.d(TAG, "SaveAthletes: Saving .....................");

            // Close
            fileOutputStream.close();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public List<Athlete> loadAthletes() {

        // Create list
        List<Athlete> athletes = null;

        try {
            // Create stream
            FileInputStream fileInputStream = new FileInputStream(mFile);

            // Wrap
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Get data
            athletes = (List<Athlete>) objectInputStream.readObject();

            // Close
            fileInputStream.close();
            objectInputStream.close();

            Log.d(TAG, "loadAthletes() returned: " + athletes);

            return athletes;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
