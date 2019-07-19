package com.sandra.turtle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * creation par sandra le 19/07/19
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {
    private NagerView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView =  new NagerView(this);
        setContentView(gameView);
    }
}
