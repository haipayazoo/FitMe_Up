package com.example174.fitmeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecommendedExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_exercise);

        exercise_Buttons();
    }

    public void exercise_Buttons(){
        chest_button();
        back_button();
        arms_button();
        legs_button();
    }

    public void chest_button(){
        // Locate the button in activity_main.xml
        Button button1java = (Button) findViewById(R.id.button8);

        // Capture button clicks
        button1java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(RecommendedExerciseActivity.this, chest.class);
                startActivity(stepIntent);
            }
        });
    }

    public void back_button(){
        // Locate the button in activity_main.xml
        Button button2java = (Button) findViewById(R.id.button10);

        // Capture button clicks
        button2java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(RecommendedExerciseActivity.this, back.class);
                startActivity(stepIntent);
            }
        });
    }

    public void arms_button(){
        // Locate the button in activity_main.xml
        Button button3java = (Button) findViewById(R.id.button12);

        // Capture button clicks
        button3java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(RecommendedExerciseActivity.this, arms.class);
                startActivity(stepIntent);
            }
        });
    }

    public void legs_button(){
        // Locate the button in activity_main.xml
        Button button4java = (Button) findViewById(R.id.button11);

        // Capture button clicks
        button4java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(RecommendedExerciseActivity.this, Legs.class);
                startActivity(stepIntent);
            }
        });
    }
}
