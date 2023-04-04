package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bouton quitter
        Button btnQuitter = (Button) findViewById(R.id.btn_quitter);
        btnQuitter.setOnClickListener(new ButtonListener(btnQuitter));
        //bouton jouer
        Button btnJouer = (Button) findViewById(R.id.btn_jouer);
        btnJouer.setOnClickListener(new ButtonListener(btnJouer));
    }



}