package com.sandra.turtle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/**
 * Creation par Sandra le 19/07/19
 * @version 1.0
 * cette class permet de faire nager notre belle tortue de haut en bas
 */

public class NagerView extends View {
    private Bitmap turtle;
    private Bitmap gamebackground;
    private Paint scorePaint =  new Paint();
    private Bitmap vie[] =  new Bitmap[2];

    /**
     * pour gerer la premier tortue sur la vue
     * @param context
     */
    public NagerView(Context context) {
        super(context);
        turtle = BitmapFactory.decodeResource(getResources(), R.drawable.turtle);
        gamebackground = BitmapFactory.decodeResource(getResources(), R.drawable.gamebackground);
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        vie[0] =  BitmapFactory.decodeResource(getResources(), R.drawable.heartfull);
        vie[1] =  BitmapFactory.decodeResource(getResources(), R.drawable.heartempty);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(gamebackground, 0,0,null);
        canvas.drawBitmap(turtle,0,0,null);
        canvas.drawText("Score : ",20, 60, scorePaint);

        canvas.drawBitmap(vie[0], 580,10,null);
        canvas.drawBitmap(vie[0], 680,10,null);
        canvas.drawBitmap(vie[0], 780,10,null);


    }
}
