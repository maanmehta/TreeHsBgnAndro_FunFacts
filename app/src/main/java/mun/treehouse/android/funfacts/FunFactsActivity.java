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


    private TextView mFunFact;
    private Button mShowFunFactButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // get views from layout by java.lang.Stringid
        mFunFact = (TextView) findViewById(R.id.factTextView);
        mShowFunFactButton = (Button) findViewById(R.id.showNextFunFactButton);
        mRelativeLayout = (RelativeLayout)  findViewById(R.id.topRL);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] facts = {
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


                int[] colors = {
                        Color.GRAY,
                        Color.BLUE,
                        Color.DKGRAY,
                        Color.RED,
                        Color.MAGENTA,
                        Color.BLACK
                };

                String fact = "";

                Random randomGen = new Random();
                int randonNumberForFacts = randomGen.nextInt(facts.length);
                int randonNumberForColors = randomGen.nextInt(colors.length);
                mFunFact.setText(facts[randonNumberForFacts]);
                mRelativeLayout.setBackgroundColor(colors[randonNumberForColors]);
                mShowFunFactButton.setTextColor(colors[randonNumberForColors]);

            }
        };

        mShowFunFactButton.setOnClickListener(buttonListener);
        Toast.makeText(FunFactsActivity.this, "Yay! We have created a ne Activity", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Logging from the onCreate method");

    }
}
