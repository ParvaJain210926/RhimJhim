package com.example.rhimjhim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    EditText editTextUsername,editTextPassword;
    TextView textViewForgotPassword,textViewRegister;
    ProgressBar progressBar;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editTextUsername=(EditText) findViewById(R.id.editTextSignInUser);
        editTextPassword=(EditText) findViewById(R.id.editTextSignInPassword);
        progressBar= (ProgressBar) findViewById(R.id.progressBarSignIn);

        textViewForgotPassword=(TextView)findViewById(R.id.textViewForgotPassword);
        textViewRegister=(TextView) findViewById(R.id.textViewRegister);

        mAuth=FirebaseAuth.getInstance();
    }
    public void textSignInScreenForgotClicked(View v){
        Intent intent=new Intent(this,ForgotPassword.class);
        startActivity(intent);

    }
    public  void textSignInRegisterClicked(View v){
        Intent intent=new Intent(this,SignUpActivity.class);
        startActivity(intent);

    }




    public void buttonSignInClicked(View v){
        String userName=editTextUsername.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            editTextUsername.setError("Please Enter a Valid Email");
            editTextUsername.requestFocus();
        }

        if (editTextPassword.length()<6){
            editTextPassword.setError("Please enter a valid password of length 6");
            editTextPassword.requestFocus();
        }
        if(editTextUsername.length()==0){
            editTextUsername.setError("Email Can't be Empty");
            editTextUsername.requestFocus();
        }
        if(editTextPassword.length()==0){
            editTextPassword.setError("Password can't be Empty");
            editTextPassword.requestFocus();
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(userName,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(SignInActivity.this,"User Successfully Logged In",Toast.LENGTH_LONG).show();

                    startActivity(new Intent(SignInActivity.this,DashboardActivity.class));
                }
                else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(SignInActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
                }
            }

        });
        progressBar.setVisibility(View.GONE);

    }


}