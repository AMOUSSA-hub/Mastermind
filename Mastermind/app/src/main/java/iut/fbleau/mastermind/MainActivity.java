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

        //bouton quitter
        Button btnQuitter = (Button) findViewById(R.id.btn_quitter1);
        btnQuitter.setOnClickListener(new ButtonListener(btnQuitter,this));

        //bouton jouer
        Button btnJouer = (Button) findViewById(R.id.btn_jouer1);
        btnJouer.setOnClickListener(new ButtonListener(btnJouer,this));


        //bouton règlage
        Button btnSetting = (Button) findViewById(R.id.setting_button);
        btnSetting.setOnClickListener(new ButtonListener(btnSetting,this));

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();

            if(bundle.getBoolean("caseVide")){
                this.getIntent().putExtra("caseVide",true);
            }

            else {
                this.getIntent().putExtra("caseVide",false);
                System.out.println("case vide désactivé");
            }
    }





    }