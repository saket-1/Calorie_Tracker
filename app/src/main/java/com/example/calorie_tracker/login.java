package com.example.calorie_tracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {


String usernameS = "ll";
String passwordS = "ll";
String usernameP;
String passwordP;
    SharedPreferences sharedPreferences;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.username1);


        password= (EditText) findViewById(R.id.password1);





      //  Toast.makeText(getApplicationContext(),"dd"+usernameP,Toast.LENGTH_LONG).show();


        Button login = (Button) findViewById(R.id.login);
        Button sign =  (Button) findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent i = new Intent(com.example.calorie_tracker.login.this, Signup.class);
                    startActivity(i);
                    finish();


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usernameS = username.getText().toString();
                passwordS = password.getText().toString();
                sharedPreferences=getApplicationContext().getSharedPreferences("com.example.calorie_tracker",MODE_PRIVATE);
                usernameP=(String)sharedPreferences.getString("username","username");
                passwordP=(String)sharedPreferences.getString("password","password");
                if(usernameS.equals(usernameP)&&passwordP.equals(passwordS)) {
                 //   Toast.makeText(getApplicationContext(),"enterrr"+usernameP+usernameS,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(com.example.calorie_tracker.login.this,
                            target.class);

                    startActivity(i);
                    finish();
               }
               else{
                    Toast.makeText(getApplicationContext(),"Incorrect Username or Password",Toast.LENGTH_LONG).show();
              }
            }
});
    }
}
