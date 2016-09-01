package com.garytokman.tokmangary_ce02.Fragments;

// Gary Guerman Tokman
// JAVA 2 1609
// BasketballPlayerFragment

import android.util.Log;
import android.view.View;

import com.garytokman.tokmangary_ce02.Model.BasketballPlayer;
import com.garytokman.tokmangary_ce02.R;

public class BasketballPlayerFragment extends AthleteFragment {
    @Override
    public String getCustomHintText() {
        return "Number of 3 pointers";
    }

    private void getTextFieldValuesBasketBall() {
        // Do something
        Log.d(TAG, "onClick: Clicked Save!!!!!!");
        String name = getText(mNameEditText);
        String position = getText(mPositionEditText);
        String age = getText(mAgeEditText);
        String custom = getText(mCustomEditText);
        Log.d(TAG, "Name: " + name + " position: " + position + " age: " + age + " cust: " + custom);

        if ((name != null || position != null || age != null || custom != null) &&
                (name != null && position != null && age != null && custom != null)) {
            // Create Athlete
            BasketballPlayer basketBallPlayer =
                    new BasketballPlayer(name, position, Integer.parseInt(age), Integer.parseInt(custom));
            mAthletes.add(basketBallPlayer);

            // Save
            saveAthleteList();
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if (view.getId() == R.id.save_button) {
            Log.d(TAG, "onClick: Basketball Click");
            getTextFieldValuesBasketBall();
            clearTextFields();
        }
    }

}
