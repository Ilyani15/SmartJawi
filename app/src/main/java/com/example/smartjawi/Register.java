package com.example.smartjawi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {

    private EditText editEmail, editPassword, editUsername, editAge;
    private Button registerButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        editUsername = findViewById(R.id.username);
        editAge = findViewById(R.id.age);
        registerButton = findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Register.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("please wait");
        progressDialog.setCancelable(true);


        registerButton.setOnClickListener(v -> {
            if(editUsername.getText().length()>0 && editEmail.getText().length()>0 && editPassword.getText().length()>0 && editAge.getText().length()>0){
                register(editUsername.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString(), editAge.getText().toString());
            }else {
                Toast.makeText(getApplicationContext(), "please insert all data", Toast.LENGTH_LONG).show();
            }
        });

        Button close = findViewById(R.id.login);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.smartjawi.Register.this, Login.class);
                startActivity(intent);
            }
        });


    }
    private void register(String username, String email, String password, String age) {
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                FirebaseUser firebaseUser = task.getResult().getUser();
                if (firebaseUser != null) {
                    // Update the user profile display name
                    UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                            .setDisplayName(username)
                            .build();
                    firebaseUser.updateProfile(request).addOnCompleteListener(updateProfileTask -> {
                        if (updateProfileTask.isSuccessful()) {
                            // Create a UserModel object
                            UserModel userModel = new UserModel();
                            userModel.setName(username);
                            userModel.setEmail(email);
                            userModel.setAge(age);
                            userModel.setPassword(password);

                            // Store the UserModel in Firestore
                            storeUserDataInFirestore(userModel, firebaseUser.getUid());
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Update profile failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Register failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void storeUserDataInFirestore(UserModel userModel, String userId) {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("users").document(userId).set(userModel)
                .addOnCompleteListener(task -> {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                        reload();
                    } else {
                        Toast.makeText(getApplicationContext(), "Firestore write failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void reload(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
}