package com.onzin.hogertjelagertje;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class game extends AppCompatActivity {

    // initialize all objects from the layout
    // generate a random number
    TextView helloText;
    EditText guess;
    Integer numberGuess;
    Button guessButton;
    TextView guessText;
    Random rand = new Random();
    int number = rand.nextInt(1000) + 1;

    // initialize the variable given from mainActivity
    public static String USR_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // store the variable given from main into new string
        Intent gameIntent = getIntent();
        String usrName = gameIntent.getStringExtra(USR_NAME);

        // get from all object the info needed en put in a variable
        // the helloText is altered
        helloText = (TextView) findViewById(R.id.helloText);
        helloText.setText("hello " + usrName);
        guessButton = (Button) findViewById(R.id.guessButton);
        guessText = (TextView) findViewById(R.id.guessText);

        // what to do wehen button is clicked
        guessButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                // storing input from object in variable and convert to integer
                guess = (EditText) findViewById(R.id.guess);
                String guessStr = guess.getText().toString();
                numberGuess = Integer.valueOf(guessStr);
                int dif = number - Math.abs(numberGuess - number);

                // changing color when guess is near of=r further from number
                if (dif < 0.25 * number)
                {
                    guessText.setBackgroundColor(Color.RED);
                }
                else if ((dif < 0.75 * number)&&(dif > 0.25 * number))
                {
                    guessText.setBackgroundColor(Color.YELLOW);
                }
                else if (dif > 0.75 * number)
                {
                    guessText.setBackgroundColor(Color.GREEN);
                }

                // testing wether the guessed number is correct
                if(numberGuess > number)
                {
                    guessText.setText("Sorry, " + numberGuess.toString() + " is too high! Please try again...");
                }
                else if(numberGuess < number)
                {
                    guessText.setText("Sorry, " + numberGuess.toString() + " is too low! Please try again...");
                }
                if(numberGuess == number)
                {
                    guessText.setText("Good Job!!! you've found my number. Press back to play again.");
                }
            }

        });
    }
}
