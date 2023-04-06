

package iut.fbleau.mastermind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class Plateau extends View {

    Case [][] plateau;
    Case[] selection;
    Case curseur;
    boolean active_curseur;
    public Plateau(Context context, AttributeSet attrs) {
        super(context, attrs);

        curseur = new Case();
        active_curseur = false;
        plateau = new Case[4][10];
        selection = new Case[4];

        for (int y = 0; y <= 9; y++) {
            for (int x = 0; x <= 3; x++) {
                plateau[x][y]= new Case();
            }
        }

        for(int i =0 ; i<= 3; i++){
            selection[i] = new Case();
        }



    }

    public void activeCurseur(boolean b){
        this.active_curseur = b;
    }


    public void setPosCurseur( float x , float y){
        curseur.setPosX(x);
        curseur.setPosY(y);
        this.invalidate();

    }

    public void resetCurseur(){
        activeCurseur(false);
        this.invalidate();

    }

    public boolean isTouchSelection( float x,float y ) {
        System.out.println("test_selection");
        for (Case c : selection) {
            if (c.isInside(x, y)) {
                curseur.setCol(c.getColor());
                curseur.setRadius(c.getRadius()*2);
                this.activeCurseur(true);
                System.out.println("touch");
                return true;

            }
        }

        return false;
    }






    @Override
    protected void onDraw(Canvas canvas) {


        Paint pinceau = new Paint();
        canvas.drawColor(Color.TRANSPARENT);

        pinceau.setColor(Color.rgb(24,24,24));



        float boxLeft = 0;
        float boxTop = 0;
        float boxRight = 0.6f * getWidth();
        float boxBottom = 0.85f * getHeight();
        float boxWidth = boxRight - boxLeft;
        float boxHeight = boxBottom - boxTop;


        //dessine les rectangles du plateau
        canvas.drawPath(RoundedRect(boxLeft, boxTop, boxRight, boxBottom, 30, 30, false), pinceau);
        canvas.drawPath(RoundedRect((float)0.65*getWidth(),0,getWidth(),(float)0.85*getHeight(),30,30,false),pinceau);
        canvas.drawPath(RoundedRect(0,(float)0.87*getHeight(),getWidth(),getHeight(),50,50,false),pinceau);




        float circleRadius = 0.02f * getHeight();
        float circleSpacingX = boxWidth / 4;
        float circleSpacingY = boxHeight / 10;
        float circleOffsetX = circleSpacingX / 2;
        float circleOffsetY = circleSpacingY / 2;

        for (int y = 0; y <= 9; y++) {
            for (int x = 0; x <= 3; x++) {

                float circleX = circleSpacingX * x  + circleOffsetX;
                float circleY = circleSpacingY * y  + circleOffsetY;

                plateau[x][y].setPosX(circleX);
                plateau[x][y].setPosY(circleY);
                plateau[x][y].setRadius(circleRadius);



                if(plateau[x][y].getColor() ==0) {pinceau.setColor(Color.rgb(105, 105, 105));}
                if(plateau[x][y].getColor() ==1) {pinceau.setColor(Color.RED);}
                if(plateau[x][y].getColor() ==2) {pinceau.setColor(Color.BLUE);}
                if(plateau[x][y].getColor() ==3) {pinceau.setColor(Color.GREEN);}
                if(plateau[x][y].getColor() ==4){ pinceau.setColor(Color.YELLOW);}


                circleX = Math.max(circleX, boxLeft + circleRadius);
                circleX = Math.min(circleX, boxRight - circleRadius);
                circleY = Math.max(circleY, boxTop + circleRadius);
                circleY = Math.min(circleY, boxBottom - circleRadius);
                canvas.drawCircle(circleX, circleY, circleRadius, pinceau);
            }
        }


        //les ronds de la selection
        for(int i = 0; i<= 3 ; i++) {

            float pos_x = (float)((0.2 * getWidth()) * (1+i));
            float pos_y = (float) (0.935 * getHeight());
            float rad = (float) (0.03 * getHeight());
            if(i ==0)pinceau.setColor(Color.RED);
            if(i ==1)pinceau.setColor(Color.BLUE);
            if(i ==2)pinceau.setColor(Color.GREEN);
            if(i ==3)pinceau.setColor(Color.YELLOW);
            canvas.drawCircle(pos_x, pos_y, rad, pinceau);

            selection[i].setCol(i+1);

            selection[i].setPosX(pos_x);
            selection[i].setPosY(pos_y);
            selection[i].setRadius((rad));


        }

        if(active_curseur){

            if(curseur.getColor() ==1) {pinceau.setColor(Color.RED);}
            if(curseur.getColor() ==2) {pinceau.setColor(Color.BLUE);}
            if(curseur.getColor() ==3) {pinceau.setColor(Color.GREEN);}
            if(curseur.getColor() ==4){ pinceau.setColor(Color.YELLOW);}
            canvas.drawCircle(curseur.getPosX(), curseur.getPosY(), curseur.getRadius(), pinceau);
        }





    }

    public Path RoundedRect(float left, float top, float right, float bottom, float rx, float ry, boolean conformToOriginalPost) {
        Path path = new Path();
        if (rx < 0) rx = 0;
        if (ry < 0) ry = 0;
        float width = right - left;
        float height = bottom - top;
        if (rx > width/2) rx = width/2;
        if (ry > height/2) ry = height/2;
        float widthMinusCorners = (width - (2 * rx));
        float heightMinusCorners = (height - (2 * ry));

        path.moveTo(right, top + ry);
        path.rQuadTo(0, -ry, -rx, -ry);
        path.rLineTo(-widthMinusCorners, 0);
        path.rQuadTo(-rx, 0, -rx, ry);
        path.rLineTo(0, heightMinusCorners);

        if (conformToOriginalPost) {
            path.rLineTo(0, ry);
            path.rLineTo(width, 0);
            path.rLineTo(0, -ry);
        }
        else {
            path.rQuadTo(0, ry, rx, ry);
            path.rLineTo(widthMinusCorners, 0);
            path.rQuadTo(rx, 0, rx, -ry);
        }

        path.rLineTo(0, -heightMinusCorners);

        path.close();

        return path;
    }



}


