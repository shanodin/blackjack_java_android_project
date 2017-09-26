package com.example.alice.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class HiLowWinnerActivity extends AppCompatActivity {
    TextView hiLowVAiWinnerText;
    Button hiLowVsAiPlayAgainBtn;
    Player playerOne;
    Player playerAi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_low_winner);

        Intent intent = getIntent();
        Player winner = (Player) intent.getSerializableExtra("winner");
        playerOne = (Player) intent.getSerializableExtra("player");

        TextView hiLowWinnerText = (TextView) findViewById(R.id.hiLowVAiWinnerText);
        hiLowWinnerText.setText(winner.getName());

        Button hiLowVsAiPlayAgainBtn = (Button) findViewById(R.id.hiLowVsAiPlayAgainBtn);
    }

    public void onPlayAgainButtonClicked (View button) {
        Intent intent = new Intent(this, HiLowVsAiActivity.class);
        String playerOneNameText = playerOne.getName().toString();

        playerOne =  new Player(playerOneNameText);
        playerAi = new Player("AI");

        intent.putExtra("playerOneName", playerOneNameText);
        intent.putExtra("playerOne", playerOne);
        intent.putExtra("playerAi", playerAi);

        startActivity(intent);
    }
}
