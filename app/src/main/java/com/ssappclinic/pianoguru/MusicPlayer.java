package com.ssappclinic.pianoguru;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by Shashwat-PC on 18-08-2017.
 */

public class MusicPlayer extends MediaPlayer {
    String song;

   static MediaPlayer mediaPlayer;

static int i=0;
    static String state="False";




    public static MediaPlayer mPlayer()
    {

        if (mediaPlayer==null)
        mediaPlayer=new MediaPlayer();

        return mediaPlayer;
    }

    public static void playMusic(String arg, final Context context, final ArrayList arrayList)
    {
        //if stop button is clicked than exit
        if(state.equals("true"))
            System.exit(0);
        HomeActivity.setText(arg);
        mediaPlayer= mPlayer();
        if(arg.equals("."))
        {  Runnable r = new Runnable() {
            @Override
            public void run(){

            }
        };

            Handler h = new Handler();
            h.postDelayed(r, 50);
            i++;
            if(i<arrayList.size())
                playMusic((String) arrayList.get(i),context,arrayList);
        }
        else {
             int a= (int) HomeActivity.hm.get(arg);
            mediaPlayer = MediaPlayer.create(context, a);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    i++;
                    if (i < arrayList.size())
                        playMusic((String) arrayList.get(i), context, arrayList);
                    mediaPlayer.reset();
                }
            });

        }
}
}
