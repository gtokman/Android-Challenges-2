package com.garytokman.tokmangary_ce02.Fragments;

// Gary Guerman Tokman
// JAVA 2 1609
// FootballPlayerFragment

import android.util.Log;
import android.view.View;

import com.garytokman.tokmangary_ce02.Model.FootballPlayer;
import com.garytokman.tokmangary_ce02.R;

public class FootballPlayerFragment extends AthleteFragment {
    @Override
    public String getCustomHintText() {
        return "Number of Touchdowns";
    }

    private void getTextFieldValuesFoottBall() {
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
            FootballPlayer footballPlayer =
                    new FootballPlayer(name, position, Integer.parseInt(age), Integer.parseInt(custom));
            mAthletes.add(footballPlayer);

            // Save
            saveAthleteList();
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if (view.getId() == R.id.save_button) {
            Log.d(TAG, "onClick: Football Click");
            getTextFieldValuesFoottBall();
            clearTextFields();
        }
    }

}
