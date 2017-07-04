package com.example.android.gloosuwatari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Levels extends AppCompatActivity {

    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        mode = getIntent().getIntExtra("Mode", 0);
        TextView title = (TextView) findViewById(R.id.title);

        if (mode == 1) {
            title.setText("<< Normal >>");
        } else if (mode == 2) {
            title.setText("<< Direction >>");
        } else {
            Intent crash = new Intent(this, Crash.class);
            startActivity(crash);
        }
    }

    public void toGame(View view) {
        TextView level1 = (TextView) findViewById(R.id.level_1);
        TextView level2 = (TextView) findViewById(R.id.level_2);
        TextView level3 = (TextView) findViewById(R.id.level_3);
        TextView level4 = (TextView) findViewById(R.id.level_4);
        TextView liar = (TextView) findViewById(R.id.liar);
        Intent game;

        if (mode == 1) {
            game = new Intent(this, Normal.class);
        } else if (mode == 2) {
            game = new Intent(this, Direction.class);
        } else {
            game = new Intent(this, Crash.class);
            startActivity(game);
        }

        if (view == level1) {
            game.putExtra("Level", 1);
        } else if (view == level2) {
            game.putExtra("Level", 2);
        } else if (view == level3) {
            game.putExtra("Level", 3);
        } else if (view == level4) {
            game.putExtra("Level", 4);
        } else if (view == liar) {
            game.putExtra("Level", 5);
        } else {
            game = new Intent(this, Crash.class);
        }

        startActivity(game);
    }

    public void toModes(View view) {
        Intent modes = new Intent(getBaseContext(), Modes.class);
        startActivity(modes);
    }
}
