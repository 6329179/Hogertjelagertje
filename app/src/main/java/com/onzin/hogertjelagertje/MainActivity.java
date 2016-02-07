package com.onzin.hogertjelagertje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        // initialize objects
        EditText usrName;
        Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // stores state of objects in variables
        usrName = (EditText) findViewById(R.id.usrName);
        nextButton = (Button) findViewById(R.id.nextButton);

        // what to do when button is clicked
        nextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View V){
                // store object text in a variable
                String userName = usrName.getText().toString();

                // pushes variable values to the next activity
                Intent gameIntent = new Intent(MainActivity.this, game.class);
                gameIntent.putExtra(game.USR_NAME, userName);

                // go to next activity
                startActivity(gameIntent);
            }
        });





    }
}
