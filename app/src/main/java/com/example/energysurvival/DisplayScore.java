package com.example.energysurvival;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayScore extends AppCompatActivity {

    private TextView scoreText;
    private ImageButton btnHome, btnReplay, btnSelect;
    private String level, currentAccount;
    private MediaPlayer win;
    DatabaseHelper db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);

        db1 = new DatabaseHelper(this);
        scoreText = findViewById(R.id.tv_score_view);
        btnHome = findViewById(R.id.btn_home_score);
        btnReplay = findViewById(R.id.btn_try_again);
        btnSelect = findViewById(R.id.btn_selectlevel);
        final MediaPlayer soundbutton = MediaPlayer.create(this,R.raw.sound_fix);
        win = win.create(this, R.raw.youwin);
        win.start();

        if(!(win.isPlaying())){
            MusicManager.SoundPlayer(this, R.raw.sound_bgm);
        }


        Bundle extras = getIntent().getExtras();
        level = extras.getString("level");
        currentAccount  = extras.getString("current");

        int lv1Score1 = extras.getInt("lv1");
        int lv1Score2 = extras.getInt("lv2");
        int lv1Score3 = extras.getInt("lv3");


        String s1 = Integer.toString(lv1Score1);
        String s2 = Integer.toString(lv1Score2);
        String s3 = Integer.toString(lv1Score3);


        System.out.println(s1);
        System.out.println(currentAccount);
        System.out.println(level);

        if (lv1Score1 != 0){
            scoreText.setText(s1);
            //db1.setScore1(currentAccount,lv1Score1);
            lv1Score1 = 0;
        }
        else if (lv1Score2 != 0){
            scoreText.setText(s2);
            //db1.setScore2(currentAccount,lv1Score2);
            lv1Score2 = 0;
        }
        else if (lv1Score3 != 0){
            scoreText.setText(s3);
            //db1.setScore3(currentAccount,lv1Score3);
            lv1Score3 = 0;
        }
        else{
            //nothings
        }

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbutton.start();
                home();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbutton.start();
                selectLevel();
            }
        });

        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbutton.start();
                goBack(level);
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void selectLevel(){
        Intent intent = new Intent(this, SelectLevel.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        MusicManager.SoundPlayer(this, R.raw.sound_bgm);
    }

    public void goBack(String currentLevel){

        Intent intent;

        try{
            MusicManager.player.stop();
        }
        catch(Exception e){
            System.out.println("Empty Song");
        }

        if (currentLevel.equals("Level1")){
            intent = new Intent(this, TapScreen1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
        else if (currentLevel.equals("Level")){
            intent = new Intent(this, TapScreen2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        }
        else if (currentLevel.equals("Level3")){
            intent = new Intent(this, TapScreen3.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
        else
        {
            System.out.println("error");
        }


    }

    public void home(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}
