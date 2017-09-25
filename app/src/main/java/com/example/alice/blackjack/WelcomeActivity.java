package com.example.alice.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
