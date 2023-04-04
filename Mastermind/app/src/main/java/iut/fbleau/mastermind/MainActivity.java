package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnQuitter = (Button) findViewById(R.id.btn_quitter1);
        btnQuitter.setOnClickListener(new ButtonListener(btnQuitter,this));
        Button btnJouer = (Button) findViewById(R.id.btn_jouer1);
        btnJouer.setOnClickListener(new ButtonListener(btnJouer,this));

    }



}