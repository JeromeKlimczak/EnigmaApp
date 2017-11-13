package com.enigma.enigmaapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    public final static String MISSIONNAME = "com.enigma.enigmaapp.MISSIONNAME";

    private Button bt_Mission1;
    private Button bt_Mission2;
    private Button bt_Mission3;
    private Button bt_Mission4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_layout);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        // Le premier paramètre est le nom de l'activité actuelle
        // Le second est le nom de l'activité de destination
        Intent secondActivity = new Intent(MainActivity.this, MenuActivity.class);

        // Puis on lance l'intent !
        startActivity(secondActivity);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        return true;

    }
}
