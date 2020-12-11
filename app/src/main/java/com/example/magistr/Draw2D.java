package com.example.magistr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;
    private Bitmap unitBitmap;
    Field field = null;

    SpriteSheetProvider spriteSheetProvider = new SpriteSheetProvider(this);
    UnitCont unitCont = new UnitCont(this);

    public Draw2D(Context context, int[][] map) {
        super(context);
        // Выводим значок из ресурсов
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.cat_bottom);
        unitBitmap = BitmapFactory.decodeResource(res, R.drawable.p0);
        field = new Field(map);
        unitCont.refresh();
    }

    @Override
    protected void onDraw(Canvas canvas){ super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
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
}
