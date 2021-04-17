package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class UserTraditionalFoods extends AppCompatActivity {

    //    Button add_data;
    FloatingActionButton back_btn;
    AdapterTraditional Adapter;
    RecyclerView TraditionalRecyclerView;
    List<ModelTraditional> TraditionalList;
    TraditionalFoodData DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_foods);

        DB = new TraditionalFoodData(this);

        TraditionalRecyclerView = findViewById(R.id.recycler_view);

        TraditionalList = new ArrayList<ModelTraditional>();
        TraditionalList = getTraditionalListFromDB();
//        detailList.add(new DetailModel("Lava Cake", "Soft Cake With Goey Melted Chocolate Center"));
//        detailList.add(new DetailModel("Choclate Pudding", "Soft Pudding"));

        Adapter = new AdapterTraditional(this, TraditionalList);
        TraditionalRecyclerView.setAdapter(Adapter);
        TraditionalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        back_btn = (FloatingActionButton) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserTraditionalFoods.this, UserDashboard.class);
                startActivity(intent);
            }
        });
//
//        add_data.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desserts.this, DataSave.class);
//                startActivity(intent);
//            }
//        });
    }

    List<ModelTraditional> getTraditionalListFromDB()
    {
        List<ModelTraditional> details = new ArrayList<>();
        Cursor cursor = DB.getAllData();

        while (cursor.moveToNext())
        {
            ModelTraditional traditional_model = new ModelTraditional(cursor.getString(0), cursor.getString(1),cursor.getString(2));
            details.add(traditional_model);
        }
        return details;
    }
}