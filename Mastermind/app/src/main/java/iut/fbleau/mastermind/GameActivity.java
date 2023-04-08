package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GameActivity extends Activity {

    Boolean IsCercleBlanc = false;
    Boolean ContreRobot = false;
    int[] code;

    Plateau p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if(bundle.getBoolean("CaseVide")){
                //btnCouleur7.setVisibility(View.GONE);
                IsCercleBlanc=true;
            }
            if(bundle.getBoolean("ContreRobot")){
                ContreRobot=true;
            }
            code = bundle.getIntArray("choix");
        }

        Log.i("code_choisie",""+code[0]+','+code[1]+','+code[2]+','+code[3]);
        Log.d("caseVideGame",""+IsCercleBlanc);

        p = (Plateau) findViewById(R.id.plat);
        p.setOnTouchListener(new PlateauListener());

        Button b = (Button) findViewById(R.id.clear_button);
        b.setOnClickListener(new GameListener(p,this));

        Button v = (Button) findViewById(R.id.gameValider_button);
        v.setOnClickListener(new GameListener(p,this));

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent intent;
        if(ContreRobot){
            intent = new Intent(this, GameModeActivity.class);
        }
        else{
            intent = new Intent(this, ChoixCouleurActivity.class);
        }
        intent.putExtra("caseVide",IsCercleBlanc);
        this.startActivity(intent);


    }


}
