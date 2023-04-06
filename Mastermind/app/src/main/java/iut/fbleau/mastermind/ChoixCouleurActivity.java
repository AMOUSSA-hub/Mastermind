package iut.fbleau.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class ChoixCouleurActivity extends AppCompatActivity {

    int pointeur=0;
    int[] choix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choixcouleur);

        findViewById(R.id.arrow1).setVisibility(View.VISIBLE);

        Button btnRetour = (Button) findViewById(R.id.btn_retour3);
        btnRetour.setOnClickListener(new ButtonListener(btnRetour,this));



        ImageView btnCouleur1 = (ImageView) findViewById(R.id.circle5);
        btnCouleur1.setOnClickListener(new ChoixCouleurListener(btnCouleur1,this));

        ImageView btnCouleur2 = (ImageView) findViewById(R.id.circle6);
        btnCouleur2.setOnClickListener(new ChoixCouleurListener(btnCouleur2,this));

        ImageView btnCouleur3 = (ImageView) findViewById(R.id.circle7);
        btnCouleur3.setOnClickListener(new ChoixCouleurListener(btnCouleur3,this));

        ImageView btnCouleur4 = (ImageView) findViewById(R.id.circle8);
        btnCouleur4.setOnClickListener(new ChoixCouleurListener(btnCouleur4,this));

        ImageView btnCouleur5 = (ImageView) findViewById(R.id.circle9);
        btnCouleur5.setOnClickListener(new ChoixCouleurListener(btnCouleur5,this));

        //si option decoché faire "  btnCouleur5.setVisibility(View.GONE); "
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if(!bundle.getBoolean("CaseVide")){
                btnCouleur5.setVisibility(View.GONE);
            }
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
        //blue - vert - rouge - jaune - blanc
        if(couleur==1){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.blue_circle);
            //this.choix[pointeur]=couleur;
        }
        else if(couleur==2){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.green_circle);
            //this.choix[pointeur]=couleur;
        }
        else if(couleur==3){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.red_circle);
            //this.choix[pointeur]=couleur;
        }
        else if(couleur==4){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.yellow_circle);
            //this.choix[pointeur]=couleur;
        }
        else if(couleur==5){
            getPointeurCirle(this.pointeur).setBackgroundResource(R.drawable.white_circle);
            //this.choix[pointeur]=couleur;
        }
        incrementerPointeur();
    }



}