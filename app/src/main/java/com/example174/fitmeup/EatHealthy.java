package com.example174.fitmeup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;


public class EatHealthy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_healthy);

        eatingHealthyButtons();
    }


    public void eatingHealthyButtons() {
        protein_button();
        carbs_button();
        veggies_button();
        fruits_button();
        diettipssugg_button();
    }


    public void protein_button(){
        // Locate the button in activity_main.xml
        Button button1java = (Button) findViewById(R.id.proteinB);

        // Capture button clicks
        button1java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(EatHealthy.this, proteinSPC.class);
                startActivity(stepIntent);
            }
        });
    }


    public void carbs_button(){
        // Locate the button in activity_main.xml
        Button button1java = (Button) findViewById(R.id.carbsB);

        // Capture button clicks
        button1java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(EatHealthy.this, carbsSPC.class);
                startActivity(stepIntent);
            }
        });
    }


    public void veggies_button(){

        // Locate the button in activity_main.xml
        Button button1java = (Button) findViewById(R.id.veggiesB);

        // Capture button clicks
        button1java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(EatHealthy.this, veggiesSPC.class);
                startActivity(stepIntent);
            }
        });
    }


    public void fruits_button(){

        // Locate the button in activity_main.xml
        Button button1java = (Button) findViewById(R.id.fruitsB);

        // Capture button clicks
        button1java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(EatHealthy.this, fruitsSPC.class);
                startActivity(stepIntent);
            }
        });
    }


    public void diettipssugg_button(){

        // Locate the button in activity_main.xml
        Button button1java = (Button) findViewById(R.id.tipssugB);

        // Capture button clicks
        button1java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent stepIntent = new Intent(EatHealthy.this, tipssugSPC.class);
                startActivity(stepIntent);
            }
        });
    }


}
