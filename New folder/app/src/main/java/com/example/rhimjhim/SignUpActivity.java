package com.example.rhimjhim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;
    EditText editTextMobile;
    EditText editTextEmail;

    ProgressBar progressBar;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUserName = (EditText) findViewById(R.id.editTextUser);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextMobile = (EditText) findViewById(R.id.editTextMobile);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        mAuth = FirebaseAuth.getInstance();


        progressBar = (ProgressBar) findViewById(R.id.progressBar1);


    }

    public void signupButtonClicked(View v) {
        String txtUsername = editTextUserName.getText().toString().trim();
        String txtPassword = editTextPassword.getText().toString().trim();
        String txtMobile = editTextMobile.getText().toString().trim();
        String txtEmail = editTextEmail.getText().toString().trim();

        if (txtUsername.isEmpty()) {
            editTextUserName.setError("Please Enter UserName");
            editTextUserName.requestFocus();
        }
        if (txtPassword.isEmpty() || txtPassword.length() < 8) {
            editTextPassword.setError("Please enter a valid 8 character Password");
            editTextPassword.requestFocus();
        }
        if (txtMobile.isEmpty() || txtMobile.length() < 10) {
            editTextMobile.setError(("Please enter valid Mobile No."));
            editTextMobile.requestFocus();
        }
        if (txtEmail.isEmpty()) {
            editTextEmail.setError("Please enter Valid Email Id");
            editTextEmail.requestFocus();
        }
        else {
            progressBar.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(txtEmail, txtPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                User user = new User(txtUsername, txtPassword, txtMobile, txtEmail);

                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).
                                        setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(SignUpActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                                                    progressBar.setVisibility(View.GONE);
                                                } else {
                                                    Toast.makeText(SignUpActivity.this, "User Registration Failed", Toast.LENGTH_LONG).show();
                                                    progressBar.setVisibility(View.GONE);
                                                }
                                            }
                                        });
                            } else {

                                Toast.makeText(SignUpActivity.this, "User Registration Failed", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);

                            }
                        }

                    });
        }

    }
}
