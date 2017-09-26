package com.example.alice.blackjack.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alice.blackjack.R;
import com.example.alice.blackjack.activities.PlayerOneNameActivity;

public class WelcomeActivity extends AppCompatActivity {
    Button hiLowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        hiLowButton = (Button) findViewById(R.id.hi_low_button);

    }

    public void onHiLoButtonPress(View button){
        Intent intent = new Intent(this, PlayerOneNameActivity.class);
        startActivity(intent);
    }
}
