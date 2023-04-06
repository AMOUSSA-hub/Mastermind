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
    public Plateau(Context context, AttributeSet attrs) {

        super(context, attrs);
        plateau = new Case[4][10];

        for (int y = 0; y <= 9; y++) {
            for (int x = 0; x <= 3; x++) {
                plateau[x][y]= new Case();
            }
        }



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
        float circleRadius = 0.02f * getHeight();
        float circleSpacingX = boxWidth / 4;
        float circleSpacingY = boxHeight / 10;
        float circleOffsetX = circleSpacingX / 2;
        float circleOffsetY = circleSpacingY / 2;

        //dessine les rectangles du plateau
        canvas.drawPath(RoundedRect(boxLeft, boxTop, boxRight, boxBottom, 30, 30, false), pinceau);
        canvas.drawPath(RoundedRect((float)0.65*getWidth(),0,getWidth(),(float)0.85*getHeight(),30,30,false),pinceau);
        canvas.drawPath(RoundedRect(0,(float)0.87*getHeight(),getWidth(),getHeight(),50,50,false),pinceau);






        for (int y = 0; y <= 9; y++) {
            for (int x = 0; x <= 3; x++) {

                float circleX = circleSpacingX * x  + circleOffsetX;
                float circleY = circleSpacingY * y  + circleOffsetY;

                plateau[x][y].setPosX(circleX);


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
        for(int i = 1; i<= 4 ; i++) {

            if(i ==1)pinceau.setColor(Color.RED);
            if(i ==2)pinceau.setColor(Color.BLUE);
            if(i ==3)pinceau.setColor(Color.GREEN);
            if(i ==4)pinceau.setColor(Color.YELLOW);
            canvas.drawCircle((float)((0.2 * getWidth()) * i), (float) (0.935 * getHeight()), (float) (0.03 * getHeight()), pinceau);


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
        path.rQuadTo(0, -ry, -rx, -ry);//top-right corner
        path.rLineTo(-widthMinusCorners, 0);
        path.rQuadTo(-rx, 0, -rx, ry); //top-left corner
        path.rLineTo(0, heightMinusCorners);

        if (conformToOriginalPost) {
            path.rLineTo(0, ry);
            path.rLineTo(width, 0);
            path.rLineTo(0, -ry);
        }
        else {
            path.rQuadTo(0, ry, rx, ry);//bottom-left corner
            path.rLineTo(widthMinusCorners, 0);
            path.rQuadTo(rx, 0, rx, -ry); //bottom-right corner
        }

        path.rLineTo(0, -heightMinusCorners);

        path.close();//Given close, last lineto can be removed.

        return path;
    }



}
