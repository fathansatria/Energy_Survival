package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Introduction1 extends AppCompatActivity {

    private ImageView introScreen1;
    private String account;
    private MediaPlayer narator1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction1);

        introScreen1 = findViewById(R.id.iv_intro1);
        narator1 = narator1.create(this, R.raw.narator1);
        narator1.start();

        Intent intent = getIntent();
        account = intent.getStringExtra("current");

        introScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goIntro2();
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goIntro2(){
        Intent intent = new Intent(this, Introduction2.class);
        intent.putExtra("current", account);
        startActivity(intent);
        overridePendingTransition(0,0);
        narator1.release();
        narator1 = null;
    }
}
