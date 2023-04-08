package iut.fbleau.mastermind;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixCouleurListener extends AppCompatActivity implements View.OnClickListener{

    ImageView viewCercle;
    ChoixCouleurActivity activity;

    public ChoixCouleurListener(ImageView viewCercle,ChoixCouleurActivity activity){
        this.viewCercle = viewCercle;
        this.activity = activity;
    }



    @Override
    public void onClick(View view) {

        if(this.viewCercle.getId() == R.id.circle5){
            activity.setCouleur(1);
        }
        if(this.viewCercle.getId() == R.id.circle6){
            activity.setCouleur(2);
        }
        if(this.viewCercle.getId() == R.id.circle7){
            activity.setCouleur(3);
        }
        if(this.viewCercle.getId() == R.id.circle8){
            activity.setCouleur(4);
        }
        if(this.viewCercle.getId() == R.id.circle9){
            activity.setCouleur(5);
        }
        if(this.viewCercle.getId() == R.id.circle10){
            activity.setCouleur(6);
        }
        if(this.viewCercle.getId() == R.id.circle11){
            activity.setCouleur(0);
        }


    }



}
