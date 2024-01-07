package com.example.smartjawi.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.smartjawi.R;
import com.example.smartjawi.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {

    RelativeLayout btn1;
    TextView name;
    ImageView profileImage; // Add ImageView for profile image
    FirebaseUser firebaseUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn1 = view.findViewById(R.id.jombelajar);
        name = view.findViewById(R.id.name);
        profileImage = view.findViewById(R.id.profilepic); // Initialize ImageView

        // Get the current authenticated user
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            // The user is authenticated, you can access user information
            String username = firebaseUser.getDisplayName();

            // Check if the username is available
            if (username != null && !username.isEmpty()) {
                name.setText(username);
            } else {
                // If the username is not available, you can use the user's email or UID
                // For example:
                // String userEmail = firebaseUser.getEmail();
                // String uid = firebaseUser.getUid();
                // name.setText("Hello, " + userEmail + "!"); // or name.setText("Hello, " + uid + "!");
            }

            // Retrieve and display the profile image
            retrieveProfileImage();
        } else {
            // The user is not authenticated
            // You can handle this case or redirect the user to the authentication screen
            Toast.makeText(requireContext(), "User not authenticated", Toast.LENGTH_SHORT).show();
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to BelajarFragment
                BelajarFragment belajarFragment = new BelajarFragment();
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, belajarFragment)
                        .addToBackStack(null) // Optional: Adds transaction to back stack
                        .commit();
            }
        });

        return view;
    }

    private void retrieveProfileImage() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            FirebaseFirestore firestore = FirebaseFirestore.getInstance();

            firestore.collection("users").document(userId)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    UserModel user = document.toObject(UserModel.class);

                                    // Load the profile image using Picasso
                                    if (user != null && user.getProfileImageUrl() != null && !user.getProfileImageUrl().isEmpty()) {
                                        Picasso.get().load(user.getProfileImageUrl()).into(profileImage);
                                    }
                                }
                            } else {
                                // Handle errors
                            }
                        }
                    });
        }
    }
}
