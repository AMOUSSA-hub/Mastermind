package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends Activity {

    final int REQUEST_CODE = 5;

    Boolean isCercleBlanc = false;
    Boolean ContreRobot = false;
    int[] code = {0,0,0,0};

    Plateau p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if(bundle.getBoolean("caseVide")){
                isCercleBlanc=true;
            }
            if(bundle.getBoolean("ContreRobot")){
                ContreRobot=true;
            }
            code = bundle.getIntArray("choix");
        }

        Log.i("initActivity","isCercleBlanc: "+isCercleBlanc+"    ContreRobot: "+ContreRobot);

        Log.i("code_supo",""+code[0]+','+code[1]+','+code[2]+','+code[3]);
        Log.d("caseVideGame",""+isCercleBlanc);

        p = (Plateau) findViewById(R.id.plat);
        p.setOnTouchListener(new PlateauListener());

        Button b = (Button) findViewById(R.id.clear_button);
        b.setOnClickListener(new GameListener(p,this));

        Button v = (Button) findViewById(R.id.gameValider_button);
        v.setOnClickListener(new GameListener(p,this));

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent;
        if(ContreRobot){
            intent = new Intent(this, GameModeActivity.class);
        }
        else{
            intent = new Intent(this, ChoixCouleurActivity.class);
        }
        intent.putExtra("caseVide",isCercleBlanc);
        this.startActivity(intent);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("retour 0");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            System.out.println("retour 1 "+resultCode +""+ data);
            if (resultCode == RESULT_OK) {
                System.out.println("retour 2");
                // Récupération des données renvoyées par l'activité enfant
                Bundle bundle = data.getExtras();
                p.setCorrection(bundle.getIntArray("correction"));
                System.out.println(bundle.getIntArray("correction"));



            }
        }
    }


     public void Victory(){

         // Création d'un LinearLayout horizontal pour contenir les cercles
         LinearLayout layout = new LinearLayout(this);
         layout.setOrientation(LinearLayout.HORIZONTAL);
         layout.setGravity(Gravity.CENTER); // Centrer les éléments

                TextView TV = new TextView(this);

                TV.setText("Bravo! Vous avez gagné avec un total de"+p.getTry()+" essais");
                TV.setTextSize(15f);
                TV.setTypeface(null, Typeface.BOLD);
                TV.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
             // Ajout du cercle au layout
             layout.addView(TV);


         // Création de la boîte de dialogue
         AlertDialog.Builder builder = new AlertDialog.Builder(this);

         builder.setView(layout);

         // Affichage de la boîte de dialogue

         builder.show();



     }





}
