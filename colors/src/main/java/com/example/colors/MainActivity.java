package com.example.colors;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String LOG_TAG = "COLORS :";
    LinearLayout main;
    TextView label;
    CheckBox red, green, blue;
    int redVal,greenVal,blueVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate()");
        if(savedInstanceState!=null)
        {
            Log.d(LOG_TAG, "savedInstanceState.toString()");
            Log.d(LOG_TAG, savedInstanceState.toString());

            savedInstanceState.toString();
        }
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);
        label = findViewById(R.id.label);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);


        if(savedInstanceState != null)
        {
            this.redVal = savedInstanceState.getInt("redVal");
            this.greenVal = savedInstanceState.getInt("greenVal");
            this.blueVal = savedInstanceState.getInt("blueVal");
            this.red.setChecked(savedInstanceState.getBoolean("red"));
            this.green.setChecked(savedInstanceState.getBoolean("green"));
            this.blue.setChecked(savedInstanceState.getBoolean("blue"));
            Log.d(LOG_TAG, "onCreate savedInstanceState != null ");
            setColor();
        }



        red.setOnCheckedChangeListener(this);
        green.setOnCheckedChangeListener(this);
        blue.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId())
        {
            case (R.id.red):
                if(buttonView.isChecked())
                {
                    redVal = 255;
                }
                else
                {
                    redVal = 0;
                }
                break;
            case (R.id.green):
                if(buttonView.isChecked())
                {
                    greenVal = 255;
                }
                else
                {
                    greenVal = 0;
                }
                break;
            case (R.id.blue):
                if(buttonView.isChecked())
                {
                    blueVal = 255;
                }
                else
                {
                    blueVal = 0;
                }
                break;
        }

        setColor();

    }

    private void setColor()
    {
        main.setBackgroundColor(Color.rgb(redVal, greenVal, blueVal));
        label.setTextColor(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255)));
        red.setTextColor(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255)));
//
//            red.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255))));
//            green.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255))));
//            blue.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255))));

        green.setTextColor(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255)));
        blue.setTextColor(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255)));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(LOG_TAG, "onDestroy()");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putInt("redVal",redVal);
        outState.putInt("greenVal",greenVal);
        outState.putInt("blueVal",blueVal);
        outState.putBoolean("red", red.isChecked());
        outState.putBoolean("green", green.isChecked());
        outState.putBoolean("blue", blue.isChecked());
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState");
    }
/*
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        this.redVal = savedInstanceState.getInt("redVal");
        this.greenVal = savedInstanceState.getInt("greenVal");
        this.blueVal = savedInstanceState.getInt("blueVal");
        this.red.setChecked(savedInstanceState.getBoolean("red"));
        this.green.setChecked(savedInstanceState.getBoolean("green"));
        this.blue.setChecked(savedInstanceState.getBoolean("blue"));
        setColor();
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }
*/
}
