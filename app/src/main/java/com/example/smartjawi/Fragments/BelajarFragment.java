package com.example.smartjawi.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.smartjawi.HijaiyahSection.HijaiyahActivity;
import com.example.smartjawi.MainActivity;
import com.example.smartjawi.R;

public class BelajarFragment extends Fragment {
    Button hijaiyahbtn, nomborjawibtn, hijaiyahGambarbtn, doabtn, surahbtn;
    ImageButton backk_belajar;

    public BelajarFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_belajar, container, false);

        hijaiyahbtn = rootview.findViewById(R.id.hijaiyah_btn);
        nomborjawibtn = rootview.findViewById(R.id.nomborjawi_btn);
        hijaiyahGambarbtn = rootview.findViewById(R.id.hjGambar_btn);
        doabtn = rootview.findViewById(R.id.doa_btn);
        surahbtn = rootview.findViewById(R.id.surah_btn);

        hijaiyahbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HijaiyahActivity.class);
                startActivity(intent);
            }
        });
//        nomborjawibtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), NomborJawiActivity.class);
//                startActivity(intent);
//            }
//        });
//        hijaiyahGambarbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), JG_Activity.class);
//                startActivity(intent);
//            }
//        });
//        doabtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), DoaHarianActivity.class);
//                startActivity(intent);
//            }
//        });
//        surahbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), PSurahActivity.class);
//                startActivity(intent);
//            }
//        });

        backk_belajar = rootview.findViewById(R.id.backk_belajar);
        backk_belajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                HomeFragment homeFragment = new HomeFragment();
//                loadFragment(homeFragment);

                Intent intentBelajar = new Intent(getActivity(), MainActivity.class);
                startActivity(intentBelajar);
            }
        });
        return rootview;
    }

//    private void loadFragment(Fragment fragment) {
//        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_belajar, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }
}