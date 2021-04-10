package com.example.calorie_tracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class target extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences2;
    Double calTarget =0.0;
    Double calGain=0.0;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        getSupportActionBar().hide();

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(100);
        TextView calorieTarget = (TextView) findViewById(R.id.calorietarget);
        TextView calorieGain=(TextView) findViewById(R.id.caloriegain);
        sharedPreferences=getApplicationContext().getSharedPreferences("com.example.calorie_tracker",MODE_PRIVATE);
        Integer weight= Integer.parseInt((String)sharedPreferences.getString("weight","180"));
        Integer height=Integer.parseInt((String)sharedPreferences.getString("height","80"));
        Integer age=Integer.parseInt((String)sharedPreferences.getString("age","25"));
        Double calGain=Double.parseDouble((String)sharedPreferences.getString("calGain","0.0"));


        String gender=(String)sharedPreferences.getString("gender","male");
        if(gender=="male") {
            calTarget = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        }else {
            calTarget = (10 * weight )+ (6.25 * height )- (5 * age )- 161;
        }
        calorieTarget.setText(calTarget.toString());


        calorieGain.setText(calGain.toString());
        if(calTarget<calGain){
            progressBar.setProgress(100);
            progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
        }
        else{
            int percent= (int) ((calGain/calTarget)*100);
            if(percent>75){
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else{
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
            progressBar.setProgress(percent);
        }


        Button yes = (Button) findViewById(R.id.capture_btn);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(com.example.calorie_tracker.target.this,
                        com.example.calorie_tracker.ChooseModel.class);

                startActivity(i);
                finish();
            }
        });
    }
}
