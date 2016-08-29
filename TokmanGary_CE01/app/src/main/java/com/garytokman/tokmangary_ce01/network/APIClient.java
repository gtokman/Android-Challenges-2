package com.garytokman.tokmangary_ce01.network;

// Gary Guerman Tokman
// JAV2 - 1609
// APIClient

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class APIClient extends AsyncTask<String, Integer, String> {

    public interface UpdateUIWithJson {
        public void parseJson(String json);
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
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

    }

    @Override
    protected String doInBackground(String... strings) {
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
