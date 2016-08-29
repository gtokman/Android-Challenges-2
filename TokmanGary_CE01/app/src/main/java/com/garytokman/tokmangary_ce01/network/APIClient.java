package com.garytokman.tokmangary_ce01.network;

// Gary Guerman Tokman
// JAV2 - 1609
// APIClient

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIClient extends AsyncTask<String, Integer, String> {

    private static final String TAG = "ApiClient";

    public interface UpdateUIWithJson {
        public void parseJson(String json);
    }

    private Context mContext;
    private ProgressDialog mProgressDialog;
    private UpdateUIWithJson mUpdateUIWithJson;
    private String mBaseUrl = "https://api.github.com/search/repositories?q=";

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

        HttpURLConnection httpURLConnection = null;
        Log.d(TAG, "doInBackground: " + mBaseUrl + strings[0]);
        // Get Json
        try {
            URL url = new URL(mBaseUrl + strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();

            String data = IOUtils.toString(inputStream);
            inputStream.close();

            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpURLConnection.disconnect();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        // Notify
        mUpdateUIWithJson.parseJson(data);
        mProgressDialog.hide();
    }
}
