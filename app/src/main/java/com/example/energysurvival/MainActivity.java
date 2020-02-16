package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPlay, btnSetting, btnScoreboard, btnExit;
    private MediaPlayer mPlayer;


//    musicManager.getInstance().initalizeMediaPlayer(this, R.raw.sound_bgm); // to initalize of media player
//    musicManager.getInstance().startPlaying();// to start playing music
//    musicManager.getInstance().stopPlaying(); // to stop playing music


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btn_play);
        btnExit = findViewById(R.id.btn_exit);
        btnSetting = findViewById(R.id.btn_setting);




        try{
            MusicManager.player.stop();
        }
        catch(Exception e){
            System.out.println("Empty Song");
        }

        MusicManager.SoundPlayer(this, R.raw.sound_bgm);



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPop();
                goPlay();
            }
        });



        btnExit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                soundPop();
                finishAffinity();
                System.exit(0);

            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPop();
                goToSetting();
            }
        });


    }


    public void goPlay(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    public void goToSetting(){
        Intent intent = new Intent(this, Leaderboard2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }



    private void soundPop() {
        try {

            this.mPlayer = MediaPlayer.create(this, R.raw.sound_fix);

            if (this.mPlayer != null) {
                this.mPlayer.start();

                this.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mPlayer.release();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mPlayer != null) {
                this.mPlayer.release();
            }
        }
    }



}
