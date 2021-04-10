package com.example.calorie_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class done extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);



        Button scan = (Button) findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(com.example.calorie_tracker.done.this,
                        camera.class);

                startActivity(i);
                finish();



            }
        });
    }
}
