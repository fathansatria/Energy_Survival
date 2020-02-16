package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class YouLose3 extends AppCompatActivity {

    private ImageView ivYoulose3;
    private MediaPlayer lose3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lose3);

        ivYoulose3 = findViewById(R.id.iv_youlose3);
        lose3 = lose3.create(this, R.raw.lose);
        lose3.start();

        ivYoulose3.setOnClickListener(new View.OnClickListener() {
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

        lose3.release();
        lose3 = null;
    }
}
