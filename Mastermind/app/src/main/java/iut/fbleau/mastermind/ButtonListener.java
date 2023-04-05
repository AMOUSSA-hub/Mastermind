package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonListener extends AppCompatActivity implements View.OnClickListener{

    Button button;
    Activity activity;

    public ButtonListener(Button button,Activity activity){
        this.button = button;
        this.activity = activity;
    }



    @Override
    public void onClick(View view) {

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
            activity.startActivity(intent);
        }
                else if(this.button.getId() == R.id.btn_JHotSeat){
            Intent intent = new Intent(activity, ChoixCouleurActivity.class);
            activity.startActivity(intent);
        }

    }



}
