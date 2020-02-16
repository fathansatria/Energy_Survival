package com.example.energysurvival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Leaderboard2 extends AppCompatActivity {

    private ImageView help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard2);

        help = findViewById(R.id.iv_help);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMain();
            }
        });
    }

    public void goMain (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
