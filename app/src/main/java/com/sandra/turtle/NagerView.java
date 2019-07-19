package com.sandra.turtle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

/**
 * Creation par Sandra le 19/07/19
 * @version 1.0
 * cette class permet de faire nager notre belle tortue de haut en bas
 * permet de deplacer sa bonne nourriture de droite a gauche
 * permet de deplacer les dechets de l'ocean de droite a gauche
 */

public class NagerView extends View {
    private Bitmap turtle[] = new Bitmap[2];

    private int turtleX = 10;
    private int turtleY;
    private int turtleSpeed;

    private int canvasWidth, canvasHeight;

    private Bitmap bouffe;
    private int bouffeX, bouffeY, bouffeSpeed;

    private Bitmap notbouffe;
    private int notbouffeX, notbouffeY, notbouffeSpeed;

    private boolean touch = false;

    private Bitmap gamebackground;
    private Paint scorePaint =  new Paint();
    private Bitmap vie[] =  new Bitmap[2];


    /**
     * pour gerer la premier tortue sur la vue
     * @param context
     */
    public NagerView(Context context) {
        super(context);
        // affichage de notre petite tortue
        turtle[0] = BitmapFactory.decodeResource(getResources(), R.drawable.turtle);
        turtle[1] = BitmapFactory.decodeResource(getResources(), R.drawable.turtlered);


        //affichage de l'ecran de fond
        gamebackground = BitmapFactory.decodeResource(getResources(), R.drawable.gamebackground);

        //affichage de sa bonne et sa mauvaise nourriture
        bouffe =  BitmapFactory.decodeResource(getResources(),R.drawable.bouffe);
        notbouffe =  BitmapFactory.decodeResource(getResources(),R.drawable.notbouffe);

        // creation du score avec style
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        //affichage des coeurs de vie
        vie[0] =  BitmapFactory.decodeResource(getResources(), R.drawable.heartfull);
        vie[1] =  BitmapFactory.decodeResource(getResources(), R.drawable.heartempty);

        // gestion des tortues ( normal et red pour un tortue blessee)

        turtleY = 500;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight =  canvas.getHeight();

        canvas.drawBitmap(gamebackground, 0,0,null);

        int minTurtleY =  turtle[0].getHeight();
        int maxTurtleY =  canvasHeight - turtle[0].getHeight() * 3;

        // pour les deplacements de la tortue de haut en bas
        turtleY =  turtleY + turtleSpeed;
        if(turtleY < minTurtleY){
            turtleY =  minTurtleY;
        }
        if(turtleY > maxTurtleY){
            turtleY =  maxTurtleY;
        }

        turtleSpeed =  turtleSpeed +2;

        if(touch){
            canvas.drawBitmap(turtle[1],turtleX,turtleY,null);
            touch =  false;
        }
        else{
            canvas.drawBitmap(turtle[0], turtleX, turtleY, null);
        }
        // pour le deplacement de la bonne nourriture
        bouffeX =  bouffeX - bouffeSpeed;
        if (bouffeX < 0){
            bouffeX =  canvasWidth + 21;
            bouffeY =  (int) Math.floor(Math.random() * (maxTurtleY - minTurtleY) + minTurtleY);
        }

        public boolean eatBouffeChecker(int x, int y){
            if(turtleX < x && x < (turtleX + turtle[0].getWidth()) && turtleY < y && y < ( turtleY + turtle[0].getHeight())){
               // return true;
            }
          //  return false;
        }


        // taille du score sur la vue
        canvas.drawText("Score : ",20, 60, scorePaint);

        //positionnement des coeurs sur la vue
        canvas.drawBitmap(vie[0], 500,10,null);
        canvas.drawBitmap(vie[0], 550,10,null);
        canvas.drawBitmap(vie[0], 600,10,null);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            touch =  true;
            turtleSpeed =  -22;
        }
        return true;
    }

}
