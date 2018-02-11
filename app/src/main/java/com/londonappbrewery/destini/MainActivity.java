package com.londonappbrewery.destini;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonDown;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            savedInstanceState.getInt("StoryKey");
        } else {
            mStoryIndex = 1;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonDown = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //When the top button, displaying T1_Ans1 is clicked, the TextView needs to change to display T3_Story.
            // The top button then changes to display T3_Ans1 and the bottom button needs to display T3_Ans2
                if (mButtonTop.getText()== getString(R.string.T1_Ans1)){
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonDown.setText(R.string.T3_Ans2);
                    mStoryIndex += 1;
                } else if (mButtonTop.getText()== getString(R.string.T3_Ans1)){
                    mStoryTextView.setText(R.string.T6_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonDown.setVisibility(View.GONE);
                } if (mButtonTop.getText()== getString(R.string.T2_Ans1)) {
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonDown.setText(R.string.T3_Ans2);
                    mStoryIndex += 1;
                }
           }

        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //the user clicks the bottom button that displays T1_Ans2, your TextView needs to update to display T2_Story.
            //The top button should display T2_Ans1 and the bottom button should display T2_Ans2.
                if (mButtonDown.getText() == getString(R.string.T1_Ans2)){
                    mStoryTextView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonDown.setText(R.string.T2_Ans2);
                    mStoryIndex += 1;
                } else if (mButtonDown.getText() == getString(R.string.T2_Ans2)){
                    mStoryTextView.setText(R.string.T4_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonDown.setVisibility(View.GONE);

                } else if (mButtonDown.getText() == getString(R.string.T3_Ans2)){
                    mStoryTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonDown.setVisibility(View.GONE);
                }
            }
        });

    }

    public void onSavedInstanceState(Bundle outState){
        outState.putInt("StoryIndex", mStoryIndex);
    }
}
