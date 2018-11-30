package com.example.vince.e_health;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login,register,page;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.edtone);
        password = findViewById(R.id.edttwo);
        login = findViewById(R.id.btnone);
        register = findViewById(R.id.btntwo);
        page = findViewById(R.id.btnfive);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        login.setOnClickListener(new View.OnClickListener() {

             @Override
            public void onClick(View view) {
                 String jina = username.getText().toString();
                 String word = password.getText().toString();

                 if (jina.isEmpty()||word.isEmpty())
                 {
                     Toast.makeText(LoginActivity.this, "Fill All Spaces", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Long time = System.currentTimeMillis();
                     DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Watu/"+time);
                     Item x = new Item(jina,word);
                     dialog.show();
                     ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                         @Override
                         public void onComplete(@NonNull Task<Void> task) {
                             dialog.dismiss();
                             if (task.isSuccessful())
                             {
                                 Toast.makeText(LoginActivity.this, "Logged In successfully", Toast.LENGTH_SHORT).show();
                                 Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                 startActivity(intent);
                                 username.setText("");
                                 password.setText("");
                                                              }
                             else
                             {
                                 Toast.makeText(LoginActivity.this, "Saving Failed", Toast.LENGTH_SHORT).show();
                             }
                         }
                     });


                 }
            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });



    }
}