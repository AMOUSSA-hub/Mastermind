package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static boolean caseVide =false ;

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

        this.getIntent().putExtra("caseVide",caseVide);





    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            Bundle bundle = data.getExtras();


            if (bundle.getBoolean("caseVide")) {
                this.getIntent().putExtra("caseVide", true);
                caseVide = true;
            } else {
                this.getIntent().putExtra("caseVide", false);
                caseVide = false;
            }
        }
     }





    }