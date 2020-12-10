package com.example.magistr;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AssetManager assetManager = this.getAssets();
        int[][] map = new MapLoader().load(assetManager,"map.txt");

        Draw2D draw2D = new Draw2D(this, map);

        this.setContentView(draw2D);
    }
}