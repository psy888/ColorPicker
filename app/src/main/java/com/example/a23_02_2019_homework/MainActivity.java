package com.example.a23_02_2019_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout main = new LinearLayout(this);

        LinearLayout.LayoutParams mainLP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        main.setOrientation(LinearLayout.VERTICAL);
        //Apply LayoutParams to main LinearLayout
        main.setLayoutParams(mainLP);


        //Create Top FrameLayout
        FrameLayout topFrame = new FrameLayout(this);
        //Create LayoutParams
        LinearLayout.LayoutParams frameLayoutLP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int)getResources().getDimension(R.dimen.height0dp),
                1);
        frameLayoutLP.topMargin = (int) getResources().getDimension(R.dimen.main_margin);
        frameLayoutLP.leftMargin = (int) getResources().getDimension(R.dimen.main_margin);
        frameLayoutLP.rightMargin = (int) getResources().getDimension(R.dimen.main_margin);
        topFrame.setBackgroundColor(getResources().getColor(R.color.green));
        //Add View and apply LayoutParams
        main.addView(topFrame,frameLayoutLP);

        //Create Bottom FrameLayout
        FrameLayout bottomFrame = new FrameLayout(this);

        //Create LayoutParams
        LinearLayout.LayoutParams bottomFrameLayoutLP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int)getResources().getDimension(R.dimen.height0dp),
                1);
        bottomFrameLayoutLP.bottomMargin = (int) getResources().getDimension(R.dimen.main_margin);
        bottomFrameLayoutLP.leftMargin = (int) getResources().getDimension(R.dimen.main_margin);
        bottomFrameLayoutLP.rightMargin = (int) getResources().getDimension(R.dimen.main_margin);
        bottomFrame.setBackgroundColor(getResources().getColor(R.color.pink));
        //Add View and apply Layout
        main.addView(bottomFrame,bottomFrameLayoutLP);

        //Create GridLayouts
        GridLayout gridLayoutTop = new GridLayout(this);
        GridLayout gridLayoutBottom = new GridLayout(this);
        //Create LayoutParams
        FrameLayout.LayoutParams gridLayoutLP = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER);
        gridLayoutTop.setColumnCount(2);
        gridLayoutBottom.setColumnCount(2);
        gridLayoutTop.setRowCount(2);
        gridLayoutBottom.setRowCount(2);

        //Add View and apply LayoutParams
        topFrame.addView(gridLayoutTop, gridLayoutLP);
        bottomFrame.addView(gridLayoutBottom, gridLayoutLP);
        for (int i = 0; i < 4; i++) {
            Button b = new Button(this);
            b.setText(""+(i+1));
            gridLayoutTop.addView(b);
        }for (int i = 0; i < 4; i++) {
            Button b = new Button(this);
            b.setText(""+(i+1));
            gridLayoutBottom.addView(b);
        }

        //Set new content View
        setContentView(main);
//        setContentView(R.layout.activity_main);
    }
}
