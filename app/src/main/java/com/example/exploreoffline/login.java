package com.example.exploreoffline;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText loginEmail, loginPassword;
    private TextView signupRedirectText;
    private Button loginButton;


    TextView registerwithus;
    Button btnlogin,gstlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        registerwithus=findViewById(R.id.registerwithus);
        btnlogin=findViewById(R.id.btnlogin);

        gstlogin = findViewById(R.id.gstlogin);
        gstlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),homepage.class));
            }
        });
        registerwithus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,register.class));
            }
        });

//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
////            public void onClick(View v) {
////                startActivity(new Intent(login.this,homepage.class));
//            Intent intent = new Intent(getApplicationContext(),homepage.class);
//               startActivity(intent);
////            }
//        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),homepage.class);
                startActivity(intent);
            }
        });
        auth = getInstance();
        loginEmail = findViewById(R.id.inputemail);
        loginPassword = findViewById(R.id.inputpassword);
        loginButton = findViewById(R.id.btnlogin);
        signupRedirectText = findViewById(R.id.registerwithus);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(email,pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(login.this, homepage.class));
                                        finish();

                                    }

                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(login.this, "Login Failed ", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else {
                        loginPassword.setError("Password cannot be empty");
                    }
                }else if (email.isEmpty())
                {
                    loginEmail.setError("Email Cannot be Empty");
                }else
                    loginEmail.setError("Please Enter valid Email");
            }
        });

            signupRedirectText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(login.this,register.class));
                }
            });

    }
}