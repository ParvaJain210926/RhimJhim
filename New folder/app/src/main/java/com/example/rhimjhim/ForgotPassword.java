package com.example.rhimjhim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    EditText editTextEmail;
    FirebaseAuth mAuth;
    ProgressBar progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        editTextEmail=(EditText) findViewById(R.id.editTextTextForgetEmail);
        mAuth=FirebaseAuth.getInstance();
        progressBar2=(ProgressBar) findViewById(R.id.ProgressBarResetPass2);
    }
    public void forgetResetButtonPressed(){
        resetPassword();

    }
    private void resetPassword() {
        String txtEmail = editTextEmail.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()) {
            editTextEmail.setError("please enter valid email");
            editTextEmail.requestFocus();
            return;

        }
        progressBar2.setVisibility(View.VISIBLE);
            mAuth.sendPasswordResetEmail(txtEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(ForgotPassword.this, "please check your Email to reset password", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ForgotPassword.this, SignInActivity.class);
                        startActivity(intent);
                        progressBar2.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(ForgotPassword.this, "Failed to reset", Toast.LENGTH_LONG).show();

                    }
                }
            });
        }

}