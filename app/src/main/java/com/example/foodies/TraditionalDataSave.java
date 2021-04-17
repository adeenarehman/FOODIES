package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TraditionalDataSave extends AppCompatActivity {

    EditText data_name, data_description, data_price;
    Button save_detail, back;
    TraditionalFoodData DBTraditional;
    String name, description, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_data_save);

        data_name = (EditText)findViewById(R.id.save_data_name);
        data_description = (EditText)findViewById(R.id.save_data_description);
        data_price = (EditText)findViewById(R.id.save_data_price);
        save_detail = (Button)findViewById(R.id.save_detail);
        back = (Button)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TraditionalDataSave.this, AdminTraditionalFoods.class);
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


                DBTraditional = new TraditionalFoodData(TraditionalDataSave.this);

                name= data_name.getText().toString();
                description = data_description.getText().toString();
                price = data_price.getText().toString();

                long fastfood_id = DBTraditional.insertData(name,description, price);

                if (fastfood_id == -1) {
                    Toast.makeText(getApplicationContext(), "Unable to insert data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Successfully inserted data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TraditionalDataSave.this, AdminTraditionalFoods.class);
                    startActivity(intent);
                }



            }
        });
    }
}
