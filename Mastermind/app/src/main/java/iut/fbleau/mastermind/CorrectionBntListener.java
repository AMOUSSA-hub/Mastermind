package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CorrectionBntListener extends AppCompatActivity implements View.OnClickListener {

    Button button;
    CorrectionActivity activity;

    public CorrectionBntListener(Button button, CorrectionActivity activity) {
        this.button = button;
        this.activity = activity;
    }


    @Override
    public void onClick(View view) {

        if (this.button.getId() == R.id.btnAffCode) {
            affPopUp();
        }
        else if (this.button.getId() == R.id.btn_valider_corr) {

            Intent intent = new Intent();
            intent.putExtra("correction", activity.choix);
            setResult(RESULT_OK, intent);
            activity.finish();
        }
    }

    private void affPopUp() {
        int[] couleurs = activity.bonCode;

        // Création d'un LinearLayout horizontal pour contenir les cercles
        LinearLayout layout = new LinearLayout(activity);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER); // Centrer les éléments

        // Création des cercles avec les couleurs correspondantes
        for (int i = 0; i < 4; i++) {
            View cercle = new View(activity);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    50, // Largeur
                    50 // Hauteur
            );
            params.setMargins(5, 5, 5, 5); // Marges autour du cercle

            cercle.setLayoutParams(params);

            // Attribution de la couleur en fonction de la valeur dans le tableau
            switch (couleurs[i]) {
                case 0:
                    cercle.setBackgroundResource(R.drawable.circle_gray);
                    break;
                case 1:
                    cercle.setBackgroundResource(R.drawable.blue_circle);
                    break;
                case 2:
                    cercle.setBackgroundResource(R.drawable.green_circle);
                    break;
                case 3:
                    cercle.setBackgroundResource(R.drawable.red_circle);
                    break;
                case 4:
                    cercle.setBackgroundResource(R.drawable.yellow_circle);
                    break;
                case 5:
                    cercle.setBackgroundResource(R.drawable.white_circle);
                    break;
                case 6:
                    cercle.setBackgroundResource(R.drawable.black_circle);
                    break;
                default:
                    cercle.setBackgroundResource(R.drawable.circle_gray);
            }

            // Ajout du cercle au layout
            layout.addView(cercle);
        }

        // Création de la boîte de dialogue
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Votre code secret");

        builder.setView(layout);

        // Affichage de la boîte de dialogue

        builder.show();

    }
}
