package com.fedemcode.uruguaysevacuna;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    LineChart mpLineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        mpLineChart = (LineChart) findViewById(R.id.line_chart);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(),"Evolucion de fallecidos por COVID-19");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

    }

     private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
         dataVals.add(new Entry(0,46));
         dataVals.add(new Entry(1,66));
         dataVals.add(new Entry(2,53));
         dataVals.add(new Entry(3,53));
         dataVals.add(new Entry(0,55));
         dataVals.add(new Entry(0,72));
         dataVals.add(new Entry(0,65));

         return dataVals;

    }
}