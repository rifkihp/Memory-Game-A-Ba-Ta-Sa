package com.application.memory_game_a_ba_ta_sa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;

public class Card extends android.support.v7.widget.AppCompatButton {

     int foregroundID;
     int backgroundID;

     Drawable back;
     Drawable front;
     Drawable dr;

     boolean isOpen = false;
     boolean reversible = true;

    @SuppressLint({"RestrictedApi", "NewApi"})
    public Card(Context context, int id,int row, int column,int area, Point size) {
        super(context);

        setId(id);

        chooseDrawble(id,area);

        back = AppCompatDrawableManager.get().getDrawable(context,backgroundID);
        front = AppCompatDrawableManager.get().getDrawable(context,foregroundID);

        int width = size.x/3;
        int height = size.y/3;

        dr = back;
        Bitmap bitmap = ((BitmapDrawable)dr).getBitmap();
        back = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap,width/column,height/(row+2),true));
        dr = front;
        Bitmap bitmap1 = ((BitmapDrawable)dr).getBitmap();
        front = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap1,width/column,height/(row+2),true));

        setBackground(back);

    }

    @SuppressLint({"RestrictedApi", "NewApi"})
    public void goster(Context context , int id, int row,int column,int area, Point boyut){
        front=null;
        back=null;

        chooseDrawble(id,area);

        back = AppCompatDrawableManager.get().getDrawable(context,backgroundID);
        front = AppCompatDrawableManager.get().getDrawable(context,foregroundID);

        int width = boyut.x/3;
        int height = boyut.y/3;

        dr = back;
        Bitmap bitmap = ((BitmapDrawable)dr).getBitmap();
        back = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap,width/column,height/(row+2),true));

        dr = front;
        Bitmap bitmap1 = ((BitmapDrawable)dr).getBitmap();
        front = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap1,width/column,height/(row+2),true));

        setBackground(back);
    }

    //Fungsi untuk membalik kartu, tujuannya adalah untuk mengubah background kartu tergantung image setiap kali dijalankan.
    @SuppressLint("NewApi")
    public void turnCard(){
        if(reversible){
            if(isOpen == false){
                setBackground(front);
                isOpen = true;
            }
            else{
                setBackground(back);
                isOpen = false;
            }
        }

    }

    public void chooseDrawble(int id,int area){

        backgroundID = R.drawable.bg;

        if(id % (area/2) == 1)
            foregroundID = R.drawable.alif;
        if (id % (area/2) == 2)
            foregroundID = R.drawable.ba;
        if (id % (area/2) == 3)
            foregroundID = R.drawable.ta;
        if (id % (area/2)== 4)
            foregroundID = R.drawable.tsa;
        if (id % (area/2) == 5)
            foregroundID = R.drawable.jim;
        if (id % (area/2) == 6)
            foregroundID = R.drawable.ha;
        if (id % (area/2) == 7)
            foregroundID = R.drawable.kha;
        if (id % (area/2)== 8)
            foregroundID = R.drawable.dal;
        if (id % (area/2) == 9)
            foregroundID = R.drawable.dzal;
        if (id % (area/2) == 10)
            foregroundID = R.drawable.ra;
        if (id % (area/2) == 11)
            foregroundID = R.drawable.zai;
        if (id % (area/2) == 12)
            foregroundID = R.drawable.sin;
        if (id % (area/2) == 13)
            foregroundID = R.drawable.syin;
        if (id % (area/2) == 14)
            foregroundID = R.drawable.shad;
        if (id % (area/2) == 15)
            foregroundID = R.drawable.dhad;
        if (id % (area/2) == 16)
            foregroundID = R.drawable.tha;
        if (id % (area/2) == 17)
            foregroundID = R.drawable.zha;
        if (id % (area/2) == 18)
            foregroundID = R.drawable.ain;
        if (id % (area/2) == 19)
            foregroundID = R.drawable.ghin;
        if (id % (area/2) == 20)
            foregroundID = R.drawable.fa;
        if (id % (area/2) == 21)
            foregroundID = R.drawable.qaf;
        if (id % (area/2) == 22)
            foregroundID = R.drawable.kaf;
        if (id % (area/2) == 23)
            foregroundID = R.drawable.lam;
        if (id % (area/2) == 24)
            foregroundID = R.drawable.mim;
        if (id % (area/2) == 25)
            foregroundID = R.drawable.nun;
        if (id % (area/2) == 26)
            foregroundID = R.drawable.wau;
        if (id % (area/2) == 27)
            foregroundID = R.drawable.ha_;
        if (id % (area/2) == 28)
            foregroundID = R.drawable.lam_alif;
        if (id % (area/2) == 29)
            foregroundID = R.drawable.hamzah;
        if (id % (area/2) == 0)
            foregroundID = R.drawable.ya;
    }

}
