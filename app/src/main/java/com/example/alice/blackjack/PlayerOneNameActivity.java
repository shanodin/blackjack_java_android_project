package com.example.alice.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerOneNameActivity extends AppCompatActivity {
    EditText playerOneName;
    Button btnPlayVsAi;
    Button btnAddPlayerTwo;
    Player playerOne;
    Player playerAi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_one_name);

        playerOneName = (EditText) findViewById(R.id.player_one_edit);
        btnPlayVsAi = (Button) findViewById(R.id.player_one_vs_ai_button);
        btnAddPlayerTwo = (Button) findViewById(R.id.player_one_add_p2);
    }

    public void onAiButtonClick(View button) {
        Intent intent = new Intent(this, HiLowVsAiActivity.class);
        String playerOneNameText = playerOneName.getText().toString();

        playerOne =  new Player(playerOneNameText);
        playerAi = new Player("AI");

        intent.putExtra("playerOneName", playerOneNameText);
        intent.putExtra("playerOne", playerOne);
        intent.putExtra("playerAi", playerAi);

        startActivity(intent);
    }
}
