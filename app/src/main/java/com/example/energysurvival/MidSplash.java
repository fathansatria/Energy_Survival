package com.example.energysurvival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.List;

public class MidSplash extends AppCompatActivity {

    private RelativeLayout hollaScreen;
    private TextView name;
    private String account;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_splash);
        mDatabaseHelper = new DatabaseHelper(this);

        hollaScreen = findViewById(R.id.ly_midSplash);
        name = findViewById(R.id.tv_name);

        Intent intent = getIntent();
        account = intent.getStringExtra("current");
        name.setText(account);


        hollaScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goIntro1();
            }
        });

        List<Player> allPlayer = mDatabaseHelper.getAllPlayer();

        for (Player std : allPlayer) {
            System.out.println(std.getUsername());
        }


    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goIntro1(){
        Intent intent = new Intent(this, Introduction1.class);
        intent.putExtra("current", account);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
