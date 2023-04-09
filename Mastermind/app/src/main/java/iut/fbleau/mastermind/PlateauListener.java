package iut.fbleau.mastermind;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

public class PlateauListener implements View.OnTouchListener {


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Plateau p = (Plateau) view;

        if(motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN){

          if(!p.isGameFinished()) {
              p.isTouchSelection(motionEvent.getX(), motionEvent.getY());
          }

        }

        if(motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {

         if(!p.isGameFinished())
            p.setPosCurseur(motionEvent.getX(),motionEvent.getY());


        }


        if(motionEvent.getActionMasked() == MotionEvent.ACTION_UP) {

           if(p.getStatusCurseur()) {
               p.dropCoin(motionEvent.getX(), motionEvent.getY());

           }
        }




        return true;
    }
}
