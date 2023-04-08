package iut.fbleau.mastermind;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CorrectionListener extends AppCompatActivity implements View.OnClickListener{

    ImageView viewCercle;
    CorrectionActivity activity;

    public CorrectionListener(ImageView viewCercle,CorrectionActivity activity){
        this.viewCercle = viewCercle;
        this.activity = activity;
    }
    public void onClick(View view) {

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
