package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ButtonListener extends AppCompatActivity implements View.OnClickListener{

    Button button;
    Activity activity;

    public ButtonListener(Button button,Activity activity){
        this.button = button;
        this.activity = activity;
    }



    @Override
    public void onClick(View view) {
        Log.d("click","click sur bouton de source"+this.button);

        if(this.button.getId() == R.id.btn_quitter1){
            ((Activity) view.getContext()).finishAffinity();
        }
        else if(this.button.getId() == R.id.btn_jouer1){
            Intent intent = new Intent(activity, GameModeActivity.class);
            activity.startActivity(intent);
        }
        else if(this.button.getId() == R.id.btn_retour2){
            activity.finishAffinity();
            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
        else if(this.button.getId() == R.id.btn_retour3){
            activity.finishAffinity();
            Intent intent = new Intent(activity, GameModeActivity.class);
            intent.putExtra("caseVide",((ChoixCouleurActivity) activity).isCercleBlanc);
            activity.startActivity(intent);
        }
        else if(this.button.getId() == R.id.btn_JRobot){
            activity.finishAffinity();

            CheckBox myCheckBox = (CheckBox) activity.findViewById(R.id.checkbox_cerlceBlanc);
            boolean isChecked = myCheckBox.isChecked();

            Intent intent = new Intent(activity, GameActivity.class);
            intent.putExtra("choix",generateCode(isChecked));
            intent.putExtra("caseVide", isChecked);
            intent.putExtra("ContreRobot", true);
            activity.startActivity(intent);
        }
        else if(this.button.getId() == R.id.btn_JHotSeat){
            activity.finishAffinity();

            CheckBox myCheckBox = (CheckBox) activity.findViewById(R.id.checkbox_cerlceBlanc);
            boolean isChecked = myCheckBox.isChecked();

            Intent intent = new Intent(activity, ChoixCouleurActivity.class);
            intent.putExtra("CaseVide", isChecked);
            intent.putExtra("ContreRobot", false);
            activity.startActivity(intent);
        }
        else if(this.button.getId() == R.id.btn_valider_choixCouleur){

            Log.d("Cercle","1");
            if(!((ChoixCouleurActivity) activity).isCercleBlanc){
                Log.d("Cercle","2");
                int[] choix = ((ChoixCouleurActivity) activity).choix;
                if(choix[0]==0||choix[1]==0||choix[2]==0||choix[3]==0){
                    Log.d("Cercle","3"+choix[0]+choix[1]+choix[2]+choix[3]);
                    Toast.makeText(activity, "L'utilisation des cases vides sont désactivées", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            Log.d("Cercle","4");
            activity.finishAffinity();
            Intent intent = new Intent(activity, GameActivity.class);
            intent.putExtra("ContreRobot", ((ChoixCouleurActivity) activity).ContreRobot);
            intent.putExtra("choix",((ChoixCouleurActivity) activity).choix);
            intent.putExtra("caseVide",((ChoixCouleurActivity) activity).isCercleBlanc);
            activity.startActivity(intent);
        }

    }


    public static int[] generateCode(boolean useZero) {
        Random random = new Random();
        int[] choix = {0,0,0,0};

        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(7); //7 = max nbr couleur +1

            if(digit==0 && !useZero){
                i--;
            }
            else {
                choix[i] = digit;
            }
        }

        return choix;
    }


}
