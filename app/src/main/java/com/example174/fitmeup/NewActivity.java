 package com.example174.fitmeup;

        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
        import android.widget.Button;
        import android.net.Uri;

        import com.example174.fitmeup.R;


 public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        first_button_function();
        second_button_function();
        third_button_function();
        fourth_button_function();
    }


    public void first_button_function() {
        // Locate the button in activity_main.xml
        Button mealLink = (Button) findViewById(R.id.mealsButton);
        //final Context context = this;

        // Capture button clicks
        mealLink.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent mealIntent = new Intent(NewActivity.this, FoodItem.class);
                startActivity(mealIntent);

            }
        });
    } // end of first_button_function();

    public void second_button_function() {
        // Locate the button in activity_main.xml
        Button excerciseButton = (Button) findViewById(R.id.excercisexml);
        //final Context context = this;

        // Capture button clicks
        excerciseButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
              Intent exerciseIntent = new Intent(NewActivity.this, Exercise.class);
              startActivity(exerciseIntent);

            }
        });
    } // end of first_button_function();

     public void third_button_function() {
         // Locate the button in activity_main.xml
         Button regimenButton = (Button) findViewById(R.id.button15);
         //final Context context = this;

         // Capture button clicks
         regimenButton.setOnClickListener(new View.OnClickListener() {

             public void onClick(View arg0) {

                 // Start NewActivity.class
                 Intent exerciseIntent = new Intent(NewActivity.this, WeightRegimine.class);
                 startActivity(exerciseIntent);

             }
         });
     } // end of first_button_function();

     public void fourth_button_function() {
         // Locate the button in activity_main.xml
         Button trackerButton = (Button) findViewById(R.id.button14);
         //final Context context = this;

         // Capture button clicks
         trackerButton.setOnClickListener(new View.OnClickListener() {

             public void onClick(View arg0) {

                 // Start NewActivity.class
                 Intent exerciseIntent = new Intent(NewActivity.this, WeightTracker.class);
                 startActivity(exerciseIntent);

             }
         });
     } // end of first_button_function();
}