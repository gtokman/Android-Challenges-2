package com.garytokman.tokmangary_ce01.network;

// Gary Guerman Tokman
// JAV2 - 1609
// APIClient

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIClient extends AsyncTask<String, Integer, String> {

    private static final String TAG = "ApiClient";

    public interface UpdateUIWithJson {
        void parseJson(String json) throws JSONException, IOException, ClassNotFoundException;
    }

    private Context mContext;
    private ProgressDialog mProgressDialog;
    private UpdateUIWithJson mUpdateUIWithJson;

    public APIClient(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Init interface
        if (mContext instanceof UpdateUIWithJson) {
            mUpdateUIWithJson = (UpdateUIWithJson) mContext;
        } else {
            throw new IllegalArgumentException("Could not initialize delegate!");
        }

        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {

        HttpURLConnection httpURLConnection;
        String baseUrl = "https://api.github.com/search/repositories?q=";
        Log.d(TAG, "doInBackground: " + baseUrl + strings[0]);
        // Get Json
        try {
            URL url = new URL(baseUrl + strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();

            String data = IOUtils.toString(inputStream);
            inputStream.close();
            httpURLConnection.disconnect();

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        // Notify
        try {
            mUpdateUIWithJson.parseJson(data);
            mProgressDialog.hide();
        } catch (JSONException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
