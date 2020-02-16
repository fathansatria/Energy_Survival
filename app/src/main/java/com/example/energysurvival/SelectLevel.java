package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectLevel extends AppCompatActivity {

    private ImageButton btnLvl1, btnLvl2, btnLvl3, btnPremium, btnBack;
    private String account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);

        btnLvl1 = findViewById(R.id.btn_lv1);
        btnLvl2 = findViewById(R.id.btn_lv2);
        btnLvl3 = findViewById(R.id.btn_lv3);
        btnPremium = findViewById(R.id.btn_morelvl);
        btnBack = findViewById(R.id.btn_back);
        final MediaPlayer soundbutton = MediaPlayer.create(this,R.raw.sound_fix);


        Intent intent = getIntent();
        account = intent.getStringExtra("current");

        System.out.println(account + " di select level");

        btnLvl1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                soundbutton.start();
                tap1();
            }
        });

        btnLvl2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                soundbutton.start();
                tap2();
            }
        });

        btnLvl3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                soundbutton.start();
                tap3();
            }
        });

        btnPremium.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                soundbutton.start();
                goPremium();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                soundbutton.start();
                goMain();
            }
        });


    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void tap1(){
        Intent intent = new Intent(this, TapScreen1.class);
        intent.putExtra("current", account);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    public void tap2(){
        Intent intent = new Intent(this, TapScreen2.class);
        intent.putExtra("current", account);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    public void tap3(){
        Intent intent = new Intent(this, TapScreen3.class);
        intent.putExtra("current", account);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    public void goPremium(){
        Intent intent = new Intent(this, GoPremium.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    public void goMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }



}
