package com.fullsail.android.jav2final.util;

import android.content.Context;

import com.fullsail.android.jav2final.data.Politician;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PoliticiansHelper {

    private static final String FAVORITES_FILE = "favorites.dat";

	public static ArrayList<Politician> getAllPoliticians() {
		ArrayList<Politician> politicians = new ArrayList<>();

		try {

			URL url = new URL("https://www.govtrack.us/api/v2/role?current=true");

			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.connect();

			InputStream is = connection.getInputStream();
			String data = IOUtils.toString(is);
			is.close();
			connection.disconnect();

			JSONObject response = new JSONObject(data);
			JSONArray objects = response.getJSONArray("objects");

			for(int i = 0; i < objects.length(); i++) {
				JSONObject obj = objects.getJSONObject(i);
				JSONObject person = obj.getJSONObject("person");

				int id = person.getInt("id");
				String name = person.getString("name");
				String party = obj.getString("party");
				String description = obj.getString("description");
				politicians.add(new Politician(name, party, description, id));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return politicians;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Politician> getFavoritePoliticians(Context context) {
		ArrayList<Politician> politicians = new ArrayList<>();

		// TODO: Load in favorite politicians from a file as an ArrayList of Politician objects.

		return politicians;
	}

	@SuppressWarnings("unchecked")
	public static void saveToFavorites(Context context, Politician politician) {

        if(politician == null) {
            throw new IllegalArgumentException("Cannot save a null politician.");
        }

		// TODO: Save out politician using an ArrayList of Politician objects.
	}

    // Nothing wrong with this method. Leave it alone.
    public static void deleteAllFavorites(Context context) {
        context.deleteFile(FAVORITES_FILE);
    }
}