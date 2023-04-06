package iut.fbleau.mastermind;

import android.graphics.Color;

public class Case {
    private float posX;
    private float posY;
    private float radius;

    int col;
    public Case (){

        col = 0 ;


    }

    public int getColor(){
        return col;


    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getRadius() {
        return radius;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }



    public void setCol(int col) {
        this.col = col;
    }

    public boolean isInside( float x, float y){
        System.out.println("X :pos case:"+this.posX+" pos doigt:"+x);
        System.out.println("Y: pos case:"+this.posY+" pos doigt:"+y);
        if( x<= posX+radius && x>= posX-radius && y<=posY+radius&& y>= posY-radius) {
            return true;
        }
        return false;
    }
}
