package com.garytokman.tokmangary_ce03.Network;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Gary Tokman
// JAV2 - 1609
// APIClient

public class APIClient extends AsyncTask<String, Integer, String> {

    private static final String TAG = "AsyncTask";

    public interface APIClientJson {
        void getJson(String json);
    }

    private Context mContext;
    private APIClientJson mAPIClientJson;
    private ProgressDialog mProgressDialog;

    public APIClient(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Check class
        if (mContext instanceof APIClientJson) {
            mAPIClientJson = (APIClientJson) mContext;
        } else {
            throw new IllegalArgumentException("Class does not implement APIClient");
        }

        // Progress
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

    }

    @Override
    protected String doInBackground(String... strings) {

        String baseUrl = "";
        String parameter = strings[0];
        Log.d(TAG, "doInBackground: url: " + baseUrl + parameter);

        // Make request
        HttpURLConnection httpURLConnection;

        try {
            URL url = new URL (baseUrl + parameter);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            String data = IOUtils.toString(inputStream);

            inputStream.close();
            httpURLConnection.disconnect();

            Log.d(TAG, "doInBackground() returned: " + data);

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        // Hide // Notify
        mProgressDialog.hide();
        mAPIClientJson.getJson(json);
    }
}
