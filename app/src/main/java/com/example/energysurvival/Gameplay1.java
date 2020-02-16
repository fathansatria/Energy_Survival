package com.example.energysurvival;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Gameplay1 extends AppCompatActivity {

    private ImageButton btnSolar, btnWind, btnOil, btnCoal,btnInfo;
    private TextView tvMoney, tvNature, tvEnergy, tvTimer;
    private int money = 35000, nature = 1000 , energy = 0;
    private String pressed;
    private long timerGame = 30000;
    private CountDownTimer c1;
    private boolean timerRunning;
    private String account;
    Dialog infoDialog1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay1);

        btnSolar = findViewById(R.id.btn_solar);
        btnOil = findViewById(R.id.btn_oil);
        btnInfo = findViewById(R.id.btn_info1);
        btnCoal = findViewById(R.id.btn_coal);
        btnWind = findViewById(R.id.btn_wind);
        tvMoney = findViewById(R.id.tv_money);
        tvEnergy = findViewById(R.id.tv_energy);
        tvNature = findViewById(R.id.tv_nature);
        tvTimer = findViewById(R.id.tv_timer);
        infoDialog1 = new Dialog(this);
        infoDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        try{
            MusicManager.player.stop();
        }
        catch(Exception e){
            System.out.println("Empty Song");
        }

        MusicManager.SoundPlayer(this, R.raw.bgm_gameplay);


        Intent intent = getIntent();
        account = intent.getStringExtra("current");
        System.out.println(account + "di gameplay");

        timerCount();

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUp();
            }
        });


        btnOil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                soundPop();
                pressed = "oil";
                handler(pressed);
            }
        });

        btnSolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPop();
                pressed = "solar";
                handler(pressed);
            }
        });

        btnWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                soundPop();
                pressed = "wind";
                handler(pressed);
            }
        });

        btnCoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                soundPop();
                pressed = "coal";
                handler(pressed);
            }
        });


    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }



    public void handler (String status){

        if (status.equals("oil")){


            money = money - 1020;
            nature = nature - 80;
            energy = energy + 10;

            String moneyStr = Integer.toString(money);
            String natureStr = Integer.toString(nature);
            String energyStr = Integer.toString(energy);

            tvEnergy.setText(energyStr);
            tvNature.setText(natureStr);
            tvMoney.setText(moneyStr);


        }
        else if (status.equals("wind")){

            money = money - 1050;
            nature = nature - 30;
            energy = energy + 10;

            String moneyStr = Integer.toString(money);
            String natureStr = Integer.toString(nature);
            String energyStr = Integer.toString(energy);

            tvEnergy.setText(energyStr);
            tvNature.setText(natureStr);
            tvMoney.setText(moneyStr);

        }
        else if (status.equals("solar")){

            money = money - 2400;
            nature = nature - 10;
            energy = energy + 10;

            String moneyStr = Integer.toString(money);
            String natureStr = Integer.toString(nature);
            String energyStr = Integer.toString(energy);

            tvEnergy.setText(energyStr);
            tvNature.setText(natureStr);
            tvMoney.setText(moneyStr);
        }
        else if(status.equals("coal")){

            money = money - 1000;
            nature = nature - 100;
            energy = energy + 10;

            String moneyStr = Integer.toString(money);
            String natureStr = Integer.toString(nature);
            String energyStr = Integer.toString(energy);

            tvEnergy.setText(energyStr);
            tvNature.setText(natureStr);
            tvMoney.setText(moneyStr);
        }
        else{
            //nothing
        }

        if (money < 0 || nature < 0) {


            goToLose1();

        }
        else if (energy >= 200 && timerRunning){

            goToWin();

        }
        else{

        }

    }

    public void timerCount (){

        if (timerRunning)
        {
            stopTimer();
        }
        else{
            startTimer();
        }
    }

    public void startTimer () {

        c1 = new CountDownTimer(timerGame, 1000) {

            @Override
            public void onTick(long l) {
                timerGame = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                goToLose1();
            }

        }.start();

        timerRunning = true;
    }

    public void stopTimer(){
        c1.cancel();
        timerRunning = false;
    }

    public void updateTimer(){

        int minute = (int) timerGame / 60000;
        int second = (int) (timerGame % 60000 / 1000);

        String timeLeftText;
        timeLeftText = "" + minute;
        timeLeftText += ":" ;

        if(second < 10) timeLeftText += "0";
        timeLeftText += second;

        tvTimer.setText(timeLeftText);

    }



    public void goToLose1(){

        Intent intent = new Intent(this, YouLose1.class);
        stopTimer();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        try{
            MusicManager.player.stop();
        }
        catch(Exception e){
            System.out.println("Empty Song");
        }

        finishAffinity();


    }

    public void goToWin(){


        int totalScore = nature*100000 + (energy - 200)*5000;
        Intent intent = new Intent(this, DisplayScore.class);
        intent.putExtra("lv1",totalScore);
        intent.putExtra("level", "Level1");
        intent.putExtra("current", account);
        stopTimer();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        try{
            MusicManager.player.stop();
        }
        catch(Exception e){
            System.out.println("Empty Song");
        }

        finishAffinity();


    }

    private void soundPop() {

        final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.money2);

        try {

            if (mPlayer != null) {
                mPlayer.start();

                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mPlayer.release();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            if ( mPlayer != null) {
                 mPlayer.release();
            }
        }
    }

    public void showPopUp(){
        ImageButton btnclose;
        infoDialog1.setContentView(R.layout.info_popup);
        btnclose = (ImageButton)infoDialog1.findViewById(R.id.btn_close1);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoDialog1.dismiss();
            }
        });
        infoDialog1.show();


    }


}