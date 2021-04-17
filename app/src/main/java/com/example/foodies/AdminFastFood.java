package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AdminFastFood extends AppCompatActivity {

    FloatingActionButton add_data,back_btn;
    AdapterFastFood Adapter;
    RecyclerView DetailRecyclerView;
    List<ModelFastFood> FastfoodList;
    FastFoodData DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_fast_food);

        DB = new FastFoodData(this);

        DetailRecyclerView = findViewById(R.id.recycler_view);

        FastfoodList = new ArrayList<ModelFastFood>();
        FastfoodList = getDetailListFromDB();
//        detailList.add(new DetailModel("Lava Cake", "Soft Cake With Goey Melted Chocolate Center"));
//        detailList.add(new DetailModel("Choclate Pudding", "Soft Pudding"));

        Adapter = new AdapterFastFood(this, FastfoodList);
        DetailRecyclerView.setAdapter(Adapter);
        DetailRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        add_data = (FloatingActionButton)findViewById(R.id.add_detail);
        back_btn = (FloatingActionButton)findViewById(R.id.back_btn);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminFastFood.this, FastFoodDataSave.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminFastFood.this, AdminDashboard.class);
                startActivity(intent);
            }
        });
    }

    List<ModelFastFood> getDetailListFromDB()
    {
        List<ModelFastFood> details = new ArrayList<>();
        Cursor cursor = DB.getAllData();

        while (cursor.moveToNext())
        {
            ModelFastFood fastfood_model = new ModelFastFood(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            details.add(fastfood_model);
        }
        return details;
    }
}