package com.example.android.gloosuwatari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.microedition.khronos.opengles.GL;

public class Modes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes);
    }

    public void toLevels(View view) {
        TextView normal = (TextView) findViewById(R.id.normal);
        TextView direction = (TextView) findViewById(R.id.direction);
        Intent level = new Intent(getBaseContext(), Levels.class);

        if (view == normal) {
            level.putExtra("Mode", 1);
        } else if (view == direction) {
            level.putExtra("Mode", 2);
        } else {
            Intent crash = new Intent(getBaseContext(), Crash.class);
            startActivity(crash);
        }

        startActivity(level);
    }

    public void toGloo (View view) {
        Intent gloo = new Intent(getBaseContext(), Gloo.class);
        startActivity(gloo);
    }
}
