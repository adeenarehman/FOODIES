package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DatabaseHelper db;
    EditText name, email, password, contact;
    Button signup_button;
    TextView login_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = new DatabaseHelper(this);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        contact = (EditText)findViewById(R.id.contact);
        signup_button = (Button)findViewById(R.id.signup_button);
        login_page = (TextView)findViewById(R.id.login_page);

        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, Login.class);
                startActivity(i);
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = name.getText().toString();
                String s2 = email.getText().toString();
                String s3 = password.getText().toString();
                String s4 = contact.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkEmail = db.checkEmail(s1);
                    if (checkEmail == true){
                        Boolean insert = db.insert(s1,s2,s3,s4);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "Registered Successfullly", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}