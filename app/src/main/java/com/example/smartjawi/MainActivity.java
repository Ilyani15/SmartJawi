package com.example.smartjawi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.smartjawi.Fragments.BelajarFragment;
import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.Fragments.HomeFragment;
import com.example.smartjawi.Fragments.ProfileFragment;
import com.example.smartjawi.Fragments.QuizFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/*
public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meowBottomNavigation = findViewById(R.id.meow_Bottom_Navigation);
        replace(new HomeFragment()); // for default fragment
        meowBottomNavigation.show(1, true);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_draw_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_castle_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_person_24));

        meowBottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()) {
                    case 1:
                        replace(new HomeFragment());
                        break;
                    case 2:
                        replace(new QuizFragment());
                        break;
                    case 3:
                        replace(new GameFragment());
                        break;
                    case 4:
                        replace(new ProfileFragment());
                        break;
                } return null;
            }
        });
        // if user repeat click item menu
        meowBottomNavigation.setOnReselectListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Toast.makeText(MainActivity.this, "anda sudah berada di sini!", Toast.LENGTH_SHORT).show();
                return null;
            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentTransaction meowTransaction = getSupportFragmentManager().beginTransaction();
        meowTransaction.replace(R.id.frame_main, fragment);
        meowTransaction.commit();
    }
}*/
public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meowBottomNavigation = findViewById(R.id.meow_Bottom_Navigation);

        // Check for extras and load the specified fragment
        String fragmentTag = getIntent().getStringExtra("fragmentToLoad");
        if (fragmentTag != null) {
            loadFragmentByTag(fragmentTag);
        } else {
            replace(new HomeFragment()); // Default fragment
            meowBottomNavigation.show(1, true);
        }

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_draw_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_castle_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_person_24));

        meowBottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
                    replace(new HomeFragment());
                    break;
                case 2:
                    replace(new QuizFragment());
                    break;
                case 3:
                    replace(new GameFragment());
                    break;
                case 4:
                    replace(new ProfileFragment());
                    break;
            }
            return null;
        });

        // if user repeats clicking the same item menu
        meowBottomNavigation.setOnReselectListener(model -> {
            Toast.makeText(MainActivity.this, "You are already here!", Toast.LENGTH_SHORT).show();
            return null;
        });
    }

    private void loadFragmentByTag(String fragmentTag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        if (fragment == null) {
            // Fragment not in the back stack, create a new instance
            switch (fragmentTag) {
                case "HomeFragment":
                    fragment = new HomeFragment();
                    break;
                case "QuizFragment":
                    fragment = new QuizFragment();
                    break;
                case "GameFragment":
                    fragment = new GameFragment();
                    break;
                case "ProfileFragment":
                    fragment = new ProfileFragment();
                    break;
                // Add more cases if needed for other fragments
            }
        }

        // Replace the current fragment with the specified one
        replace(fragment);
    }

    private void replace(Fragment fragment) {
        FragmentTransaction meowTransaction = getSupportFragmentManager().beginTransaction();
        meowTransaction.replace(R.id.frame_main, fragment, fragment.getClass().getSimpleName());
        meowTransaction.commit();
    }
}

