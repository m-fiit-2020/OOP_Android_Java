package com.example.magistr;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class Field {
	public int fieldComplexity; //Размерность поля nxn, где n - fieldComplexity
	public float cellSize;
	public float top;

	public Field(int fieldComplexity) {
		this.fieldComplexity = fieldComplexity;
	}

	public void paint(Canvas g) {
		cellSize = g.getWidth() / fieldComplexity;
		top = (g.getHeight() - cellSize *fieldComplexity) / 2;

		Paint mPaint = new Paint();
		// Vertical Lines
		mPaint.setColor(Color.RED);
		for(int _i=0; _i<fieldComplexity+1; _i++) {
			g.drawLine(_i* cellSize, top, _i* cellSize, top+ cellSize *fieldComplexity, mPaint);
		}
		// Horizontal Lines
		mPaint.setColor(Color.BLUE);
		for(int _i=0; _i<fieldComplexity+1; _i++) {
			g.drawLine(0, top + _i * cellSize, cellSize * fieldComplexity, top + _i * cellSize, mPaint);
		}
	}
}
