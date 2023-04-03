package com.example.exploreoffline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupPassword,signupconfirmpass;
    TextView loginRedirectText;

    TextView alreadyaccount;
    Button getRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyaccount=findViewById(R.id.alreadyaccount);
        signupconfirmpass =findViewById(R.id.inputpassword2);
        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.inputemail);
        signupPassword = findViewById(R.id.inputpassword);
        getRegister = findViewById(R.id.btnlogin);
        loginRedirectText= findViewById(R.id.registerwithus);




        getRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user= signupEmail.getText().toString().trim();
                String pass= signupPassword.getText().toString().trim();
                String cnpass = signupconfirmpass.getText().toString().trim();

                if (user.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                }
                else if(cnpass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"the filed cannot be empty",Toast.LENGTH_SHORT).show();
                }
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(register.this, "Register Successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, login.class));
                            }else{
                                Toast.makeText(register.this, "Register failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                startActivity(new Intent(register.this,login.class));
            }


        });
        alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this,login.class));
            }
        });


    }
}