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

public class AdminDrinks extends AppCompatActivity {

    FloatingActionButton add_data,back_btn;
    AdapterDrinks Adapter;
    RecyclerView DetailRecyclerView;
    List<ModelDrinks> DrinksList;
    DrinksData DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_drinks);

        DB = new DrinksData(this);

        DetailRecyclerView = findViewById(R.id.recycler_view);

        DrinksList = new ArrayList<ModelDrinks>();
        DrinksList = getDrinksListFromDB();
//        detailList.add(new DetailModel("Lava Cake", "Soft Cake With Goey Melted Chocolate Center"));
//        detailList.add(new DetailModel("Choclate Pudding", "Soft Pudding"));

        Adapter = new AdapterDrinks(this, DrinksList);
        DetailRecyclerView.setAdapter(Adapter);
        DetailRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        add_data = (FloatingActionButton)findViewById(R.id.add_detail);
        back_btn = (FloatingActionButton)findViewById(R.id.back_btn);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDrinks.this, DrinksDataSave.class);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDrinks.this, AdminDashboard.class);
                startActivity(intent);
            }
        });
    }

    List<ModelDrinks> getDrinksListFromDB()
    {
        List<ModelDrinks> details = new ArrayList<>();
        Cursor cursor = DB.getAllData();

        while (cursor.moveToNext())
        {
            ModelDrinks drinks_model = new ModelDrinks(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            details.add(drinks_model);
        }
        return details;
    }
}