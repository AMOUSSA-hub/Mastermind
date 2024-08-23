package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class CorrectionActivity extends AppCompatActivity {


    int[] bonCode;
    int[] supposition;
    int pointeur=0;
    int[] choix = {0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correction);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            bonCode = bundle.getIntArray("bonCode");
            supposition = bundle.getIntArray("supposition");
            System.out.println("lecture des 2 codes"+bonCode+"----"+supposition);
        }

        Log.i("corr","bon code : ["+bonCode[0]+','+bonCode[1]+','+bonCode[2]+','+bonCode[3]+ "], suppo : ["+supposition[0]+','+supposition[1]+','+supposition[2]+','+supposition[3]+']');




        ImageView SupCouleur;

        SupCouleur = (ImageView) findViewById(R.id.circle1);
        SupCouleur.setBackgroundResource(DonneCouleurCercle(supposition[0]));

        SupCouleur = (ImageView) findViewById(R.id.circle2);
        SupCouleur.setBackgroundResource(DonneCouleurCercle(supposition[1]));

        SupCouleur = (ImageView) findViewById(R.id.circle3);
        SupCouleur.setBackgroundResource(DonneCouleurCercle(supposition[2]));

        SupCouleur = (ImageView) findViewById(R.id.circle4);
        SupCouleur.setBackgroundResource(DonneCouleurCercle(supposition[3]));

        ImageView btnBlanc = (ImageView) findViewById(R.id.circle9);
        btnBlanc.setOnClickListener(new CorrectionListener(btnBlanc,this));

        ImageView btnBlac = (ImageView) findViewById(R.id.circle10);
        btnBlac.setOnClickListener(new CorrectionListener(btnBlac,this));

        ImageView btnGre = (ImageView) findViewById(R.id.circle11);
        btnGre.setOnClickListener(new CorrectionListener(btnGre,this));

        Button btnAff = (Button) findViewById(R.id.btnAffCode);
        btnAff.setOnClickListener(new CorrectionBntListener(btnAff,this));

        Button btnVal = (Button) findViewById(R.id.btn_valider_corr);
        btnVal.setOnClickListener(new CorrectionBntListener(btnVal,this));

        Button btnWin = (Button) findViewById(R.id.win_button);
        btnWin.setOnClickListener(new CorrectionBntListener(btnWin,this));
    }

    public void setCouleur(int couleur){
        Log.d("click","click sur cercle de couleur" + couleur);
        //blue - vert - rouge - jaune - blanc -
        this.choix[pointeur]=couleur;
        if(couleur==5){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.white_circle);
        }
        else if(couleur==6){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.black_circle);
        }
        else if(couleur==0){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.circle_gray);
        }

        incrementerPointeur();
    }

    public ImageView getPointeurCirle(int i){
        if(i==0){
            return (ImageView) findViewById(R.id.circle5);
        }
        else if (i==1) {
            return (ImageView) findViewById(R.id.circle6);
        }
        else if (i==2) {
            return (ImageView) findViewById(R.id.circle7);
        }
        else{
            return (ImageView) findViewById(R.id.circle8);
        }
    }
    public void incrementerPointeur(){
        pointeur++;
        if (pointeur==4){
            pointeur=0;
        }

        if (pointeur==0){
            findViewById(R.id.arrow4).setVisibility(View.INVISIBLE);
            findViewById(R.id.arrow1).setVisibility(View.VISIBLE);
        }
        else if (pointeur==1){
            findViewById(R.id.arrow1).setVisibility(View.INVISIBLE);
            findViewById(R.id.arrow2).setVisibility(View.VISIBLE);
        }
        else if (pointeur==2){
            findViewById(R.id.arrow2).setVisibility(View.INVISIBLE);
            findViewById(R.id.arrow3).setVisibility(View.VISIBLE);
        }
        else if (pointeur==3){
            findViewById(R.id.arrow3).setVisibility(View.INVISIBLE);
            findViewById(R.id.arrow4).setVisibility(View.VISIBLE);
        }

    }


    private int DonneCouleurCercle(int coul){
        if (coul==0){
            return R.drawable.circle_gray;
        }
        else if (coul==1){
            return R.drawable.blue_circle;
        }
        else if (coul==2){
            return R.drawable.green_circle;
        }
        else if (coul==3){
            return R.drawable.red_circle;
        }
        else if (coul==4){
            return R.drawable.yellow_circle;
        }
        else if (coul==5){
            return R.drawable.white_circle;
        }
        else {
            return R.drawable.black_circle;
        }
    }

    public void onBackPressed() {
        this.finishAffinity();
        Intent intent;

        intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);



    }



}