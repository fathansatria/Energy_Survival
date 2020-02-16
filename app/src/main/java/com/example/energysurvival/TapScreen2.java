package com.example.energysurvival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TapScreen2 extends AppCompatActivity {

    private ImageView tapScreen2;
    private String account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapscreen2);

        tapScreen2 = findViewById(R.id.iv_tapscreen2);

        Intent intent = getIntent();
        account = intent.getStringExtra("current");

        tapScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goPlay2();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goPlay2(){
        Intent intent = new Intent(this, Gameplay2.class);
        intent.putExtra("current",account);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
