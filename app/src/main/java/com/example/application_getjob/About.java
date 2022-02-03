package com.example.application_getjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class About extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_about);

            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);

            bottomNavigationView.setSelectedItemId(R.id.about);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.home:
                            startActivity(new Intent (getApplicationContext(), mainscreen.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.add:
                            startActivity(new Intent(getApplicationContext(),My_Project.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.about:
                            startActivity(new Intent(getApplicationContext(), About.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.profile:
                            startActivity(new Intent(getApplicationContext(), Profil_User.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.chat:
                            startActivity(new Intent(getApplicationContext(), Chat.class));
                            overridePendingTransition(0, 0);
                            return true;
                    }
                    return false;
                }
            });
        }
    }