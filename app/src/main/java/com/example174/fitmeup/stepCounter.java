package com.example174.fitmeup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class stepCounter extends Activity implements SensorEventListener {

    TextView tv_steps;
    TextView tv_calories;

    Button resetButton;
    Button pauseButton;
    Button resumeButton;

    SensorManager sensorManager;

    float resetSteps = 0;
    float tempSteps;
    double resetCalories = 0;
    double tempCalories;

    Sensor countSensor;

    boolean running = true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepcounterlayout);

        tv_steps = (TextView) findViewById(R.id.stepText);
        tv_calories = (TextView) findViewById(R.id.caloriesText);
        resetButton = (Button) findViewById(R.id.resetButton);
        pauseButton = (Button) findViewById(R.id.onPause);
        resumeButton = (Button) findViewById(R.id.resumeButton);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSteps = tempSteps;
                resetCalories = tempCalories;
                tv_steps.setText("0.0");
                tv_calories.setText("0.0");
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onPause();
            }
        });

        resumeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onResume();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        if(countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
        sensorManager.unregisterListener(this, countSensor);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this, countSensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running)
            tv_steps.setText(String.valueOf(event.values[0] - resetSteps));
        tempSteps = event.values[0];
        tv_calories.setText(String.format("%.2f", event.values[0]*0.044 - resetCalories));
        tempCalories = event.values[0]*0.044;
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}