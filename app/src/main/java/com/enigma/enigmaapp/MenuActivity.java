package com.enigma.enigmaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends Activity {
    public final static String MISSIONNAME = "com.enigma.enigmaapp.MISSIONNAME";

    private Button bt_Mission1;
    private Button bt_Mission2;
    private Button bt_Mission3;
    private Button bt_Mission4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bt_Mission1 = (Button) findViewById(R.id.bt_mission1);
        bt_Mission2 = (Button) findViewById(R.id.bt_mission2);
        bt_Mission3 = (Button) findViewById(R.id.bt_mission3);
        bt_Mission4 = (Button) findViewById(R.id.bt_mission4);

        bt_Mission1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Le premier paramètre est le nom de l'activité actuelle
                // Le second est le nom de l'activité de destination
                Intent secondeActivite = new Intent(MenuActivity.this, MissionActivity.class);

                // On rajoute un extra
                secondeActivite.putExtra(MISSIONNAME, 1);

                // Puis on lance l'intent !
                startActivity(secondeActivite);
            }
        });


        bt_Mission2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Le premier paramètre est le nom de l'activité actuelle
                // Le second est le nom de l'activité de destination
                Intent secondeActivite = new Intent(MenuActivity.this, MissionActivity.class);

                // On rajoute un extra
                secondeActivite.putExtra(MISSIONNAME, 2);

                // Puis on lance l'intent !
                startActivity(secondeActivite);
            }
        });

        bt_Mission3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Le premier paramètre est le nom de l'activité actuelle
                // Le second est le nom de l'activité de destination
                Intent secondeActivite = new Intent(MenuActivity.this, MissionActivity.class);

                // On rajoute un extra
                secondeActivite.putExtra(MISSIONNAME, 3);

                // Puis on lance l'intent !
                startActivity(secondeActivite);
            }
        });

        bt_Mission4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Le premier paramètre est le nom de l'activité actuelle
                // Le second est le nom de l'activité de destination
                Intent secondeActivite = new Intent(MenuActivity.this, MissionActivity.class);

                // On rajoute un extra
                secondeActivite.putExtra(MISSIONNAME, 4);

                // Puis on lance l'intent !
                startActivity(secondeActivite);
            }
        });
    }
}
