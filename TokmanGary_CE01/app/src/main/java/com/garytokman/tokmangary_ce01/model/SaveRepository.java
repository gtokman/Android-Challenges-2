package com.garytokman.tokmangary_ce01.model;

// Gary Guerman Tokman
// JAV2 - 1609
// SaveRepository

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class SaveRepository {

    private static final String TAG = "RepositoriesFile";
    private static final String FILE_NAME = "SaveRepository";
    private Map<String, List<Repository>> mRepositories;
    private File mFile;

    public SaveRepository(Context context, Map<String, List<Repository>> repositories) {
        mRepositories = repositories;
        mFile = new File(context.getFilesDir(), FILE_NAME);
    }

    public SaveRepository(Context context) {
        mFile = new  File(context.getFilesDir(), FILE_NAME);
    }

    public void setRepositories(Map<String, List<Repository>> repositories) {
        mRepositories = repositories;
    }

    public boolean doesFileExist() {
        return mFile.exists();
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

    public Map<String, List<Repository>> readDataFromFile() throws ClassNotFoundException, IOException {

        Map<String, List<Repository>> map;

        // Create stream
        FileInputStream fileInputStream = new FileInputStream(mFile);

        // Wrap
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        // Read
        map = (Map<String, List<Repository>>) objectInputStream.readObject();

        // Close
        fileInputStream.close();
        objectInputStream.close();

        Log.d(TAG, "readDataFromFile() returned: " + map);

        return map;
    }
}
