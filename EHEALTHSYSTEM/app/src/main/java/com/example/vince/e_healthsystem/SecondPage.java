package com.example.vince.e_healthsystem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondPage extends AppCompatActivity {

    Button next, power, move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        next = findViewById(R.id.btntwo);
        power = findViewById(R.id.btnfive);
        move = findViewById(R.id.btnthree);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondPage.this,RegistrationPage.class);
                startActivity(intent);
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendMail = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","abc@gmail.com",null));
                sendMail.putExtra(Intent.EXTRA_SUBJECT,"Recover password");
                sendMail.putExtra(Intent.EXTRA_TEXT,"Recover Password");
                startActivity(Intent.createChooser(sendMail,"Which mail service would like to use??"));
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondPage.this,HomePage.class);
                startActivity(intent);
            }
        });
    }
}
