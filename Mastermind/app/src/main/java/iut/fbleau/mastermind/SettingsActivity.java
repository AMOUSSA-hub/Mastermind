package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //bouton valider
        Button btnSubmit = (Button) findViewById(R.id.submit_settings);
        CheckBox empty_case = (CheckBox) findViewById(R.id.checkbox_cerlceBlanc) ;
        btnSubmit.setOnClickListener(new ButtonListener(empty_case,this));

        //bouton retour

        Button btnRetour = (Button) findViewById(R.id.button_retour_settings);
        btnRetour.setOnClickListener(new ButtonListener(empty_case,this));



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("caseVide",false);
        this.setResult(Activity.RESULT_OK,intent);


        super.onBackPressed();

    }
}
