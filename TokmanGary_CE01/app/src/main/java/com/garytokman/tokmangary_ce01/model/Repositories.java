package com.garytokman.tokmangary_ce01.model;

// Gary Guerman Tokman
// JAV2 - 1609
// Repositories

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Repositories {

    private static final String TAG = "Repositories";
    private List<Repository> mRepositories;
    private Context mContext;
    private String fileName = "Repositories";
    private File mFile;

    public Repositories(Context context, List<Repository> repositories) {
        mContext = context;
        mRepositories = repositories;
        mFile = new File(mContext.getFilesDir(), fileName);
    }

    public void saveDataToFile() throws IOException {
        // Create stream
        FileOutputStream fileOutputStream = new FileOutputStream(mFile);

        // Wrap
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        // Write
        objectOutputStream.writeObject(mRepositories);

        Log.d(TAG, "saveDataToFile: saving data..........");

        fileOutputStream.close();
        objectOutputStream.close();
    }

    public List<Repository> readDataFromFile() throws ClassNotFoundException, IOException {

        List<Repository> repositories = new ArrayList<>();

        // Create stream
        FileInputStream fileInputStream = new FileInputStream(mFile);

        // Wrap
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        // Read
        repositories = (List<Repository>) objectInputStream.readObject();

        // Close
        fileInputStream.close();
        objectInputStream.close();

        Log.d(TAG, "readDataFromFile() returned: " + repositories);

        return repositories;
    }
}
