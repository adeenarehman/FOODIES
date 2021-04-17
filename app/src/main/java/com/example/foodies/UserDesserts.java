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

public class UserDesserts extends AppCompatActivity {

//    Button add_data;
    FloatingActionButton back_btn;
    AdapterDessert Adapter;
    RecyclerView DessertsRecyclerView;
    List<ModelDesserts> DessertList;
    DessertData DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        DB = new DessertData(this);

        DessertsRecyclerView = findViewById(R.id.recycler_view);

        DessertList = new ArrayList<ModelDesserts>();
        DessertList = getDessertListFromDB();
//        detailList.add(new DetailModel("Lava Cake", "Soft Cake With Goey Melted Chocolate Center"));
//        detailList.add(new DetailModel("Choclate Pudding", "Soft Pudding"));

        Adapter = new AdapterDessert(this, DessertList);
        DessertsRecyclerView.setAdapter(Adapter);
        DessertsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        back_btn = (FloatingActionButton) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDesserts.this, UserDashboard.class);
                startActivity(intent);
            }
        });
    }

    List<ModelDesserts> getDessertListFromDB()
    {
        List<ModelDesserts> details = new ArrayList<>();
        Cursor cursor = DB.getAllData();

        while (cursor.moveToNext())
        {
            ModelDesserts dessertmodel = new ModelDesserts(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            details.add(dessertmodel);
        }
        return details;
    }
}