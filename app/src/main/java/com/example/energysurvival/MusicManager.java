package com.example.energysurvival;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicManager {

    public static MediaPlayer player;

    public static void SoundPlayer(Context ctx,int raw_id){

        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(true);
        player.setVolume(70,70);// Set looping

        //player.release();
        player.start();
    }
}
