package iut.fbleau.mastermind;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Plateau p = (Plateau) findViewById(R.id.plat);
        p.setOnTouchListener(new PlateauListener());

    }


}
