package com.example.colors;

import android.graphics.Color;
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
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        label = findViewById(R.id.label);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);

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
        green.setTextColor(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255)));
        blue.setTextColor(Color.rgb(Math.abs(redVal-255),Math.abs(greenVal-255), Math.abs(blueVal-255)));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("redVal",redVal);
        outState.putInt("greenVal",greenVal);
        outState.putInt("blueVal",blueVal);
        outState.putBoolean("red", red.isChecked());
        outState.putBoolean("green", green.isChecked());
        outState.putBoolean("blue", blue.isChecked());
//        Log.d(LOG_TAG, "onSaveInstanceState");
    }

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
//        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

}
