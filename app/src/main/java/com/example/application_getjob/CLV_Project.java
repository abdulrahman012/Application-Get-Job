package com.example.application_getjob;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CLV_Project extends ArrayAdapter<String> {

    private final Activity context;
    private ArrayList<String> vNamaProject;
    private ArrayList<String> vKategori;
    private ArrayList<String> vDeadline;
    private ArrayList<String> vGaji;
    private ArrayList<String> vFoto;


    public CLV_Project(Activity context, ArrayList<String> NamaProject, ArrayList<String> Kategori, ArrayList<String> Deadline, ArrayList<String> Gaji, ArrayList<String> Foto) {
        super(context, R.layout.list_project,NamaProject);
        this.context       = context;
        this.vNamaProject  = NamaProject;
        this.vKategori     = Kategori;
        this.vDeadline     = Deadline;
        this.vGaji         = Gaji;
        this.vFoto         = Foto;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        //Load Custom Layout untuk list
        View rowView= inflater.inflate(R.layout.list_project, null, true);

        //Declarasi komponen
        TextView namaproject              = rowView.findViewById(R.id.nama_project);
        TextView kategori                 = rowView.findViewById(R.id.kategori);
        TextView deadline                 = rowView.findViewById(R.id.deadline);
        TextView gaji                     = rowView.findViewById(R.id.gaji);
        CircleImageView foto              = rowView.findViewById(R.id.pic_project);

        //Set Parameter Value sesuai widget textview
        namaproject.setText(vNamaProject.get(position));
        kategori.setText(vKategori.get(position));
        deadline.setText(vDeadline.get(position));
        gaji.setText(vGaji.get(position));

        if (vFoto.get(position).equals(""))
        {
            Picasso.get().load("https://tkjconekc.com/mobile/image/noimages.png").into(foto);
        }
        else
        {
            Picasso.get().load("https://tkjconekc.com/mobile/image/"+vFoto.get(position)).into(foto);
        }


        //Load the animation from the xml file and set it to the row
        //load animasi untuk listview
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.down_from_top);
        animation.setDuration(500);
        rowView.startAnimation(animation);

        return rowView;
    }



}