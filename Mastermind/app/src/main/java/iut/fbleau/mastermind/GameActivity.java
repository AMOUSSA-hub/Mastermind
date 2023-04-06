package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Plateau p = (Plateau) findViewById(R.id.plat);
        p.setOnTouchListener(new PlateauListener());

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent = new Intent(this, ChoixCouleurActivity.class);
        this.startActivity(intent);
    }


}
