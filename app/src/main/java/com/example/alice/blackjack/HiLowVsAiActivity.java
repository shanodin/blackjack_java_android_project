package com.example.alice.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HiLowVsAiActivity extends AppCompatActivity {
    TextView playerName;
    TextView playerCards;
    TextView aiCards;
    Player playerOne;
    Player playerAi;
    HiLo hiLowVsAi;
    Button fightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_low_vs_ai);

        playerName = (TextView) findViewById(R.id.player_one_name_view);

        playerCards = (TextView) findViewById(R.id.hi_low_player_cards);
        aiCards = (TextView) findViewById(R.id.hi_low_ai_cards);
        fightButton = (Button) findViewById(R.id.hi_low_fight_btn);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        playerOne = (Player) intent.getSerializableExtra("playerOne");
        playerAi = (Player) intent.getSerializableExtra("playerAi");

        hiLowVsAi = new HiLo(1, playerOne, playerAi);

        hiLowVsAi.play();

        String playerNameText = extras.getString("playerOneName");
        playerName.setText(playerNameText);
        if (playerNameText.length() == 0) {
            playerName.setText("Player One");
        }

        Card[] playerOneCards = playerOne.getCards();
        String pOneCardString = "Card Suit: " + playerOneCards[0].getSuit() +
                "\n Card Value: " + playerOneCards[0].getFace();
        playerCards.setText(pOneCardString);

        Card[] playerAiCards = playerAi.getCards();
        String pAiCardString = "Card Suit: " + playerAiCards[0].getSuit() +
                "\n Card Value: " + playerAiCards[0].getFace();
        aiCards.setText(pAiCardString);

        hiLowVsAi.getWinner();
    }

    public void onFightButtonClicked(View button) {
        Intent intent = new Intent(this, HiLowWinnerActivity.class);
        intent.putExtra("winner", hiLowVsAi.getWinner());
        intent.putExtra("player", playerOne);
        intent.putExtra("ai", playerAi);
        startActivity(intent);
    }
}
