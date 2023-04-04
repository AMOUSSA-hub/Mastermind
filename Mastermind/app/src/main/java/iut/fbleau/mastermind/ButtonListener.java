package iut.fbleau.mastermind;

import android.app.Activity;
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
    }

}
