package com.example.application_getjob;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String KEY_TOKEN = "tokenLogin";
    private static final String KEY_LOGIN = "isLogin";
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE =0;    Context c;

    //0 agar cuma bsa dibaca hp itu sendiri
    String PREF_NAME="SharedPreff";

    //konstruktor
    public SessionManager(Context c){
        this.c = c;
        pref = c.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    //membuat session Login
    public void createLoginSession(String token){
        editor.putString(KEY_TOKEN, token);
        editor.putBoolean(KEY_LOGIN, true);
        editor.commit();
        //commit digunakan untuk menyimpan perubahan
    }
    //mendapatkan token
//    public String getToken(){
//        return pref.getString(KEY_TOKEN, "");
//    }
    //cek Login
    public boolean isLogin(){
        return pref.getBoolean(KEY_LOGIN, false);
    }
    //logout user

    public void logout() {
        editor.clear();
        editor.commit();

    }

    public void setNama(String nama){
        editor.putString("user_name", nama);
        editor.commit();
    }

    public String getNama(){
        return pref.getString("user_name", "");
    }

    public void setJenisKelamin(String jenis_kelamin){
        editor.putString("jenis_kelamin", jenis_kelamin);
        editor.commit();
    }

    public String getJenisKelamin(){
        return pref.getString("jenis_kelamin", "");
    }

    public void setUmur(String umur){
        editor.putString("umur", umur);
        editor.commit();
    }

    public String getUmur(){
        return pref.getString("umur", "");
    }

    public void setEmail(String email){
        editor.putString("email", email);
        editor.commit();
    }

    public String getEmail(){
        return pref.getString("email", "");
    }

    public void setPhoto(String foto){
        editor.putString("foto", foto );
        editor.commit();
    }
    public String getPhoto(){
        return pref.getString("foto", "");
    }

    public void setIduser(String id_user){
        editor.putString("id_user", id_user);
        editor.commit();
    }
    public String getIdUser(){
        return pref.getString("id_user", "");
    }
}
