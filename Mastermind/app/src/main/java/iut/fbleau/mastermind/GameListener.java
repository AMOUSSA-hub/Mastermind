package iut.fbleau.mastermind;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
            int[] bonCode = activity.code;
            int[] supposition = activity.p.giveLigne();

            if (supposition==null){
                Toast.makeText(activity, "L'utilisation des cases vides sont désactivées", Toast.LENGTH_SHORT).show();
                return;
            }
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
                        else if(correction[i]!=6 && bonCode[i]!=couleur){
                            correction[i]=5;
                            lu[i]=u;
                            //ajout blanc
                        }
                    }
                }

            }
            //if(correction=={6,6,6,6}){

            p.setCorrection(correction);


        }
    }

}
