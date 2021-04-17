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

public class Login_Form extends AppCompatActivity {

    EditText txtemail,textpass;
    Button btn_login;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        //getSupportActionBar().setTitle("Login Form");

        txtemail=(EditText)findViewById(R.id.txt_email);
        textpass=(EditText)findViewById(R.id.txt_password);

        btn_login=(Button)findViewById(R.id.buttonLogin);

        firebaseAuth= FirebaseAuth.getInstance();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=txtemail.getText().toString().trim();
                String pass=textpass.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Login_Form.this, "Please Enter EMail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(Login_Form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                    firebaseAuth.signInWithEmailAndPassword (email,pass)
                            .addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                            startActivity(new Intent(getApplicationContext(), MoviesListingActivity.class));
                                    } else {
                                        Toast.makeText(Login_Form.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });
                }

        });

    }

    public void btn_signupForm(View view) {
        startActivity(new Intent(getApplicationContext(),Signup_Form.class));
    }
}