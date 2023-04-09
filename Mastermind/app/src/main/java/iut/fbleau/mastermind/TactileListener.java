package iut.fbleau.mastermind;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class TactileListener implements View.OnTouchListener {



    public TactileListener(Activity act){


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
            System.out.println("tap");


            return true;
        }
        return false;
    }


}