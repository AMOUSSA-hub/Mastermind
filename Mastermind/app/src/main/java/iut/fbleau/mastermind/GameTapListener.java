package iut.fbleau.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

public class GameTapListener implements GestureDetector.OnGestureListener {

    private Activity act;

    public GameTapListener(Activity a){
        this.act = a;
    }

    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {

      if(!((GameActivity)act).getPlateau().isGameFinished()) {
          Intent intent = new Intent(act, MainActivity.class);
          this.act.startActivity(intent);

      }
        return true;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
