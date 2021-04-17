package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminDashboard extends AppCompatActivity {

    CardView desserts, juices, fast_food, traditional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        desserts = (CardView)findViewById(R.id.admin_desserts);
        juices = (CardView)findViewById(R.id.admin_juices);
        fast_food = (CardView)findViewById(R.id.admin_fast_food);
        traditional = (CardView)findViewById(R.id.admin_traditional);

        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminDashboard.this, AdminDesserts.class);
                startActivity(i);
            }
        });

        juices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminDashboard.this, AdminDrinks.class);
                startActivity(i);
            }
        });

        fast_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminDashboard.this, AdminFastFood.class);
                startActivity(i);
            }
        });

        traditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminDashboard.this, AdminTraditionalFoods.class);
                startActivity(i);
            }
        });

    }


}