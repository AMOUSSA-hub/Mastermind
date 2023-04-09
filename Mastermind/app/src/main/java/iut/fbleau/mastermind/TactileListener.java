package iut.fbleau.mastermind;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class TactileListener implements View.OnTouchListener {

    public GestureDetector GD;

    public TactileListener(Activity act){

        GD =  new GestureDetector(new GameTapListener(act));

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        System.out.println("tap");

        GD.onTouchEvent(motionEvent);

        return true;
    }


}