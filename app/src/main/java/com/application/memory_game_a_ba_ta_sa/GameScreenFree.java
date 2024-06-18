package com.application.memory_game_a_ba_ta_sa;

import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.TextView;

public class GameScreenFree extends AppCompatActivity {

    private String name;
    private int row;
    private int column;
    private int area;

    private int lastCard=0;

    private int score = 0;
    private int mistake = 0;

    Point size = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_free);

        getWindowManager().getDefaultDisplay().getSize(size);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        row = i.getIntExtra("row",0);
        column = i.getIntExtra("column",0);
        area = i.getIntExtra("area",0);

        TextView txt_name = findViewById(R.id.txt_name);
        txt_name.setText("Welcome "+name);

        final TextView txt_score = findViewById(R.id.txt_score);
        final TextView txt_mistake = findViewById(R.id.txt_mistake);
        final Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.start();

        GridLayout gl = findViewById(R.id.gl_game);
        gl.setRowCount(row);
        gl.setColumnCount(column);

       final Card cards[] = new Card[area];

        for(int j=1;j<=area;j++){
            cards[j-1] = new Card(this,j,row,column,area, size);

            cards[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  final Card k = (Card)v;
                    startAnimation(k);
                    k.turnCard();
                    k.setClickable(false);

                    if(lastCard > 0){
                        final Card k2 = findViewById(lastCard);
                        if(k2.foregroundID == k.foregroundID && k2.getId() != k.getId()){

                            k2.reversible = false;
                            k.reversible = false;

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.setVisibility(View.INVISIBLE);
                                    k2.setVisibility(View.INVISIBLE);

                                }
                            }, 500);

                            score++;
                            txt_score.setText("Score: "+score);

                            lastCard = 0;

                            if(score == area/2){

                                chronometer.stop();

                                Intent i = new Intent(GameScreenFree.this,ScoreScreen.class);
                                i.putExtra("name",name);
                                i.putExtra("row",row);
                                i.putExtra("column",column);
                                i.putExtra("area",area);
                                i.putExtra("mistake",mistake);
                                i.putExtra("finishTime",chronometer.getText().toString());
                                i.putExtra("mode","free");

                                startActivity(i);
                            }

                        }
                        else {
                                for (int j = 0; j < area; j++) {
                                    cards[j].setClickable(false);
                                }

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.turnCard();
                                    k2.turnCard();

                                    for(int j=0;j<area;j++){
                                        cards[j].setClickable(true);
                                    }
                                }
                            },700);

                            mistake++;
                            txt_mistake.setText("Mistake: "+mistake);

                            lastCard = 0;
                        }
                    }
                    else{
                        lastCard = k.getId();
                    }
                }
            });
        }

        for(int j=0;j<area;j++){
            int random =(int)(Math.random()*area);
            Card k = cards[random];
            cards[random] = cards[j];
            cards[j] = k;
        }

        for(int j=0; j<area;j++){
            gl.addView(cards[j]);
        }

    }

    public void startAnimation(Button button){
        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

        findViewById(button.getId()).startAnimation(rotate);

    }
}
