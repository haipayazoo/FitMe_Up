package com.example174.fitmeup;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.R.attr.centerY;

public class FoodItem extends NewActivity  {

    private EditText mInput;
    private EditText mCal;
    private TableLayout mTable;
    private Button addButton;
    private static int sCount = 0;

    private TextView itemBox;
    private int totalItems = 0;

    private TextView caloriesBox;
    private int totalCalories = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item);

        addButton = (Button) findViewById(R.id.add);
        mInput = (EditText) findViewById(R.id.enterFoodItem);
        mCal = (EditText) findViewById(R.id.enterCalories);
        itemBox = (TextView) findViewById(R.id.totalItems);
        caloriesBox = (TextView) findViewById(R.id.Calzone);

        mTable = (TableLayout) findViewById(R.id.table1);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTable.addView(addRow(mInput.getText().toString(), Integer.parseInt(String.valueOf(mCal.getText()))));
            }
        });
    }

    public int getNumberMeals() {
        return totalItems;
    }

    public void addOneMeal() {
        totalItems = totalItems + 1;
    }

    public void deleteOneMeal() {
        totalItems = totalItems - 1;
    }

    public int getNumberCalories() {
        return totalCalories;
    }

    public void addCal( int cal ) {
        totalCalories = totalCalories + cal;
    }

    public void deleteCal( int value ) {
        totalCalories = totalCalories - value;
    }

    private TableRow addRow(String foodName, int Calories) {
        TableRow tr = new TableRow(this);
        tr.setId(1000 + sCount);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        TableRow.LayoutParams blparams = new TableRow.LayoutParams(
                150,
                TableRow.LayoutParams.WRAP_CONTENT);
        final Button button = new Button(this);
        button.setLayoutParams(blparams);
        button.setText(" - ");
        button.setId(2000 + sCount);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                deleteCal(1);
                mTable.removeView(findViewById(v.getId() - 1000));
                deleteOneMeal();
                itemBox.setText(String.valueOf(getNumberMeals()));

            }
        });
        tr.addView(button);


        TableRow.LayoutParams tlparams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TextView foodText = new TextView(this);
        foodText.setLayoutParams(tlparams);
        foodText.setText("" + foodName);
        foodText.setTypeface(null, Typeface.BOLD);
        foodText.setTextColor(Color.parseColor("#FFFFFF"));
        tr.addView(foodText);


        TableRow.LayoutParams calparams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TextView calText = new TextView(this);
        calText.setLayoutParams(calparams);
        calText.setText("" + Calories);
        calText.setGravity(Gravity.CENTER);
        calText.setTypeface(null, Typeface.BOLD);
        calText.setTextColor(Color.parseColor("#FFFFFF"));

        tr.addView(calText);

        addOneMeal();
        itemBox.setText(String.valueOf(getNumberMeals()));

        addCal(Calories);
        caloriesBox.setText(String.valueOf(getNumberCalories()));

        sCount++;
        return tr;
    }
}