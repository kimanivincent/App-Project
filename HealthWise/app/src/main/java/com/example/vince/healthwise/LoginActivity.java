package com.example.vince.healthwise;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String jina = new String(),word = new String();

                if (jina.isEmpty()||word.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Fill all inputs", Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });
    }
}
