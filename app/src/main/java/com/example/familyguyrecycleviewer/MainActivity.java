package com.example.familyguyrecycleviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<DataModel> dataSet;
    private CustomAdapter adapter;

    private MediaPlayer media;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media = MediaPlayer.create(this, R.raw.familyguythemesong);
        media.setLooping(true);
        media.start();


        recyclerView = findViewById(R.id.res);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dataSet = new ArrayList<>();
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for(int i = 0; i < MyData.images.length; i++){
            dataSet.add(new DataModel(
                    MyData.characterName[i],
                    MyData.desc[i],
                    MyData.images[i]
            ));
        }

        adapter = new CustomAdapter(dataSet);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (media != null) {
            media.release(); // Release MediaPlayer resources
            media = null;
        }
    }
}
