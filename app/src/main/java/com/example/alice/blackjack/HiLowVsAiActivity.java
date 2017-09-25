package com.example.alice.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HiLowVsAiActivity extends AppCompatActivity {
    TextView playerName;
    Player playerOne;
    Player playerAi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_low_vs_ai);

        TextView playerName = (TextView) findViewById(R.id.player_one_name_view);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Player playerOne = (Player) intent.getSerializableExtra("playerOne");
        Player playerAi = (Player) intent.getSerializableExtra("playerAi");

        Log.d("player", playerOne.getName());


        String playerNameText = extras.getString("playerOneName");
        playerName.setText(playerNameText);
    }
}
