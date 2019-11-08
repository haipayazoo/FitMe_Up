package com.example174.fitmeup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// import features needed to make a button
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

/*

this is what your initial class statement should look like!!
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainMenuButtons();
        // need this function for buttons to work.
    }

    public void mainMenuButtons() {

        first_button_function();
        second_button_function();
        third_button_function();
        fourth_button_function();
        fifth_button_function();
        exit_button_function();
        recommended_Button();

    } // end of addListenerOnButton()

    public void first_button_function() {
        // Locate the button in activity_main.xml
        Button button1java = (Button) findViewById(R.id.button1);

        // Capture button clicks
        button1java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(MainActivity.this, stepCounter.class);
                startActivity(stepIntent);

            }
        });
    } // end of first_button_function();

    public void second_button_function() {
        // Locate the button in activity_main.xml
        Button button2java = (Button) findViewById(R.id.button2);

        // Capture button clicks
        button2java.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Start EatHealthy.class
                Intent myIntent =
                        new Intent(MainActivity.this, EatHealthy.class);
                startActivity(myIntent);

            }

        });

    } // end of second_button_function();

    public void third_button_function() { // this function should load a new activity

        // Locate the button in activity_main.xml
        Button button3 = (Button) findViewById(R.id.button3);

        // Capture button clicks
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(myIntent);
            }
        });

    } // end of third_button_function();

    //Map button
    public void fourth_button_function() {

        // Locate the button in activity_main.xml
        Button button4 = (Button) findViewById(R.id.button4);

        // Capture button clicks
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Search for gyms nearby
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=gyms");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    } // end of fourth_button_function();

    public void fifth_button_function() {
        Button button5java = (Button) findViewById(R.id.button5);
        button5java.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("https://aongkoputro92.wixsite.com/fitmeup"));
                startActivity(browserIntent);

            }

        });
    } // end of fifth_button_function();

    public void exit_button_function() {
        // Locate the button in activity_main.xml
        Button exitButtonjava = (Button) findViewById(R.id.button6);

        // Capture button clicks
        exitButtonjava.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                finish();
                System.exit(0);
            }
        });
    } // end of first_button_function();

    public void recommended_Button() { // this function should load a new activity

        // Locate the button in activity_main.xml
        Button button3 = (Button) findViewById(R.id.button7);

        // Capture button clicks
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, RecommendedExerciseActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
