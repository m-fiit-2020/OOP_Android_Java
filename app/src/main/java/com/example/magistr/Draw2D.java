package com.example.magistr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Bitmap unitBitmap;
    private Bitmap wallBitmap;
    private Field field;
    final private int[][] map;

    public Draw2D(Context context, int[][] map) {
        super(context);
        this.map = map;
        // Выводим значок из ресурсов
        Resources res = this.getResources();
        unitBitmap = BitmapFactory.decodeResource(res, R.drawable.p0);
        wallBitmap = BitmapFactory.decodeResource(res, R.drawable.wall);
        field = new Field(map.length);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Background Color
        mPaint.setColor(Color.WHITE);
        //Поле
        field.paint(canvas);
        //Wall
        Bitmap wall = Bitmap.createBitmap(wallBitmap, 0, 0, Math.round(field.cellSize), Math.round(field.cellSize));
        //mPaint.setColor(Color.GRAY);
        canvas.drawBitmap(wall, 100, 0, mPaint);
        for(int _i=0; _i<this.map.length; _i++) {
            for(int _j=0; _j<this.map.length; _j++) {
                if(this.map[_j][_i]==1)
                    canvas.drawBitmap(wall, _i*field.cellSize, field.top+_j*field.cellSize, mPaint);
            }
        }

        //Unit
        Bitmap cropped = Bitmap.createBitmap(unitBitmap,0,0, 170, 150);
        canvas.drawBitmap(cropped, 0, 0, mPaint);
        //Mirror Unit
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f,1.0f);
        Bitmap mirrored = Bitmap.createBitmap(cropped,0,0, cropped.getWidth(), cropped.getHeight(), matrix, false);
        canvas.drawBitmap(mirrored, 300, 0, mPaint);
    }
}
