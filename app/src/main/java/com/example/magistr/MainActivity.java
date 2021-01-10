package com.example.magistr;

<<<<<<< HEAD
=======
import androidx.appcompat.app.AppCompatActivity;

>>>>>>> b804f493298034498739e3e136f8afdbe7232772
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

<<<<<<< HEAD
public class MainActivity extends Activity {

=======
public class MainActivity extends Activity implements View.OnTouchListener {
    Draw2D draw2D;
>>>>>>> b804f493298034498739e3e136f8afdbe7232772
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AssetManager assetManager = this.getAssets();
        int[][] map = new MapLoader().load(assetManager,"map.txt");

<<<<<<< HEAD
        Draw2D draw2D = new Draw2D(this, map);
=======
        draw2D = new Draw2D(this, map);
        draw2D.setOnTouchListener(this);
        this.setContentView(draw2D);

        //setContentView(R.layout.activity_main);

>>>>>>> b804f493298034498739e3e136f8afdbe7232772

        this.setContentView(draw2D);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        draw2D.onTouch(event);
        draw2D.postInvalidate();
        return false;
    }
}