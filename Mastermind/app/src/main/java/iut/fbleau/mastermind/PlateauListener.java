package iut.fbleau.mastermind;

import android.view.MotionEvent;
import android.view.View;

public class PlateauListener implements View.OnTouchListener {


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Plateau p = (Plateau) view;

        if(motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN){
            System.out.println("down");

            p.isTouchSelection(motionEvent.getX(),motionEvent.getY());


        }

        if(motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {

            p.setPosCurseur(motionEvent.getX(),motionEvent.getY());


        }


        if(motionEvent.getActionMasked() == MotionEvent.ACTION_UP) {

            p.resetCurseur();

        }




        return true;
    }
}
