package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class YouLose1 extends AppCompatActivity {

    private ImageView ivYoulose1;
    private MediaPlayer lose1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lose);

        ivYoulose1 = findViewById(R.id.iv_youlose1);
        lose1 = lose1.create(this, R.raw.lose);
        lose1.start();

        ivYoulose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSelect();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goSelect(){
        MusicManager.SoundPlayer(this, R.raw.sound_bgm);
        Intent intent = new Intent(this, SelectLevel.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        lose1.release();
        lose1 = null;
    }
}
