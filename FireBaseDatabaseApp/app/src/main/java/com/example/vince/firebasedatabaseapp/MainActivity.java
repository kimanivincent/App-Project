package com.example.vince.firebasedatabaseapp;

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
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {

    EditText name,email,phone;
    Button save,view;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edtone);
        email = findViewById(R.id.edttwo);
        phone = findViewById(R.id.edtthree);
        save = findViewById(R.id.btnsave);
        view = findViewById(R.id.btnview);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Saving...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jina  = name.getText().toString();
                String arafa  = email.getText().toString();
                String simu  = phone.getText().toString();

                if (jina.isEmpty()||arafa.isEmpty()||simu.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Fill All Inputs", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Long time = System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Watu/"+time);
                    Item x = new Item(jina,arafa,simu);
                    dialog.show();
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                           if (task.isSuccessful())
                           {
                               Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                               name.setText("");
                               email.setText("");
                               phone.setText("");
                           }
                           else
                           {
                               Toast.makeText(MainActivity.this, "Saving Failed", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });

                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UsersActivity.class);
                startActivity(intent);
            }
        });
    }
}
