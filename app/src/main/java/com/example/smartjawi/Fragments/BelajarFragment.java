package com.example.smartjawi.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.smartjawi.MainActivity;
import com.example.smartjawi.R;

public class BelajarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_belajar, container, false);

        ImageView close = view.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Assuming HomeFragment is part of MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                // finish() is not applicable to Fragments
            }
        });

        return view;
    }
}
