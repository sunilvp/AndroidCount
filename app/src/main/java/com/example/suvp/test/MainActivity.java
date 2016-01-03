package com.example.suvp.test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public final static String NO_ACTION_PERFORMED = "No action performed";
    public final static String ACTION_STARTED = "I am Tracking your Activity";
    public final static String ACTION_STOPED = "Stoped tracking";
    public final static String ZERO_COUNT = "Zero Count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button actionButton = (Button)findViewById(R.id.actionButton);
        final ImageButton leftButton = (ImageButton)findViewById(R.id.leftButton);
        final ImageButton rightButton = (ImageButton)findViewById(R.id.rightButton);
        final ImageButton topButton = (ImageButton)findViewById(R.id.upButton);
        final ImageButton downButton = (ImageButton)findViewById(R.id.downButton);

        //Default Intialization
        final ButtonCount leftButtonCount = new ButtonCount();
        final ButtonCount rightButtonCount = new ButtonCount();
        final ButtonCount topButtonCount = new ButtonCount();
        final ButtonCount downButtonCount = new ButtonCount();

        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
        topButton.setEnabled(false);
        downButton.setEnabled(false);

        final TextView textView = (TextView)findViewById(R.id.displayText);
        final TextView countTextView = (TextView)findViewById(R.id.countText);
        textView.setText(NO_ACTION_PERFORMED);
        countTextView.setText(ZERO_COUNT);
        int leftCount =0;
        Toast.makeText(this, "I will StartMonitoring u", Toast.LENGTH_LONG).show();
        //Centre button action to stop and start the count and update the text field
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().equals(NO_ACTION_PERFORMED)) {
                    textView.setText(ACTION_STARTED);
                    leftButton.setEnabled(true);
                    rightButton.setEnabled(true);
                    topButton.setEnabled(true);
                    downButton.setEnabled(true);
                } else if (textView.getText().equals(ACTION_STARTED)) {
                    textView.setText(ACTION_STOPED);

                    countTextView.setText("Left count: " + leftButtonCount.getCount() + "\n" +
                            "Right count: " + rightButtonCount.getCount() + "\n" +
                            "Top count: " + topButtonCount.getCount() + "\n" +
                            "down count: " + downButtonCount.getCount());

                    Toast.makeText( v.getContext(), "Here are the results", Toast.LENGTH_SHORT).show();
                    leftButtonCount.resetCount();
                    rightButtonCount.resetCount();
                    topButtonCount.resetCount();
                    downButtonCount.resetCount();

                    leftButton.setEnabled(false);
                    rightButton.setEnabled(false);
                    topButton.setEnabled(false);
                    downButton.setEnabled(false);
                } else if (textView.getText().equals(ACTION_STOPED)) {
                    textView.setText(ACTION_STARTED);
                    countTextView.setText(ZERO_COUNT);
                    Toast.makeText( v.getContext(), "Activity Started", Toast.LENGTH_SHORT).show();
                    leftButton.setEnabled(true);
                    rightButton.setEnabled(true);
                    topButton.setEnabled(true);
                    downButton.setEnabled(true);
                }
            }
        });

        //Increase the count for each button
        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                leftButtonCount.increaseCount();
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rightButtonCount.increaseCount();
            }
        });
        topButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                topButtonCount.increaseCount();
            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                downButtonCount.increaseCount();
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if((id) == R.id.menu_item){
            Toast.makeText(this, "Clicked Exit", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
      return super.onOptionsItemSelected(item);
    }
}

/*
* Class to get the no of times each button is clicked.
* Since in inner class only final variables can be used
* Created and class for same and added util methods for same*/
class ButtonCount
{
    int count =0;

    public void increaseCount()
    {
        count++;
    }

    public void resetCount()
    {
        count = 0;
    }

    public int getCount()
    {
        return count;
    }
}
