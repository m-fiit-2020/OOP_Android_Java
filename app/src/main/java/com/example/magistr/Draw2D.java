package com.example.magistr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
<<<<<<< HEAD
=======
import android.graphics.Rect;
import android.view.MotionEvent;
>>>>>>> b804f493298034498739e3e136f8afdbe7232772
import android.view.View;

public class Draw2D extends View implements Runnable{

    private Paint mPaint = new Paint();
    private Bitmap unitBitmap;
    private Bitmap wallBitmap;
    private Field field;
    final private int[][] map;

    SpriteSheetProvider spriteSheetProvider = new SpriteSheetProvider(this);
    UnitCont unitCont;

    public Draw2D(Context context, int[][] map) {
        super(context);
        this.map = map;
        // Выводим значок из ресурсов
        Resources res = this.getResources();
        unitBitmap = BitmapFactory.decodeResource(res, R.drawable.p0);
<<<<<<< HEAD
        wallBitmap = BitmapFactory.decodeResource(res, R.drawable.wall);
        field = new Field(map.length);

=======
        field = new Field(map);
        unitCont = new UnitCont(this);

        Thread t = new Thread(this);
        t.start();
>>>>>>> b804f493298034498739e3e136f8afdbe7232772
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Background Color
        mPaint.setColor(Color.WHITE);
<<<<<<< HEAD
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
=======
        canvas.drawPaint(mPaint);

        // Рисуем желтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        // canvas.drawCircle(950, 30, 25, mPaint);
        canvas.drawCircle(width - 30, 30, 25, mPaint);

        // Рисуем зеленый прямоугольник
        mPaint.setColor(Color.GREEN);
        //  canvas.drawRect(20, 650, 950, 680, mPaint);
        canvas.drawRect(0, canvas.getHeight() - 30, width, height, mPaint);

        // Рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        //  canvas.drawText("Лужайка только для котов", 30, 648, mPaint);
        canvas.drawText("Лужайка только для котов", 30, height - 32, mPaint);

        // Текст под углом
        // int x = 810;
        int x = width - 170;
        int y = 190;

        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(27);
        String beam = "Лучик солнца!";

        // Создаем ограничивающий прямоугольник для наклонного текста
        // поворачиваем холст по центру текста
        //canvas.rotate(-45, x + mRect.exactCenterX(), y + mRect.exactCenterY());

        // Рисуем текст
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawText(beam, x, y, mPaint);
        field.paint(canvas);
//        //canvas.drawBitmap(unitBitmap, 0, 0, mPaint);
//        Bitmap cropped = Bitmap.createBitmap(unitBitmap,0,0, 170, 150);
//        canvas.drawBitmap(cropped, 0, 0, mPaint);
//
//        Matrix matrix = new Matrix();
//        matrix.preScale(-1.0f,1.0f);
//        Bitmap mirrored = Bitmap.createBitmap(cropped,0,0, cropped.getWidth(), cropped.getHeight(), matrix, false);
//        canvas.drawBitmap(mirrored, 300, 0, mPaint);

        unitCont.paint(canvas);
        // восстанавливаем холст
        //canvas.restore();

        // Выводим изображение
        // canvas.drawBitmap(mBitmap, 450, 530, mPaint);
        canvas.drawBitmap(mBitmap, width - mBitmap.getWidth(), height - mBitmap.getHeight() - 10, mPaint);
        canvas.save();

    }
    public SpriteSheet getSpriteSheet(int id) {
        // TODO Auto-generated method stub
        return spriteSheetProvider.getSpriteSheet(id);
    }

    public void onTouch(MotionEvent event) {
        unitCont.onTouch(event);
    }

    @Override
    public void run() {
        while(true){
            unitCont.refresh();
            this.postInvalidate();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
>>>>>>> b804f493298034498739e3e136f8afdbe7232772
    }
}
