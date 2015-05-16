package com.example.jpanchol.weight;

import android.graphics.Canvas;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class IdealWeight extends ActionBarActivity {

    private SeekBar seekBar;
    private TextView textView;
    private SeekBar seekBar2;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);

        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        textView2.setText(seekBar2.getProgress() + "/" + seekBar2.getMax());
        seekBar.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {
                    int progress = 0;
                    @Override
                    public void onProgressChanged(SeekBar seekBar,

                                                  int progresValue, boolean fromUser) {
                        progress = progresValue;
                        textView.setText(progress + "");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // Do something here,
                        //if you want to do anything at the start of
                        // touching the seekbar
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // Display the value in textview
                        //textView.setText(progress);

                    }
                });

        seekBar2.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {
                    int progress = 0;
                    @Override
                    public void onProgressChanged(SeekBar seekBar2,

                                                  int progresValue, boolean fromUser) {
                        progress = progresValue;
                        //Integer Getprog = seekBar2.getProgress();
                        textView2.setText(progress + "");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // Do something here,
                        //if you want to do anything at the start of
                        // touching the seekbar
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar2) {
                        // Display the value in textview
                        //textView2.setText(progress );
                    }
                });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ideal_weight, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void GetBMI(View view)
    {
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float height = seekBar.getProgress();
                height = height/100;
                float weight = seekBar2.getProgress();
                System.out.print("height " + height + "  Weight  " + weight);
                float BMI = weight / (height * height);
                TextView textView5 = (TextView) findViewById(R.id.textView5
                );
                textView5.setText(BMI + "");

                if(BMI<=18.5) Toast.makeText(getApplicationContext(), "Underweight" , Toast.LENGTH_LONG).show();
                if(BMI>18.5 && BMI<=24.9) Toast.makeText(getApplicationContext(), "Normal Weight" , Toast.LENGTH_LONG).show();
                if(BMI>25 && BMI<=29.9) Toast.makeText(getApplicationContext(), "Overweight" , Toast.LENGTH_LONG).show();
                if(BMI>=30) Toast.makeText(getApplicationContext(), "Obese" , Toast.LENGTH_LONG).show();

            }


        });
    }

    }
