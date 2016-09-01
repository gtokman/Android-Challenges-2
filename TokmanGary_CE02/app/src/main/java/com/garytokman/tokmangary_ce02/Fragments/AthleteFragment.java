package com.garytokman.tokmangary_ce02.Fragments;

import android.text.Editable;
import android.util.Log;
import android.view.View;

import com.garytokman.tokmangary_ce02.Model.BasketballPlayer;
import com.garytokman.tokmangary_ce02.R;

/**
 * Created by gtokman1 on 9/1/16.
 */
public class AthleteFragment extends ForumFragment {
    @Override
    protected String getCustomHintText() {
        return null;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_button:
                // Do something
                Log.d(TAG, "onClick: Clicked Save!!!!!!");
                String name = getText(mNameEditText);
                String position = getText(mPositionEditText);
                String age = getText(mAgeEditText);
                String custom = getText(mCustomEditText);

                // Create Athlete
                BasketballPlayer basketBallPlayer =
                        new BasketballPlayer(name, position, Integer.parseInt(age), Integer.parseInt(custom));
                mAthletes.add(basketBallPlayer);

                Log.d(TAG, "Name: " + name + " position: " + position + " age: " + age + " cust: " + custom);
                break;
            default:
                break;
        }
    }
}
