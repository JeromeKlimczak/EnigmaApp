package com.enigma.enigmaapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MissionActivity extends AppCompatActivity {
    private TextView mTextView;
    private Chronometer mChronometer;
    private Button mButtonPlay;
    private Button mButtonPenalty;
    private Button mButtonCode;
    private boolean isChronoRunning=false;
    private int penaltyDuration=0;
    private int penaltyNb=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        mTextView       =(TextView)     findViewById(R.id.titre);

        mChronometer    =(Chronometer)  findViewById(R.id.chronometer);
        mChronometer.setText("00:00:00");

        mButtonPlay     =(Button)       findViewById(R.id.bt_play);
        mButtonPenalty  =(Button)       findViewById(R.id.bt_penalty);
        mButtonCode     =(Button)       findViewById(R.id.bt_code);

        // On récupère l'intent qui a lancé cette activité
        Intent i = getIntent();

        // Puis on récupère l'âge donné dans l'autre activité, ou 0 si cet extra n'est pas dans l'intent
        int name = i.getIntExtra(MainActivity.MISSIONNAME, 0);

        mTextView.setText("Mission " + name);

        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            long timeWhenStopped;

            @Override
            public void onClick(View v) {
                if (isChronoRunning) {
                    mButtonPlay.setText("Play");
                    timeWhenStopped = mChronometer.getBase() - SystemClock.elapsedRealtime();
                    mChronometer.stop();
                    isChronoRunning=false;
                } else {
                    mButtonPlay.setText("Pause");
                    mChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    mChronometer.start();
                    isChronoRunning=true;
                }
            }
        });

        mButtonPenalty.setOnClickListener(new View.OnClickListener() {
            long timeWhenStopped;

            @Override
            public void onClick(View v) {
                addPenalty();
            }
        });

        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            public void onChronometerTick(Chronometer cArg) {
                long elapsedTime = SystemClock.elapsedRealtime() - cArg.getBase() + penaltyNb*3*60000;
                elapsedTime /= 1000;
                int h = (int)(elapsedTime/3600);
                int min = (int)((elapsedTime-h*3600)/60);
                int sec = (int) (elapsedTime-h*3600-min*60);
                String time = h<10? "0" + h : String.valueOf(h);
                time += ":";
                time += min<10? "0" + min : String.valueOf(min);
                time += ":";
                time += sec<10? "0" + sec : String.valueOf(sec);
                mChronometer.setText(time);
                if (penaltyDuration > 0)penaltyDuration--;
                else  mChronometer.setTextColor(Color.rgb(0,0,255));

            }
        });

        mButtonCode.setOnClickListener(new View.OnClickListener() {
            long timeWhenStopped;

            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(MissionActivity.this, CodeActivity.class);

                startActivityForResult(secondeActivite,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // On vérifie tout d'abord à quel intent on fait référence ici à l'aide de notre identifiant
        if (requestCode == 1) {
            // On vérifie aussi que l'opération s'est bien déroulée
            if (resultCode == -1) {
                // On affiche le bouton qui a été choisi
                addPenalty();
            }
        }
    }

    private void addPenalty() {
        if(isChronoRunning) {
            penaltyNb++;
            penaltyDuration = 3;
            long timeval = SystemClock.elapsedRealtime() - mChronometer.getBase() + penaltyNb * 3 * 60000;
            timeval /= 1000;
            int h = (int) (timeval / 3600);
            int min = (int) ((timeval - h * 3600) / 60);
            int sec = (int) (timeval - h * 3600 - min * 60);
            String time = h < 10 ? "0" + h : String.valueOf(h);
            time += ":";
            time += min < 10 ? "0" + min : String.valueOf(min);
            time += ":";
            time += sec < 10 ? "0" + sec : String.valueOf(sec);
            mChronometer.setText(time);
            mChronometer.setTextColor(Color.rgb(255, 0, 0));
        }
    }
}
