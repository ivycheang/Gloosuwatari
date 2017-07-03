package com.example.android.gloosuwatari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Crash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
    }

    public void toStart(View view) {
        Intent start = new Intent(this, Normal.class);
        startActivity(start);
    }

}
