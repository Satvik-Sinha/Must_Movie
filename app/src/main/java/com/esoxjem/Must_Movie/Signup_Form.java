package com.esoxjem.Must_Movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esoxjem.Must_Movie.listing.MoviesListingActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.reactivex.annotations.NonNull;

public class Signup_Form extends AppCompatActivity {

    EditText txtemail,textpass,textconfpass;
    Button btn_Regist;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        //getSupportActionBar().setTitle("Signup Form");

        txtemail=(EditText)findViewById(R.id.txt_email);
        textpass=(EditText)findViewById(R.id.txt_password);
        textconfpass=(EditText)findViewById(R.id.txt_confirm_password);
        btn_Regist=(Button)findViewById(R.id.buttonRegister);

        firebaseAuth=FirebaseAuth.getInstance();
        btn_Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=txtemail.getText().toString().trim();
                String pass=textpass.getText().toString().trim();
                String confpass=textconfpass.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Signup_Form.this, "Please Enter EMail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(Signup_Form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confpass))
                {
                    Toast.makeText(Signup_Form.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.equals(confpass))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email,pass)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>()
                {
                                @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), MoviesListingActivity.class));
                        Toast.makeText(Signup_Form.this, "Registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Signup_Form.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
                });
                }
            }
        });
    }
}