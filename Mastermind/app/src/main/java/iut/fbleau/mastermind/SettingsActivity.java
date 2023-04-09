package iut.fbleau.mastermind;

import android.app.Activity;
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


    }

}
