package com.example.muhsyawqi.grafik;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Graph Line
        GraphView grapLine = (GraphView) findViewById(R.id.graphLine);
        LineGraphSeries<DataPoint> seriesLine = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2,-4),
                new DataPoint(3, 10),
                new DataPoint(4, 2),
                new DataPoint(5, 6),
                new DataPoint(6, -2)
        });
        grapLine.addSeries(seriesLine);
        seriesLine.setColor(Color.BLUE);

        GraphView graphBar = (GraphView) findViewById(R.id.graphBar);
        BarGraphSeries<DataPoint> seriesBar = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -5),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graphBar.addSeries(seriesBar);

        seriesBar.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        seriesBar.setSpacing(50);

// draw values on top
        seriesBar.setDrawValuesOnTop(true);
        seriesBar.setValuesOnTopColor(Color.BLUE);

    }
}
