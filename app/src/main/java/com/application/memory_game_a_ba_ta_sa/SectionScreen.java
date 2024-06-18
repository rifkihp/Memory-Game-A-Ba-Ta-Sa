package com.application.memory_game_a_ba_ta_sa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class SectionScreen extends AppCompatActivity {

    private TextView tv_name;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_screen);

        //Kita mendapatkan nama pengguna dari LoginScreen Activity
        Intent i = getIntent();
        name = i.getStringExtra("name");

        tv_name = findViewById(R.id.txt_name);
        tv_name.setText("Welcome "+name);

        (findViewById(R.id.btn12)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChooseSection(name,4,3,12);
            }
        });

        (findViewById(R.id.btn16)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChooseSection(name,4,4,16);
            }
        });

        (findViewById(R.id.btn20)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChooseSection(name,5,4,20);
            }
        });

        (findViewById(R.id.btn36)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChooseSection(name,9,4,36);
            }
        });
        
    }

    //Kita akan beralih dari activity ini ke activity ModScreen di sini.
    //Tombol mana pun yang diklik akan diteruskan di fungsi ini sesuai dengan parameter yang dikirim
    //Kemudian akan meneruskan parameter tersebut ke activity lain (ModScreen activity) di sini
    public void showChooseSection(String name,int row, int column,int area){

            Intent i = new Intent(SectionScreen.this,ModScreen.class);
            i.putExtra("name",name);
            i.putExtra("row",row);
            i.putExtra("column",column);
            i.putExtra("area",area);
            startActivity(i);
    }
}
