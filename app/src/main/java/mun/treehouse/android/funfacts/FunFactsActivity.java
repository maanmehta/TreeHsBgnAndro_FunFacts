package mun.treehouse.android.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";


    private TextView mFunFact;
    private Button mShowFunFactButton;
    private RelativeLayout mRelativeLayout;

    private static final String[] mFacts = {
            "First things First",
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built." };

    private String randomFact = mFacts[0];


    private static final int[] colors = {
            Color.BLACK,
            Color.GRAY,
            Color.BLUE,
            Color.DKGRAY,
            Color.RED,
            Color.MAGENTA
    };
    private int randomColor = colors[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);


        // get views from layout by java.lang.Stringid
        mFunFact = (TextView) findViewById(R.id.factTextView);
        mShowFunFactButton = (Button) findViewById(R.id.showNextFunFactButton);
        mRelativeLayout = (RelativeLayout)  findViewById(R.id.topRL);

        mShowFunFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randomGen = new Random();

                //get random fact from array
                int randomNumberForFacts = randomGen.nextInt(mFacts.length);
                randomFact = mFacts[randomNumberForFacts];

                //get random color from array
                int randomNumberForColors = randomGen.nextInt(colors.length);
                randomColor = colors[randomNumberForColors];

                // call updateUI method to update UI with fun fact and background color
                updateUI();


            }
        });

        Toast.makeText(FunFactsActivity.this, "Yay! We have created a new Activity", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"***** onCreate method ended");

    }

    private void updateUI() {
        // set or update three things in the view -
        // 1) Text of the fun fact
        // 2) Background Color of the RelativeLayout (screen)
        // 3) Color of the text of the button
        mFunFact.setText(randomFact);
        mRelativeLayout.setBackgroundColor(randomColor);
        mShowFunFactButton.setTextColor(randomColor);
    }

    /**
     * This method is called after {@link #onStart} when the activity is
     * being re-initialized from a previously saved state, given here in
     * <var>savedInstanceState</var>.  Most implementations will simply use {@link #onCreate}
     * to restore their state, but it is sometimes convenient to do it here
     * after all of the initialization has been done or to allow subclasses to
     * decide whether to use your default implementation.  The default
     * implementation of this method performs a restore of any view state that
     * had previously been frozen by {@link #onSaveInstanceState}.
     * <p/>
     * <p>This method is called between {@link #onStart} and
     * {@link #onPostCreate}.
     *
     * @param savedInstanceState the data most recently supplied in {@link #onSaveInstanceState}.
     * @see #onCreate
     * @see #onPostCreate
     * @see #onResume
     * @see #onSaveInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        randomFact = savedInstanceState.getString(KEY_FACT);
        randomColor = savedInstanceState.getInt(KEY_COLOR);

        // call updateUI method to update UI with the last restored fun fact text and
        // restored background color
        updateUI();
    }

    // save the state of the app - we want to save the current random fun fact text
    // and current background color
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT,randomFact);
        outState.putInt(KEY_COLOR,randomColor);
    }
}
