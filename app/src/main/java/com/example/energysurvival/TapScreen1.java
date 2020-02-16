package com.example.energysurvival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TapScreen1 extends AppCompatActivity {

    private ImageView tapScreen1;
    private String account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_screen1);

        tapScreen1 = findViewById(R.id.iv_tapscreen1);

        Intent intent = getIntent();
        account = intent.getStringExtra("current");

        tapScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goPlay1();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goPlay1(){
        Intent intent = new Intent(this, Gameplay1.class);
        intent.putExtra("current",account);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
