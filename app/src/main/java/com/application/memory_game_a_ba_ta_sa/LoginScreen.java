package com.application.memory_game_a_ba_ta_sa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //EditText'e girilen adı almam lazım o yüzden ilk olarak lbl_name adındaki editText'e erişiyorum.
        //ve içerideki adı name'de tutuyorum
        final EditText name = findViewById(R.id.lbl_name);

        ((Button)findViewById(R.id.btn_start)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Membuat Intent baru.
                //Ketika tombol diklik, activity ini akan beralih ke activity SectionScreen
                //Dengan fungsi putExtra, saya mengirimkan nama yang saya terima dari editText ke activity lain dengan pesan "nama".

                Intent i = new Intent(LoginScreen.this,SectionScreen.class);
                i.putExtra("name",name.getText().toString());
                startActivity(i);
            }
        });

    }
}
