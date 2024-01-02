package com.example.smartjawi.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.smartjawi.R;

public class HomeFragment extends Fragment {

    RelativeLayout btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        btn1 = view.findViewById(R.id.jombelajar);

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
}
