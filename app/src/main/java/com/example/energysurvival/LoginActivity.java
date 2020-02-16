package com.example.energysurvival;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private ImageButton btnOk;
    private EditText edtusername;
    private String currentAccount;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabaseHelper = new DatabaseHelper(this);

        btnOk = findViewById(R.id.btn_ok);
        edtusername = findViewById(R.id.edt_username);
        final MediaPlayer soundbutton = MediaPlayer.create(this,R.raw.sound_fix);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbutton.start();
                String user = edtusername.getText().toString();
                currentAccount = user;

                Player p1 = new Player();
                p1.setUsername(user);

                mDatabaseHelper.registerPlayer(p1);

                Toast.makeText(getApplicationContext(), "Login Succesfull : " + p1.getUsername(),
                        Toast.LENGTH_LONG).show();

                goMidSplash(currentAccount);

            }
        });


    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void goMidSplash(String user){

        Intent intent = new Intent(this, MidSplash.class);
        intent.putExtra("current",user);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

    }

    public String getCurrentAccount() {
        return currentAccount;
    }
}
