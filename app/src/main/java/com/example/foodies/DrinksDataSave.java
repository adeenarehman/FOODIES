package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class DrinksDataSave extends AppCompatActivity {

    EditText data_name, data_description, data_price;
    Button save_detail, back ;
    DrinksData DBDrinks;
    String name, description, price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_data_save);


        data_name = (EditText)findViewById(R.id.save_data_name);
        data_description = (EditText)findViewById(R.id.save_data_description);
        save_detail = (Button)findViewById(R.id.save_detail);
        data_price = (EditText)findViewById(R.id.save_data_price);
        back = (Button)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DrinksDataSave.this, AdminDrinks.class);
                startActivity(i);
            }
        });


        save_detail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (data_name.getText().toString().equals(""))
                {
                    data_name.setError("Enter Item Name");
                    return;
                }
                else if (data_description.getText().toString().equals(""))
                {
                    data_description.setError("Enter Item Description");
                    return;
                }
                else if (data_price.getText().toString().equals(""))
                {
                    data_price.setError("Enter Item Price");
                    return;
                }

                DBDrinks = new DrinksData(DrinksDataSave.this);


                name= data_name.getText().toString();
                description = data_description.getText().toString();
                price = data_price.getText().toString();

                long drink_id = DBDrinks.insertData(name,description,price);

                if (drink_id == -1) {
                    Toast.makeText(getApplicationContext(), "Unable to insert data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Successfully inserted data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DrinksDataSave.this, AdminDrinks.class);
                    startActivity(intent);
                }



            }
        });
    }
}