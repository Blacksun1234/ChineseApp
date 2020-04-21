package com.project.appchinese.activity.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.project.appchinese.R;
import com.project.appchinese.models.Database;

import java.util.List;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        GraphView graph = findViewById(R.id.graph);

        List<Integer> grades = Database.getInstance().getGrades();

        DataPoint[] dataPoints = new DataPoint[grades.size()];
        for(int i = 0; i < grades.size(); i++) {
            dataPoints[i] = new DataPoint(i, grades.get(i));
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
        graph.addSeries(series);
    }

    public void marks(){

    }
}
