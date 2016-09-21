package com.fullsail.android.jav2final.tasks;

import android.os.AsyncTask;

import com.fullsail.android.jav2final.data.VoteInfo;
import com.fullsail.android.jav2final.util.VoteInfoHelper;

import java.util.ArrayList;


public class GetVoteInfoTask extends AsyncTask<Integer, Void, ArrayList<VoteInfo>> {

    public interface VoteInfoDownloadListener {
        void handleVoteInfoData(ArrayList<VoteInfo> info);
    }

    private VoteInfoDownloadListener mListener;

    public GetVoteInfoTask(VoteInfoDownloadListener listener) {
        mListener = listener;
    }

    @Override
    protected ArrayList<VoteInfo> doInBackground(Integer... params) {

        int politicianId = params[0];

        return VoteInfoHelper.getVoteHistory(politicianId);
    }

    @Override
    protected void onPostExecute(ArrayList<VoteInfo> voteInfo) {
        super.onPostExecute(voteInfo);

        if(mListener != null) {
            mListener.handleVoteInfoData(voteInfo);
        }
    }
}
