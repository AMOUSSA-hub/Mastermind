package iut.fbleau.mastermind;

import android.graphics.Color;
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
            for(int i = 0 ; i < p.plateau.length ; i += 1 ){
                for (Case c : p.plateau[i]) {
                    if (c.isInside(motionEvent.getX(),motionEvent.getY())) {
                        p.plateau[i][0].setCol(p.curseur.getColor());
                        p.plateau[i][0].setRadius(c.getRadius()+15);
                        System.out.println("touch");
                        return true;

                    }
                }
            }
            p.invalidate();

            System.out.println("LA TOUCHE A ETE RELACHE");

        }




        return true;
    }
}
