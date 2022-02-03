package com.example.application_getjob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class My_Project extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    ImageView ic_kembali, ic_tambah;
    SwipeRefreshLayout srl_main;
    ArrayList<String> array_nama_project,array_kategori,array_deadline,array_gaji,array_foto,array_id;
    ProgressDialog progressDialog;
    ListView listProses;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_my_project);

        //set variable sesuai dengan widget yang digunakan
        listProses = findViewById(R.id.LV);
        srl_main    = findViewById(R.id.swipe_container);
        progressDialog = new ProgressDialog(this);

        ic_kembali = findViewById(R.id.ic_kembali_project);
        ic_tambah  = findViewById(R.id.ic_tambah_project);

        ic_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My_Project.this,mainscreen.class);
                startActivity(intent);
            }
        });

        ic_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My_Project.this,TambahProject.class);
                startActivity(intent);
            }
        });

        srl_main.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                scrollRefresh();
                srl_main.setRefreshing(false);
            }
        });
        // Scheme colors for animation
        srl_main.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_red_light)

        );

        scrollRefresh();
    }

    public void scrollRefresh(){
        progressDialog.setMessage("Mengambil Data Project....");
        progressDialog.setCancelable(false);
        progressDialog.show();
        new Handler ().postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        },300);
    }

    void initializeArray(){
        array_nama_project        = new ArrayList<String>();
        array_kategori            = new ArrayList<String>();
        array_deadline            = new ArrayList<String>();
        array_gaji                = new ArrayList<String>();
        array_foto                = new ArrayList<String>();
        array_id                  = new ArrayList<String>();

        array_nama_project.clear();
        array_kategori.clear();
        array_deadline.clear();
        array_gaji.clear();
        array_foto.clear();
        array_id.clear();

    }

    public void getData(){
        initializeArray();
        AndroidNetworking.get("https://tkjconekc.com/mobile/api_kelompok_1/getproject.php")
                .setTag("Get Data Project")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener () {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();

                        try{
                            Boolean status = response.getBoolean("status");
                            if(status){
                                JSONArray ja = response.getJSONArray("result");
                                Log.d("respon",""+ja);
                                for(int i = 0 ; i < ja.length() ; i++){
                                    JSONObject jo = ja.getJSONObject(i);

                                    array_id.add(jo.getString("id"));
                                    array_nama_project.add(jo.getString("nama_project"));
                                    array_kategori.add(jo.getString("kategori"));
                                    array_deadline.add(jo.getString("deadline"));
                                    array_gaji.add(jo.getString("gaji"));
                                    array_foto.add(jo.getString("foto"));

                                }

                                //Menampilkan data berbentuk adapter menggunakan class CLVDataUser
                                final CLV_Project adapter = new CLV_Project (My_Project.this,array_nama_project,array_kategori,
                                        array_deadline,array_gaji,array_foto);
                                //Set adapter to list
                                listProses.setAdapter(adapter);

                                //edit and delete
                                listProses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        Log.d("TestKlik",""+array_nama_project.get(position));
                                        Toast.makeText(My_Project.this, array_nama_project.get(position), Toast.LENGTH_SHORT).show();

                                        //Setelah proses koneksi keserver selesai, maka aplikasi akan berpindah class
                                        //DataActivity.class dan membawa/mengirim data-data hasil query dari server.
                                        Intent i = new Intent(My_Project.this, Detail_Project.class);

                                        i.putExtra("id",array_id.get(position));
                                        i.putExtra("nama_project",array_nama_project.get(position));
                                        i.putExtra("kategori",array_kategori.get(position));
                                        i.putExtra("deadline",array_deadline.get(position));
                                        i.putExtra("gaji",array_gaji.get(position));
                                        i.putExtra("foto",array_foto.get(position));

                                        startActivity(i);
                                    }
                                });

                            }else{
                                Toast.makeText(My_Project.this, "Daftar Project Kosong", Toast.LENGTH_SHORT).show();

                            }

                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

}