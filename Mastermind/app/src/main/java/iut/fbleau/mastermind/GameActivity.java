package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.DialogInterface;
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

import java.util.Arrays;

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

        LinearLayout LL = (LinearLayout) findViewById(R.id.screen_game);
        LL.setOnTouchListener(new TactileListener(this));

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent;

    if(p.isGameFinished()){
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("caseVide", isCercleBlanc);
        this.startActivity(intent);

    }else {


        if (ContreRobot) {
            intent = new Intent(this, GameModeActivity.class);
        } else {
            intent = new Intent(this, ChoixCouleurActivity.class);
        }
        intent.putExtra("caseVide", isCercleBlanc);
        this.startActivity(intent);
    }

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
                int [] correction =bundle.getIntArray("correction");


                System.out.println(correction);

                if(Arrays.equals(correction, new int[]{6, 6, 6, 6})){
                    System.out.println("gagné");
                    this.p.setGameFinished();
                    this.Victory();
                }


                else if (p.getTry() == 10){
                    this.p.setGameFinished();
                    this.Defeat();

                }

                p.setCorrection(correction);




            }
        }
    }


     public void Victory(){

         // Création d'un LinearLayout horizontal pour contenir les cercles
         LinearLayout layout = new LinearLayout(this);
         layout.setOrientation(LinearLayout.HORIZONTAL);
         layout.setGravity(Gravity.CENTER); // Centrer les éléments

                TextView TV = new TextView(this);


                TV.setText("Bravo! Vous avez gagné avec un total de \n" +p.getTry()+" essais");
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


    public void Defeat(){

        // Création d'un LinearLayout horizontal pour contenir les cercles
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER); // Centrer les éléments
        ;



        //combinaison gagnante
        for (int i = 0; i < 4; i++) {
            View cercle = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    50, // Largeur
                    50 // Hauteur
            );
            params.setMargins(5, 5, 5, 5); // Marges autour du cercle

            cercle.setLayoutParams(params);

            // Attribution de la couleur en fonction de la valeur dans le tableau
            switch (code[i]) {
                case 0:
                    cercle.setBackgroundResource(R.drawable.circle_gray);
                    break;
                case 1:
                    cercle.setBackgroundResource(R.drawable.blue_circle);
                    break;
                case 2:
                    cercle.setBackgroundResource(R.drawable.green_circle);
                    break;
                case 3:
                    cercle.setBackgroundResource(R.drawable.red_circle);
                    break;
                case 4:
                    cercle.setBackgroundResource(R.drawable.yellow_circle);
                    break;
                case 5:
                    cercle.setBackgroundResource(R.drawable.white_circle);
                    break;
                case 6:
                    cercle.setBackgroundResource(R.drawable.black_circle);
                    break;
                default:
                    cercle.setBackgroundResource(R.drawable.circle_gray);
            }

            // Ajout du cercle au layout
            layout.addView(cercle);
        }




        // Création de la boîte de dialogue
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(layout);
        builder.setTitle("Vous avez perdu dommage. Voici le code secret:");

        // Affichage de la boîte de dialogue

        builder.show();



    }

     public Plateau getPlateau(){
        return this.p;
     }








}
