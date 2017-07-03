package com.example.android.gloosuwatari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import javax.microedition.khronos.opengles.GL;

public class Modes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes);
    }

    public void toNormal(View view) {
        Intent normal = new Intent(getBaseContext(), Normal.class);
        startActivity(normal);
    }

    public void toDirection(View view) {
        Intent direction = new Intent(getBaseContext(), Direction.class);
        startActivity(direction);
    }

    public void toGloo (View view) {
        Intent gloo = new Intent(getBaseContext(), Gloo.class);
        startActivity(gloo);
    }
}
