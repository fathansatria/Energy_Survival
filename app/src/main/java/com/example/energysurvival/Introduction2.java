package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Introduction2 extends AppCompatActivity {

    private ImageView introScreen2;
    private String account;
    private MediaPlayer narator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction2);

        introScreen2 = findViewById(R.id.iv_intro2);

        narator2 = narator2.create(this, R.raw.narator2);
        narator2.start();

        Intent intent = getIntent();
        account = intent.getStringExtra("current");

        introScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goIntro3();
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goIntro3(){
        Intent intent = new Intent(this, Introduction3.class);
        intent.putExtra("current", account);
        startActivity(intent);
        overridePendingTransition(0,0);
        narator2.release();
        narator2 = null;
    }

}
