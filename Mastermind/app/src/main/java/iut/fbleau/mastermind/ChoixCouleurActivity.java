package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoixCouleurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choixcouleur);

        Button btnRetour = (Button) findViewById(R.id.btn_retour3);
        btnRetour.setOnClickListener(new ButtonListener(btnRetour,this));
    }



}