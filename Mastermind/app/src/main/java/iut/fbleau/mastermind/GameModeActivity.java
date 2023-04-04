package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemode);

        Button btnRetour = (Button) findViewById(R.id.btn_retour2);
        btnRetour.setOnClickListener(new ButtonListener(btnRetour,this));

        Button btnJouerA2 = (Button) findViewById(R.id.btn_JHotSeat);
        btnJouerA2.setOnClickListener(new ButtonListener(btnJouerA2,this));

    }



}