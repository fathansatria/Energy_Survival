package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Introduction3 extends AppCompatActivity {

    private ImageView introScreen3;
    private String account;
    private MediaPlayer narator3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction3);
        introScreen3 = findViewById(R.id.iv_intro3);
        narator3 = narator3.create(this, R.raw.narator3);
        narator3.start();


        Intent intent = getIntent();
        account = intent.getStringExtra("current");

        introScreen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSelectLevel();
            }
        });

    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goSelectLevel(){
        Intent intent = new Intent(this, SelectLevel.class);
        intent.putExtra("current", account);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        narator3.release();
        narator3 = null;
    }




}
