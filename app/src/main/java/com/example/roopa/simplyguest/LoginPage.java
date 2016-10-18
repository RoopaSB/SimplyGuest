package com.example.roopa.simplyguest;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button login;
    EditText et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        login = (Button) findViewById(R.id.loginButton);
        et_email = (EditText) findViewById(R.id.loginEmail);
        et_password = (EditText) findViewById(R.id.loginPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                if (email.equals("") || email.equals("Email")||password.equals("")||password.equals("Password")) {
                    Toast.makeText(getApplicationContext(), "Please enter all the details!!", Toast.LENGTH_SHORT).show();
                } else {

                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        Toast.makeText(getApplication(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menus, menu);
        return true;
    }
}



