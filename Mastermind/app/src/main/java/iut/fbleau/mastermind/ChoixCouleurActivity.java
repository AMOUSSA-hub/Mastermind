package iut.fbleau.mastermind;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChoixCouleurActivity extends AppCompatActivity {

    int pointeur=0;
    int[] choix = {0,0,0,0};
    boolean IsCercleBlanc=false;
    boolean ContreRobot=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choixcouleur);

        findViewById(R.id.arrow1).setVisibility(View.VISIBLE);



        Button btnRetour = (Button) findViewById(R.id.btn_retour3);
        btnRetour.setOnClickListener(new ButtonListener(btnRetour,this));


        Button valider = (Button) findViewById(R.id.btn_valider_choixCouleur);
        valider.setOnClickListener(new ButtonListener(valider,this));

        //bind des listener sur les cercles de couleur de la sélection

        //cercle bleu
        ImageView btnCouleur1 = (ImageView) findViewById(R.id.circle5);
        btnCouleur1.setOnClickListener(new ChoixCouleurListener(btnCouleur1,this));

        //cercle vert
        ImageView btnCouleur2 = (ImageView) findViewById(R.id.circle6);
        btnCouleur2.setOnClickListener(new ChoixCouleurListener(btnCouleur2,this));

        //cercle rouge
        ImageView btnCouleur3 = (ImageView) findViewById(R.id.circle7);
        btnCouleur3.setOnClickListener(new ChoixCouleurListener(btnCouleur3,this));

        //cercle jaune
        ImageView btnCouleur4 = (ImageView) findViewById(R.id.circle8);
        btnCouleur4.setOnClickListener(new ChoixCouleurListener(btnCouleur4,this));

        //cercle blanc
        ImageView btnCouleur5 = (ImageView) findViewById(R.id.circle9);
        btnCouleur5.setOnClickListener(new ChoixCouleurListener(btnCouleur5,this));

        //cercle noir
        ImageView btnCouleur6 = (ImageView) findViewById(R.id.circle10);
        btnCouleur6.setOnClickListener(new ChoixCouleurListener(btnCouleur6,this));

        //cercle vide
        ImageView btnCouleur7 = (ImageView) findViewById(R.id.circle11);
        btnCouleur7.setOnClickListener(new ChoixCouleurListener(btnCouleur7,this));

        //si option decoché faire "  btnCouleur7.setVisibility(View.GONE); "
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if(bundle.getBoolean("CaseVide")){
                IsCercleBlanc=true;
            }
            else{
                btnCouleur7.setVisibility(View.GONE);
                //change la taille du layout selon le nbr de cercles pour pas les deformer
                float dp = 60f;
                float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
                LinearLayout myLayout = findViewById(R.id.layoutCerlces);
                ViewGroup.LayoutParams layoutParams = myLayout.getLayoutParams();
                layoutParams.height = (int) pixels;
                myLayout.setLayoutParams(layoutParams);
            }
            if(bundle.getBoolean("ContreRobot")){
                ContreRobot=true;
            }
        }
        Log.d("caseVideChoix",""+IsCercleBlanc);
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
    public ImageView getPointeurCirle(int i){
        if(i==0){
            return (ImageView) findViewById(R.id.circle1);
        }
        else if (i==1) {
            return (ImageView) findViewById(R.id.circle2);
        }
        else if (i==2) {
            return (ImageView) findViewById(R.id.circle3);
        }
        else{
            return (ImageView) findViewById(R.id.circle4);
        }
    }

    public void setCouleur(int couleur){
        Log.d("click","click sur cercle de couleur" + couleur);
        //blue - vert - rouge - jaune - blanc -
        this.choix[pointeur]=couleur;
        if(couleur==1){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.blue_circle);
        }
        else if(couleur==2){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.green_circle);
        }
        else if(couleur==3){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.red_circle);
        }
        else if(couleur==4){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.yellow_circle);
        }
        else if(couleur==5){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.white_circle);
        }
        else if(couleur==6){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.black_circle);
        }
        else if(couleur==7){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.circle_gray);
        }

        incrementerPointeur();
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent = new Intent(this, GameModeActivity.class);
        intent.putExtra("caseVide",IsCercleBlanc);
        this.startActivity(intent);
    }



}