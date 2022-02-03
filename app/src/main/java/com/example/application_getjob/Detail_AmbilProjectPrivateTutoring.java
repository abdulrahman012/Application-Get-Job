package com.example.application_getjob;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class Detail_AmbilProjectPrivateTutoring extends AppCompatActivity {

    TextView TVnama_project, TVkategori, TVdeadline, navnamalengkap, navalamat;
    String id, nama_project, kategori, deadline, foto, jumlah, nama_pekerjaproject, alamat;
    EditText ETjumlah, ETnama_pekerjaproject, ETalamat;
    CircleImageView image;
    ProgressDialog progressDialog;
    Button BTNAmbil;
    ImageView ic_kembali;
    ImageButton tambah_foto_project;

    String pilihan;
    private static final int PHOTO_REQUEST_GALLERY = 1;//gallery
    static final int REQUEST_TAKE_PHOTO = 1;
    final int CODE_GALLERY_REQUEST = 999;
    String rPilihan[] = {"Take a photo", "From Album"};
    public final String APP_TAG = "MyApp";
    Bitmap bitMap = null;
    public String photoFileName = "photo.jpg";
    File photoFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detail_ambil_project_private_tutoring);

        //Intent, get data from main
        id = getIntent ().getStringExtra ("id");
        nama_project = getIntent ().getStringExtra ("nama_project");
        kategori = getIntent ().getStringExtra ("kategori");
        deadline = getIntent ().getStringExtra ("deadline");


        TVnama_project = findViewById (R.id.TVP_nama_project);
        TVkategori = findViewById (R.id.TVP_kategori);
        TVdeadline = findViewById (R.id.TVP_deadline);
        BTNAmbil = findViewById (R.id.BTNambilproject);
        ic_kembali = findViewById (R.id.ic_kembali_ambilproject);

        image = findViewById (R.id.pic_project);


        TVnama_project.setText (nama_project);
        TVkategori.setText (kategori);
        TVdeadline.setText (deadline);


        progressDialog = new ProgressDialog (this);

        ic_kembali.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Detail_AmbilProjectPrivateTutoring.this, My_Project.class);
                startActivity (intent);
            }
        });

        BTNAmbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean installed = appInstalledOrNot("com.whatsapp");

                if (installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+6281939206643"+ "&text="+ "Saya Akan Mengambil Project Ini"));
                    startActivity(intent);
                }else {
                    Toast.makeText(Detail_AmbilProjectPrivateTutoring.this, "Whatsapp not installed  on", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private  boolean appInstalledOrNot(String url){
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,packageManager.GET_ACTIVITIES);
            app_installed = true;
        }catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return app_installed;
    }
}
