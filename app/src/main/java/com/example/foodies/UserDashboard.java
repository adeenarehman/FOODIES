package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserDashboard extends AppCompatActivity {

    CardView desserts, juices, fast_food, traditional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        desserts = (CardView)findViewById(R.id.desserts);
        juices = (CardView)findViewById(R.id.juices);
        fast_food = (CardView)findViewById(R.id.fast_food);
        traditional = (CardView)findViewById(R.id.traditional);

        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserDashboard.this, UserDesserts.class);
                startActivity(i);
            }
        });

        juices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(UserDashboard.this, UserDrinks.class);
                startActivity(j);
            }
        });

        fast_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(UserDashboard.this, UserFastFood.class);
                startActivity(k);
            }
        });

        traditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(UserDashboard.this, UserTraditionalFoods.class);
                startActivity(l);
            }
        });

    }


}