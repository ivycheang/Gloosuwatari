package com.example.android.gloosuwatari;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.lang.Math;

import static java.lang.Math.abs;

public class Direction extends AppCompatActivity {

    float x, y = 0;
    int width, height;
    Random rand = new Random();
    int fat = 160;
    int halffat = fat / 2;
    public int clickCount = 0;
    boolean found = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        TextView hintTextView = (TextView) findViewById(R.id.hintTextView);

        final float glooX = rand.nextFloat();
        final float glooY = rand.nextFloat();

        //---------------------------------------
        // THE ACTUAL MECHANICS LOLLL
        //---------------------------------------
        final TextView blackTextView = (TextView) findViewById(R.id.blackTextView);
        blackTextView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    x = event.getX();
                    y = event.getY();

                    // Go to congrats page
                    if (found == true) {
                        Intent win = new Intent(getBaseContext(), Win.class);
                        win.putExtra("clickCount", clickCount);
                        win.putExtra("Mode", 2);
                        startActivity(win);
                    }

                    // Direction game play and hint
                    TextView hintTextView = (TextView) findViewById(R.id.hintTextView);
                    ImageView glooImageView = (ImageView) findViewById(R.id.gloo);

                    width = blackTextView.getWidth();
                    height = blackTextView.getHeight();

                    float GlooX = glooX * (width - fat) + halffat;
                    float GlooY = glooY * (height - fat) + halffat;

                    double dist = Math.sqrt(
                            Math.pow((x - GlooX), 2.0) +
                                    Math.pow((y - GlooY), 2.0));

                    double xdist = x - GlooX;
                    double ydist = y - GlooY;
                    float dir = rand.nextFloat();

                    if (dist <= halffat) {
                        hintTextView.setText("You got it!\n"
                                + "click:" + x + "," + y +
                                "\n Gloo:" + GlooX + "," + GlooY);
                        glooImageView.setX(GlooX - halffat);
                        glooImageView.setY(GlooY - halffat);
                        glooImageView.getLayoutParams().height = fat + 10;
                        glooImageView.getLayoutParams().width = fat + 10;
                        glooImageView.setImageResource(R.drawable.gloo);
                        blackTextView.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.white));
                        found = true;
                    } else if (dir <= 0.5 && abs(xdist) > 50) {
                        if (xdist >= 0) {
                            hintTextView.setText("Go a bit left.");
                        } else {
                            hintTextView.setText("Maybe more to the right.");
                        }
                    } else {
                        if (abs(ydist) <= 50) {
                            if (xdist >= 0) {
                                hintTextView.setText("Go a bit left.");
                            } else {
                                hintTextView.setText("Maybe more to the right.");
                            }
                        } else if (ydist >= 0) {
                            hintTextView.setText("Just a bit higher..");
                        } else {
                            hintTextView.setText("Go lower.");
                        }
                    }
                    clickCount++;
                }
                return true;
            }
        });

    }


    int wrong = 0;

    public void wrongClicky(View view) {
        if (found == true) {
            Intent win = new Intent(getBaseContext(), Win.class);
            win.putExtra("clickCount", clickCount);
            startActivity(win);
        } else {
            TextView hintTextView = (TextView) findViewById(R.id.hintTextView);
            if (wrong == 0) {
                hintTextView.setText("Click in the black area to find Gloosuwatari.");
            }
            if (wrong == 1) {
                hintTextView.setText("It's not here.");
            }
            if (wrong == 2) {
                hintTextView.setText("Nope.");
            }
            if (wrong == 3) {
                hintTextView.setText("...");
            }
            if (wrong == 4) {
                hintTextView.setText("Don't touch me that way..");
            }
            if (wrong == 5) {
                Intent crash = new Intent(this, Crash.class);
                startActivity(crash);
            }
            wrong++;
            wrong = wrong % 6;
        }
    }

}
