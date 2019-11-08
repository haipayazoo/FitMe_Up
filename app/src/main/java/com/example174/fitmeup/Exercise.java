package com.example174.fitmeup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
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

public class Exercise extends NewActivity {

    private EditText mInput;
    private EditText mMin;
    private EditText mSec;
    private TableLayout mTable;
    private Button addButton;
    private static int sCount = 0;
    private TextView itemBox;
    private int totalItems = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        addButton = (Button) findViewById(R.id.addE);
        mInput = (EditText) findViewById(R.id.enterExercise);
        mMin = (EditText) findViewById(R.id.enterMin);
        mSec = (EditText) findViewById(R.id.enterSec);
        //  itemBox = (TextView) findViewById(R.id.totalItems);


        mTable = (TableLayout) findViewById(R.id.table2);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTable.addView(addRow(mInput.getText().toString(), Integer.parseInt(String.valueOf(mMin.getText())), Integer.parseInt(String.valueOf(mSec.getText()))));
            }
        });

    } // end of onCreate function



    private TableRow addRow(String Exercise, int Min, int Sec) {
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
                mTable.removeView(findViewById(v.getId() - 1000));
            }
        });
        tr.addView(button);


        TableRow.LayoutParams tlparams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TextView ExText = new TextView(this);
        ExText.setLayoutParams(tlparams);
        ExText.setText("" + Exercise);
        ExText.setGravity(Gravity.CENTER);
        ExText.setTypeface(null, Typeface.BOLD);
        ExText.setTextColor(Color.parseColor("#FFFFFF"));
        tr.addView(ExText);

        TableRow.LayoutParams calparams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TextView TimeText = new TextView(this);
        TimeText.setLayoutParams(calparams);
        TimeText.setText(Min + ":" + Sec);
        TimeText.setGravity(Gravity.CENTER);
        TimeText.setTypeface(null, Typeface.BOLD);
        TimeText.setTextColor(Color.parseColor("#FFFFFF"));
        tr.addView(TimeText);

        sCount++;
        return tr;
    }
}