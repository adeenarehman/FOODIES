package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login_email, login_password;
    Button login_button;
    TextView signup_page;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        login_email = (EditText)findViewById(R.id.email);
        login_password = (EditText)findViewById(R.id.password);
        login_button = (Button)findViewById(R.id.login_button);
        signup_page = (TextView)findViewById(R.id.signup_page);

        signup_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, SignUp.class);
                startActivity(i);
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email.getText().toString();
                String password = login_password.getText().toString();

                Boolean emailPassword = db.emailPassword(email, password);
                if (emailPassword == true) {
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent (Login.this, UserDashboard.class);
                    startActivity(intent);

                }


                else if ((email.equals("admin@gmail.com") ) && (password.equals("admin123"))){

                    Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent (Login.this, AdminDashboard.class);

                    startActivity(intent);

                }

                else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}