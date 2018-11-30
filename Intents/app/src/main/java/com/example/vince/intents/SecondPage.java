package com.example.vince.intents;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondPage extends AppCompatActivity {
    Button songa, calling, messaging, mailing, picture, sharing, dialing, mpesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        songa = findViewById(R.id.btnMove);
        calling = findViewById(R.id.btncall);
        messaging = findViewById(R.id.btnsms);
        mailing = findViewById(R.id.btnemail);
        picture = findViewById(R.id.btncamera);
        sharing = findViewById(R.id.btnshare);
        dialing = findViewById(R.id.btndial);
        mpesa = findViewById(R.id.btnpesa);
        songa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondPage.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        calling.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Intent piga = new Intent(Intent.ACTION_CALL);
                piga.setData(Uri.parse("tel:0712345678"));

                startActivity(piga);
            }
        });

        messaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri tumaSms = Uri.parse("tel:0712345678");
                Intent sms = new Intent(Intent.ACTION_VIEW,tumaSms);
                sms.putExtra("sms_o[lbody","Niaje Brathe");
                sms.setType("vnd.android-dir/mms-sms");
                startActivity(sms);
            }
        });

        mailing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendMail = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","abc@gmail.com",null));
                sendMail.putExtra(Intent.EXTRA_SUBJECT,"JOB APPLICATION");
                sendMail.putExtra(Intent.EXTRA_TEXT,"This is my body");
                startActivity(Intent.createChooser(sendMail,"Do you want to send this E-mail??"));
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePic,0);
            }
        });

        sharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"Download app on www.kimtech.com");
                share.setType("text/plain");
                startActivity(share);
            }
        });

        dialing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent piga = new Intent(Intent.ACTION_DIAL);
                piga.setData(Uri.parse("tel:"));
                startActivity(piga);
            }
        });

        mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pesa = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if (pesa !=null){
                    startActivity(pesa);
                }
                else
                {
                    Toast.makeText(SecondPage.this, "No stk found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
