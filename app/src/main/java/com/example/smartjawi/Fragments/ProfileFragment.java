package com.example.smartjawi.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.smartjawi.Game.Cw.FirstCW;
import com.example.smartjawi.Login;
import com.example.smartjawi.ProgressTracking;
import com.example.smartjawi.R;
import com.example.smartjawi.model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {

    Activity context;
    Button logout;
    TextView userNameTextView, userEmailTextView, userAgeTextView, userPasswordTextView;
    ImageView profilePic, btnEdit;
    LinearLayout btn1;

    // Request code for image picker
    private static final int PICK_IMAGE_REQUEST = 1;

    // Firebase Storage
    private FirebaseStorage storage;
    private StorageReference storageReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        logout = view.findViewById(R.id.logout);
        userNameTextView = view.findViewById(R.id.name);
        userEmailTextView = view.findViewById(R.id.email);
        userAgeTextView = view.findViewById(R.id.age);
        userPasswordTextView = view.findViewById(R.id.password);
        btnEdit = view.findViewById(R.id.btn_edit);
        profilePic = view.findViewById(R.id.profilepic);
        btn1  = view.findViewById(R.id.progresstracking);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProgressTracking.class);
                startActivity(intent);
            }
        });

        // Read user data from Firestore and display it
        readUserDataFromFirestore();

        // Handle click on btnEdit (TextView for changing profile picture)
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        // Initialize Firebase Storage
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        return view;
    }

    private void readUserDataFromFirestore() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            FirebaseFirestore firestore = FirebaseFirestore.getInstance();

            firestore.collection("users").document(userId).get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    UserModel user = document.toObject(UserModel.class);
                                    if (user != null) {
                                        // Set the user data to TextViews
                                        userNameTextView.setText(user.getName());
                                        userEmailTextView.setText(user.getEmail());
                                        userAgeTextView.setText(user.getAge());
                                        userPasswordTextView.setText(user.getPassword());

                                        // Load profile picture using Picasso
                                        if (user.getProfileImageUrl() != null && !user.getProfileImageUrl().isEmpty()) {
                                            Picasso.get().load(user.getProfileImageUrl()).into(profilePic);
                                        }
                                    }
                                }
                            } else {
                                // Handle errors
                                Toast.makeText(getActivity(), "Failed to read user data", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void openImagePicker() {
        // Open an image picker to allow the user to select a new profile picture
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            // Handle the selected image
            // The image URI is in data.getData()
            Toast.makeText(getActivity(), "Image selected!", Toast.LENGTH_SHORT).show();

            // Update the profile picture in Firestore and Firebase Storage
            updateProfilePicture(data.getData());
        }
    }

    private void updateProfilePicture(Uri imageUri) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            FirebaseFirestore firestore = FirebaseFirestore.getInstance();

            // Create a StorageReference with a unique name
            StorageReference profilePicRef = storageReference.child("profile_pics/" + userId);

            // Upload the file to Firebase Storage
            profilePicRef.putFile(imageUri)
                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {
                                // Get the download URL of the uploaded file
                                profilePicRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Uri> task) {
                                        if (task.isSuccessful()) {
                                            // Update the profile picture URL in Firestore
                                            firestore.collection("users").document(userId)
                                                    .update("profileImageUrl", task.getResult().toString())
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                // Reload user data to reflect the changes
                                                                readUserDataFromFirestore();
                                                            } else {
                                                                // Handle errors
                                                                Toast.makeText(getActivity(), "Failed to update profile picture", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                        } else {
                                            // Handle errors
                                            Toast.makeText(getActivity(), "Failed to get download URL", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                // Handle errors
                                Toast.makeText(getActivity(), "Failed to upload profile picture", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
