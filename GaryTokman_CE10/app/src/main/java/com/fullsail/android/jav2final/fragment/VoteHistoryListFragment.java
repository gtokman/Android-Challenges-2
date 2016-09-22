package com.fullsail.android.jav2final.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fullsail.android.jav2final.R;
import com.fullsail.android.jav2final.data.Politician;
import com.fullsail.android.jav2final.data.VoteInfo;
import com.fullsail.android.jav2final.tasks.GetVoteInfoTask;
import com.fullsail.android.jav2final.util.SettingsHelper;

import java.util.ArrayList;


public class VoteHistoryListFragment extends ListFragment implements GetVoteInfoTask.VoteInfoDownloadListener {

    public static final String TAG = "VoteHistoryListFragment.TAG";

    private static final String ARG_POLITICIAN = "VoteHistoryListFragment.ARG_POLITICIAN";

    public static VoteHistoryListFragment newInstance(Politician politician) {
        VoteHistoryListFragment frag = new VoteHistoryListFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_POLITICIAN, politician);

        frag.setArguments(bundle);

        return frag;
    }

    public interface VoteSelectedListener {
        void onVoteSelected(int voteId);
    }

    private GetVoteInfoTask mTask;
    private Politician mPolitician;
    private VoteSelectedListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (VoteSelectedListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setEmptyText(getString(R.string.no_data_to_display));

        Bundle args = getArguments();
        if(args != null) {
            mPolitician = (Politician)args.getSerializable(ARG_POLITICIAN);
            startTask();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        stopTask();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        VoteInfo info = (VoteInfo)l.getAdapter().getItem(position);
        if(mListener != null) {
            mListener.onVoteSelected(info.getId());
        }
    }

    private void startTask() {
        stopTask();

        mTask = new GetVoteInfoTask(this);
        mTask.execute(mPolitician.getId());
    }

    private void stopTask() {
        if(mTask != null) {
            mTask.cancel(false);
            mTask = null;
        }
    }

    public void handleVoteInfoData(ArrayList<VoteInfo> info) {
        if(info == null) {
            info = new ArrayList<>();
        }

        ListAdapter adapter;
        if(SettingsHelper.getListType(getActivity()) == SettingsHelper.LIST_TYPE_DETAILED) {
            adapter = new VoteHistoryAdapter(getActivity(), info);
        } else {
            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, info);
        }
        setListAdapter(adapter);
    }

    private static class VoteHistoryAdapter extends BaseAdapter {

        private static final int ID_CONSTANT = 0x20202020;

        private Context mContext;
        private ArrayList<VoteInfo> mVotes;

        public VoteHistoryAdapter(Context context, ArrayList<VoteInfo> votes) {
            mContext = context;
            mVotes = votes;
        }

        @Override
        public int getCount() {
            return mVotes.size();
        }

        @Override
        public VoteInfo getItem(int position) {
            return mVotes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return ID_CONSTANT + position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.vote_info_list_item, parent, false);
            }

            VoteInfo info = getItem(position);

            TextView tv = (TextView)convertView.findViewById(R.id.question);
            tv.setText(info.getQuestion());

            tv = (TextView)convertView.findViewById(R.id.vote);
            tv.setText(info.getVote());

            return convertView;
        }

    }
}
