package com.garytokman.tokmangary_ce03.Model;

// Gary Tokman
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
    private static Repositories sRepositories;
    private List<Repository> mRepositories;
    private static final String FILE_NAME = "RepositoryData";
    private File mFile;

    private Repositories(Context context) {
        mRepositories = new ArrayList<>();
        mFile = new File(context.getFilesDir(), FILE_NAME);
    }

    public void setRepositories(List<Repository> repositories) {
        if (!mRepositories.contains(repositories)) {
            mRepositories = repositories;
            saveRepositories();
        }
    }

    public List<Repository> getRepositories() {
        if (loadRepositories() != null) {
            return loadRepositories();
        }
        return mRepositories;
    }

    public static Repositories getInstance(Context context) {
        if (sRepositories == null) {
            sRepositories = new Repositories(context);
        }

        return sRepositories;
    }

    // TODO: Save to file
    private void saveRepositories() {
        try {
            // Create stream
            FileOutputStream fileOutputStream = new FileOutputStream(mFile);

            // Wrap
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write to file
            objectOutputStream.writeObject(mRepositories);

            Log.d(TAG, "Saving .....................");

            // Close
            fileOutputStream.close();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    private List<Repository> loadRepositories() {

        // Create list
        List<Repository> repositories;

        try {
            // Create stream
            FileInputStream fileInputStream = new FileInputStream(mFile);

            // Wrap
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Get data
            repositories = (List<Repository>) objectInputStream.readObject();

            // Close
            fileInputStream.close();
            objectInputStream.close();

            Log.d(TAG, "loadRepositories returned: " + repositories);

            return repositories;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
