package com.project.appchinese.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.project.appchinese.R;

public class Exo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo1);
        readCsv();
        generateEXo1();
    }

    private List<Line> lines = new ArrayList<>();

    private void readCsv(){
        InputStream is = getResources().openRawResource(R.raw.chinese);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line ="";
        try {
            reader.readLine();
            while ( (line = reader.readLine()) != null) {
                //Split by ','
                String[] tokens = line.split(",");

                //Read the data of the line stored in token
                Line line1 = new Line();
                line1.setFrançais(tokens[1]);
                line1.setHanzi(tokens[2]);
                line1.setPinyin(tokens[3]);
                lines.add(line1); //add the data of the line to the list

                Log.d("MyActivity", "Just created" + line1);
            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line,e);
            e.printStackTrace();
        }
    }


    public void generateEXo1(){
        ListIterator<Line> it = lines.listIterator();
        int size = lines.size();
        for(int i =0; i< size; i++){
            System.out.println(lines.get(i));
        }
    }



}
