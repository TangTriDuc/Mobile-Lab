package android.example.bt3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


public class GraphicsView extends View{
    int x=0;
    int y=0;
    int d=100;
    int r=50;
    int i = 0;
   Bitmap[] frames = new Bitmap[16];

    public GraphicsView (Context context) {
        super (context);
        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.anh1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.win1);
        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.anh3);
        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.win4);
        frames[5]= BitmapFactory.decodeResource(getResources(),R.drawable.anh2);
        frames[6]= BitmapFactory.decodeResource(getResources(),R.drawable.win3);
        frames[7]= BitmapFactory.decodeResource(getResources(),R.drawable.anh4);
        frames[8]= BitmapFactory.decodeResource(getResources(),R.drawable.win1);
        frames[9]= BitmapFactory.decodeResource(getResources(),R.drawable.anh2);
        frames[10]= BitmapFactory.decodeResource(getResources(),R.drawable.anh3);
        frames[11]= BitmapFactory.decodeResource(getResources(),R.drawable.anh4);
        frames[12]= BitmapFactory.decodeResource(getResources(),R.drawable.anh1);
        frames[13]= BitmapFactory.decodeResource(getResources(),R.drawable.anh2);
        frames[14]= BitmapFactory.decodeResource(getResources(),R.drawable.anh3);
        frames[15]= BitmapFactory.decodeResource(getResources(), R.drawable.anh3);
    }

    @Override
    protected void onDraw (Canvas canvas) {
        if(i<16){

            canvas.drawBitmap(frames[i], 40, 40, new Paint());

        }
        else {
            i=0;
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        return true;
    }}
