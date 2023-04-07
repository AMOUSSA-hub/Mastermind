package iut.fbleau.mastermind;

import android.view.View;

public class GameListener implements View.OnClickListener {

    Plateau p;

    public GameListener(Plateau p) {
        this.p = p;
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.clear_button) {
            p.clearLine();
        }
    }

}
