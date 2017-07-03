package com.example.android.gloosuwatari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void toIntro(View view) {
        Intent intro = new Intent(this, Intro.class);
        startActivity(intro);
    }
}
