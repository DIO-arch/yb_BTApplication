package com.example.josephblan.btapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.LinkedList;
import java.util.Random;






import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.LinkedList;
import java.util.Random;
public class MainActivityGraph extends Activity {

        public LinkedList<String> stringList;
        ListView lv;

        double start, end, step, ymax, ymin;
        private static MainActivityGraph instance;
        GraphView gv;
        int i = 0;
        int range1 = new Random().nextInt(19) + 1;
        int[] n = RandomTesting(range1);

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_graph);
            instance = this;
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
            //settings
            start = 1;
            end = 20;
            ymin = 0;
            ymax = 256;
            step = 1;

            gv = findViewById(R.id.gv_graph);
            gv.getViewport().setYAxisBoundsManual(true);
            gv.getViewport().setXAxisBoundsManual(true);
            gv.getViewport().setMaxX(end);
            gv.getViewport().setMinX(start);
            gv.getViewport().setMinY(ymin);
            gv.getViewport().setMaxY(ymax);

            DataPoint[] dp = new DataPoint[n.length];
            int s;
            for (s = 0; s < dp.length; s++){
                dp[s]= new DataPoint(s + 1, n[s]);
            }
            BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dp);
            gv.addSeries(series);

// styling
            series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                @Override
                public int get(DataPoint data) {
                    return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
                }
            });

            series.setSpacing(50);

// draw values on top
            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);

        }
        public int[] RandomTesting(int range1){
            Random r = new Random();
            int range2;
            int[] n = new int[range1];
            for (i = 0; i < range1; i++) {
                range2 = r.nextInt(256);
                n[i] = range2;
            }
            return n;
        }
        public void onClick(View view) {
            Intent i = new Intent(this, MainActivityGraph.class);
            startActivity(i);
        }
    }
