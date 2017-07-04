package com.example.android.gloosuwatari;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        int clickCount = getIntent().getIntExtra("clickCount", 0);
        TextView congratsTextView = (TextView) findViewById(R.id.congrats);

        if (clickCount == 0) {
            congratsTextView.setText("Uh..... we are dealing with some kinda of technical difficulty... Or you are a God, one of the above...");
        } else if (clickCount == 1) {
            congratsTextView.setText("HOLE IN ONE!!\nNow aren't YOU a lucky one? Ever consider buying lottery?");
        } else if (clickCount < 5) {
            congratsTextView.setText("You did it in " + clickCount + " tries!\nAmazing!!");
        } else if (clickCount == 5) {
            congratsTextView.setText("You did it in " + clickCount + " tries.\nYou are good at this ya da ya da ya da ya da...\nIf you are so good, see if you can find the hidden button on the modes page.");
        } else if (clickCount <= 10) {
            congratsTextView.setText("You did it in " + clickCount + " tries!\nGreat job!");
        } else if (clickCount <= 20) {
            congratsTextView.setText("You did it in " + clickCount + " tries.\nNeat.");
        } else if (clickCount <= 40) {
            congratsTextView.setText("You did it in " + clickCount + " tries.\nMaybe try a little harder next time.");
        } else {
            congratsTextView.setText("You did it in " + clickCount + " tries....\nYou don't really have a knack for this do you...");
        }
    }

    public void toStart(View view) {
        Intent start = new Intent(this, Start.class);
        startActivity(start);
    }

    public void toGame(View view) {
        int mode = getIntent().getIntExtra("Mode", 0);
        Intent game;
        if (mode == 1) {
            game = new Intent(this, Normal.class);
        } else if (mode == 2) {
            game = new Intent(this, Direction.class);
        } else {
            game = new Intent(this, Crash.class);
        }

        game.putExtra("Level", getIntent().getIntExtra("Level", 0));
        startActivity(game);
    }
}
