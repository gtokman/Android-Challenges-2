package com.fullsail.android.jav2final.util;

import android.content.Context;
import android.widget.Toast;

import com.fullsail.android.jav2final.R;
import com.fullsail.android.jav2final.data.Politician;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PoliticiansHelper {

    private static final String FAVORITES_FILE = "favorites.dat";

    public static ArrayList<Politician> getAllPoliticians() {
        ArrayList<Politician> politicians = new ArrayList<>();

        try {

            URL url = new URL("https://www.govtrack.us/api/v2/role?current=true");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream is = connection.getInputStream();
            String data = IOUtils.toString(is);
            is.close();
            connection.disconnect();

            JSONObject response = new JSONObject(data);
            JSONArray objects = response.getJSONArray("objects");

            for (int i = 0; i < objects.length(); i++) {
                JSONObject obj = objects.getJSONObject(i);
                JSONObject person = obj.getJSONObject("person");

                int id = person.getInt("id");
                String name = person.getString("name");
                String party = obj.getString("party");
                String description = obj.getString("description");
                politicians.add(new Politician(name, party, description, id));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return politicians;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Politician> getFavoritePoliticians(Context context) {
        ArrayList<Politician> politicians = new ArrayList<>();

        // TODO: Load in favorite politicians from a file as an ArrayList of Politician objects.
        File file = new File(context.getFilesDir(), FAVORITES_FILE);

        try {
            // Create stream
            FileInputStream fileInputStream = new FileInputStream(file);
            // Wrap
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Read
            politicians = (ArrayList<Politician>) objectInputStream.readObject();

            // Close
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return politicians;
    }

    @SuppressWarnings("unchecked")
    public static void saveToFavorites(Context context, Politician politician) {

        if (politician == null) {
            throw new IllegalArgumentException("Cannot save a null politician.");
        }

        // TODO: Save out politician using an ArrayList of Politician objects.
        ArrayList<Politician> politicians = getFavoritePoliticians(context);

        for (Politician pol : politicians) {
            if (politician.equals(pol)) {
                Toast.makeText(context, "Politician already exists", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        politicians.add(politician);

        // Create file
        File file = new File(context.getFilesDir(), FAVORITES_FILE);

        try {
            // Start stream
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // Wrap
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write
            objectOutputStream.writeObject(politicians);

            fileOutputStream.close();
            objectOutputStream.close();
            Toast.makeText(context, R.string.politician_saved, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Nothing wrong with this method. Leave it alone.
    public static void deleteAllFavorites(Context context) {
        context.deleteFile(FAVORITES_FILE);
    }
}