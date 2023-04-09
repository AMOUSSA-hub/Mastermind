package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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

          boolean emptyCase = bundle.getBoolean("caseVide");

            if(emptyCase){
                ((TextView) findViewById(R.id.info_caseVide)).setText("Activé");
            }
            else{
                ((TextView) findViewById(R.id.info_caseVide)).setText("Désactivé");
            }
            this.getIntent().putExtra("caseVide",emptyCase);
        }



    }
    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }



}