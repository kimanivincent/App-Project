package com.example.vince.relativeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView titleone;
    Button mButton1,mButton2;
    ImageView imageone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleone = findViewById(R.id.tvtitle);
        mButton1 = findViewById(R.id.btnone);
        mButton2 = findViewById(R.id.btntwo);
        imageone = findViewById(R.id.imgone);

        titleone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello Vincent Kimani", Toast.LENGTH_SHORT).show();
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Register Now!!!", Toast.LENGTH_SHORT).show();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login Now!!", Toast.LENGTH_SHORT).show();
            }
        });

        imageone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Have a great day", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
