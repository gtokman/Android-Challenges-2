package com.fullsail.android.jav2final.tasks;

import android.os.AsyncTask;

import com.fullsail.android.jav2final.data.Vote;
import com.fullsail.android.jav2final.util.VoteHelper;


public class GetSingleVoteTask extends AsyncTask<Integer, Void, Vote> {

    public interface VoteDownloadListener {
        void handleVoteData(Vote vote);
    }

    private VoteDownloadListener mListener;

    public GetSingleVoteTask(VoteDownloadListener listener) {
        mListener = listener;
    }

    @Override
    protected Vote doInBackground(Integer... params) {

        int voteId = params[0];

        return VoteHelper.getVoteForId(voteId);
    }

    @Override
    protected void onPostExecute(Vote vote) {
        super.onPostExecute(vote);

        if(mListener != null) {
            mListener.handleVoteData(vote);
        }
    }
}
