package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Plateau p = (Plateau) findViewById(R.id.plat);
        p.setOnTouchListener(new PlateauListener());

        Button b = (Button) findViewById(R.id.clear_button);

        b.setOnClickListener(new GameListener(p));

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent = new Intent(this, ChoixCouleurActivity.class);
        this.startActivity(intent);


    }


}
