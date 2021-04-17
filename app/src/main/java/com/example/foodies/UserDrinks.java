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

public class UserDrinks extends AppCompatActivity {

    //    Button add_data;
    FloatingActionButton back_btn;
    AdapterDrinks AdapterD;
    RecyclerView DrinksRecylerView;
    List<ModelDrinks> DrinksList;
    DrinksData DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        DB = new DrinksData(this);

        DrinksRecylerView = findViewById(R.id.recycler_view);

        DrinksList = new ArrayList<>();
        DrinksList = getDrinksListFromDB();
//        detailList.add(new DetailModel("Lava Cake", "Soft Cake With Goey Melted Chocolate Center"));
//        detailList.add(new DetailModel("Choclate Pudding", "Soft Pudding"));

        AdapterD = new AdapterDrinks(this, DrinksList);
        DrinksRecylerView.setAdapter(AdapterD);
        DrinksRecylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        back_btn = (FloatingActionButton)findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDrinks.this, UserDashboard.class);
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