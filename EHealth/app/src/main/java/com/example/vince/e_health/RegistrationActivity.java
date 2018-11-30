package com.example.vince.e_health;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    EditText fname,sname,identify,phone,email;
    TextView mf,head;
    CheckBox ml,fl;
    Button save;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fname = findViewById(R.id.edtthree);
        sname = findViewById(R.id.edtfour);
        identify = findViewById(R.id.edtfive);
        phone = findViewById(R.id.edtsix);
        email = findViewById(R.id.edtseven);
        mf = findViewById(R.id.txttwo);
        head = findViewById(R.id.txtone);
        ml = findViewById(R.id.chbone);
        fl = findViewById(R.id.chbtwo);
        save = findViewById(R.id.btnsave);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Saving...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);


        ml.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(RegistrationActivity.this, "Checked", Toast.LENGTH_SHORT).show();
            }
        });

        fl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(RegistrationActivity.this, "Checked", Toast.LENGTH_SHORT).show();
            }
        });

    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String first = fname.getText().toString();
            String second = sname.getText().toString();
            String id = identify.getText().toString();
            String simu = phone.getText().toString();
            String arafa = email.getText().toString();
            String wote = mf.getText().toString();
            String kichwa = head.getText().toString();
            String male = ml.getText().toString();
            String female = fl.getText().toString();


            if (first.isEmpty()||second.isEmpty()||id.isEmpty()||simu.isEmpty()||arafa.isEmpty()||wote.isEmpty()||kichwa.isEmpty()||male.isEmpty()||female.isEmpty())
            {
                Toast.makeText(RegistrationActivity.this, "Fill all Inputs", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Long time = System.currentTimeMillis();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Watu/"+time);
                Item x = new Item(first,second,id,simu,arafa,wote,kichwa,male,female);
                dialog.show();
                ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        dialog.dismiss();
                        if (task.isSuccessful())
                        {
                            Toast.makeText(RegistrationActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                            fname.setText("");
                            sname.setText("");
                            identify.setText("");
                            phone.setText("");
                            email.setText("");
                            mf.setText("");
                            head.setText("");
                            ml.setText("");
                            fl.setText("");
                        }
                        else
                        {
                            Toast.makeText(RegistrationActivity.this, "Saving Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    });
    }
}

