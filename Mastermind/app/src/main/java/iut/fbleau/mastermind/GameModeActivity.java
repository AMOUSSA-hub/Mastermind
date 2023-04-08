package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class GameModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemode);

        Button btnRetour = (Button) findViewById(R.id.btn_retour2);
        btnRetour.setOnClickListener(new ButtonListener(btnRetour,this));

        Button btnJouerA2 = (Button) findViewById(R.id.btn_JHotSeat);
        btnJouerA2.setOnClickListener(new ButtonListener(btnJouerA2,this));

        Button btnJouerRobot = (Button) findViewById(R.id.btn_JRobot);
        btnJouerRobot.setOnClickListener(new ButtonListener(btnJouerRobot,this));

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            if(bundle.getBoolean("caseVide")){
                ((CheckBox) findViewById(R.id.checkbox_cerlceBlanc)).setChecked(true);
            }
        }



    }
    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }



}