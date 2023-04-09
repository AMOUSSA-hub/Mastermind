package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GameListener implements View.OnClickListener {

    Plateau p;
    GameActivity activity;

    public GameListener(Plateau p,GameActivity activity) {
        this.p = p;
        this.activity = activity;
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.clear_button) {
            p.clearLine();
        }
        else if (view.getId() == R.id.gameValider_button) {
            int[] supposition = activity.p.giveLigne(activity.isCercleBlanc);

            if (supposition==null){
                Toast.makeText(activity, "L'utilisation des cases vides sont désactivées", Toast.LENGTH_SHORT).show();
                return;
            }
            if(activity.ContreRobot){
                corrige();
            }
            else{
                Intent intent = new Intent(activity, CorrectionActivity.class);
                intent.putExtra("bonCode", activity.code);
                intent.putExtra("supposition", activity.p.giveLigne(activity.isCercleBlanc));
                activity.startActivityForResult(intent, activity.REQUEST_CODE);
            }
        }

    }

private void corrige(){
    int[] bonCode = activity.code;
    int[] supposition = activity.p.giveLigne(activity.isCercleBlanc);


    Log.i("code","bon code : ["+bonCode[0]+','+bonCode[1]+','+bonCode[2]+','+bonCode[3]+"], suppo : ["+supposition[0]+','+supposition[1]+','+supposition[2]+','+supposition[3]+']');

    int[] correction = {0,0,0,0};
    int[] lu={-1,-1,-1,-1};

    for(int i=0;i<4;i++){
        int couleur = supposition[i];

        for(int u=0;u<4;u++){
            if (couleur==bonCode[u]){
                if(i==u){
                    correction[i]=6;
                    for(int k=0;k<4;k++){
                        if(lu[k]==i){
                            correction[k]=0;
                        }
                    }
                    //ajout noir
                }
                else if(correction[i]!=6 && bonCode[i]!=couleur && correction[u]!=6){
                    correction[i]=5;
                    lu[i]=u;
                    //ajout blanc
                }
            }
        }

    }
    Log.i("code","correction : ["+correction[0]+','+correction[1]+','+correction[2]+','+correction[3]+"]lu : ["+lu[0]+','+lu[1]+','+lu[2]+','+lu[3]+"]");
    if(Arrays.equals(correction, new int[]{6, 6, 6, 6})){

        activity.Victory();

    }




    p.setCorrection(correction);


    }
}
