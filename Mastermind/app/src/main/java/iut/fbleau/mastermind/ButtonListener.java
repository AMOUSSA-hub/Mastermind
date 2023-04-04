package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class ButtonListener implements View.OnClickListener{

    Button button;

    public ButtonListener(Button button){
        this.button = button;
    }

    @Override
    public void onClick(View view) {
        if(this.button.getId() == R.id.btn_quitter){
            ((Activity) view.getContext()).finish();
        }

        if(this.button.getId() == R.id.btn_jouer){
            Intent intent = new Intent(Activity1.this, Activity2.class);
            startActivity(intent);
        }
    }

}
