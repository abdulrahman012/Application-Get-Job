package com.example.application_getjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainscreen extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    Button btnInfo, btngraphic, btnmobile, btntutoring, btnvideo, btnwriting, btnmarketing;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mainscreen);

        // Inisialisasi layout dengan java menggunakan ID
        btnInfo = (Button) findViewById(R.id.btnInfo);
        btngraphic = (Button) findViewById(R.id.btngraphic);
        btnmobile = (Button) findViewById(R.id.btnwebmobile );
        btnvideo = (Button) findViewById(R.id.btnvideo);
        btnwriting = (Button) findViewById(R.id.btnwriting);
        btnmarketing = (Button) findViewById(R.id.btndigital);
        btntutoring = (Button) findViewById(R.id.btntutoring);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById (R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId (R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId ()) {
                    case R.id.home:
                        startActivity (new Intent (getApplicationContext (), mainscreen.class));
                        overridePendingTransition (0, 0);
                        return true;
                    case R.id.add:
                        startActivity (new Intent (getApplicationContext (), My_Project.class));
                        overridePendingTransition (0, 0);
                        return true;
                    case R.id.about:
                        startActivity (new Intent (getApplicationContext (), About.class));
                        overridePendingTransition (0, 0);
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

        // klik btn plus ke halaman Info
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainscreen.this, About.class);
                startActivity(intent);
            }
        });

        // klik btn  ke halaman List Desain Grafis
        btngraphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainscreen.this, Kategori_GraphicDesain.class);
                startActivity(intent);
            }
        });

        // klik btn  ke halaman List WebMobile Dan APP Mobile
        btnmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainscreen.this, Kategori_WebMobile.class);
                startActivity(intent);
            }
        });



        // klik btn  ke halaman List Businness
        btnwriting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainscreen.this, Kategori_WritingContent.class);
                startActivity(intent);
            }
        });


        // klik btn  ke halaman List Video Animation
        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainscreen.this, Kategori_VideoAnimation.class);
                startActivity(intent);
            }
        });

        // klik btn  ke halaman List Digital_Marketting
        btnmarketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainscreen.this, Kategori_DigitalMarketing.class);
                startActivity(intent);
            }
        });

        // klik btn  ke halaman List Writting Content
        btntutoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainscreen.this, Kategori_PrivateTutoring.class);
                startActivity(intent);
            }
        });


        // klik btn  ke halaman List Writting Content
        btnwriting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainscreen.this, Kategori_WritingContent.class);
                startActivity(intent);
            }
        });

    }
}