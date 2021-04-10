package com.example.calorie_tracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

  //  SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences;
    EditText username;
    EditText password;
    EditText height;
    EditText weight;
    EditText age;
    EditText name;
    RadioGroup gender;
    RadioButton id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        gender=(RadioGroup) findViewById(R.id.gender);
        age = (EditText) findViewById(R.id.age);
        name = (EditText) findViewById(R.id.name);
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sharedPreferences=getApplicationContext().getSharedPreferences("com.example.calorie_tracker",Context.MODE_PRIVATE);
                String temp=String.valueOf(charSequence);
                //  Toast.makeText(getApplicationContext(),"gg"+temp,Toast.LENGTH_LONG).show();
                sharedPreferences.edit().putString("age",temp).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        username = (EditText) findViewById(R.id.username);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sharedPreferences=getApplicationContext().getSharedPreferences("com.example.calorie_tracker",Context.MODE_PRIVATE);
                String temp=String.valueOf(charSequence);
                //  Toast.makeText(getApplicationContext(),"gg"+temp,Toast.LENGTH_LONG).show();
                sharedPreferences.edit().putString("username",temp).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password = (EditText) findViewById(R.id.password);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sharedPreferences=getApplicationContext().getSharedPreferences("com.example.calorie_tracker",Context.MODE_PRIVATE);
                String temp=String.valueOf(charSequence);
                //  Toast.makeText(getApplicationContext(),"gg"+temp,Toast.LENGTH_LONG).show();
                sharedPreferences.edit().putString("password",temp).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        height = (EditText) findViewById(R.id.height);
        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sharedPreferences=getApplicationContext().getSharedPreferences("com.example.calorie_tracker",Context.MODE_PRIVATE);
                String temp=String.valueOf(charSequence);
                //  Toast.makeText(getApplicationContext(),"gg"+temp,Toast.LENGTH_LONG).show();
                sharedPreferences.edit().putString("height",temp).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        weight = (EditText) findViewById(R.id.weight);
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sharedPreferences=getApplicationContext().getSharedPreferences("com.example.calorie_tracker",Context.MODE_PRIVATE);
                String temp=String.valueOf(charSequence);
                //  Toast.makeText(getApplicationContext(),"gg"+temp,Toast.LENGTH_LONG).show();
                sharedPreferences.edit().putString("weight",temp).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });



        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //sharedPreferences.edit().putString("password",passwordS).apply();
                int selectedId=gender.getCheckedRadioButtonId();


                //Toast.makeText(getApplicationContext(),"select id is: "+genderstring,Toast.LENGTH_LONG).show();

                if(name.getText().toString().trim().isEmpty() || age.getText().toString().trim().isEmpty() || height.getText().toString().trim().isEmpty() ||weight.getText().toString().trim().isEmpty()
                || username.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty() || selectedId==-1){
                    Toast.makeText(getApplicationContext(),"All Fields are mandatory",Toast.LENGTH_LONG).show();
                }
                else {
                    id= (RadioButton) findViewById(selectedId);
                    String genderstring= id.getText().toString();
                    switch (genderstring) {
                        case "male":
                            sharedPreferences = getApplicationContext().getSharedPreferences("com.example.calorie_tracker", Context.MODE_PRIVATE);
                            sharedPreferences.edit().putString("gender", "male").apply();
                            break;
                        case "female":
                            sharedPreferences = getApplicationContext().getSharedPreferences("com.example.calorie_tracker", Context.MODE_PRIVATE);
                            sharedPreferences.edit().putString("gender", "female").apply();
                            break;
                    }

                    Intent i = new Intent(getApplicationContext(), login.class);

                    startActivity(i);
                    finish();
                }
            }
        });



    }
    /*
    public String  onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.female:
                if(checked)
                    return "female";
                    break;
            case R.id.male:
                if(checked)
                    return "male";
                    break;
        }
        return "none";
    }

     */

}
