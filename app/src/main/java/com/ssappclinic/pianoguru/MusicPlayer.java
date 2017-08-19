package com.ssappclinic.pianoguru;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Shashwat-PC on 18-08-2017.
 */

public class MusicPlayer extends MediaPlayer {
    String song;

   static MediaPlayer mediaPlayer;
    static int sounds[]={R.raw.a1,R.raw.a1s,R.raw.b1,R.raw.c1,R.raw.c1s,R.raw.c2,R.raw.d1,R.raw.d1s,R.raw.e1,R.raw.f1,R.raw.f1s,R.raw.g1,R.raw.g1s};
static int i=0;
  static  ArrayList<String> arrays=new ArrayList<String>(Arrays.asList("A1","A1s","B1","C1","C1s","C2","D1","D1s","E1","F1","F1s","G1","G1s"));
    public static MediaPlayer mPlayer()
    {
        if (mediaPlayer==null)
        mediaPlayer=new MediaPlayer();

        return mediaPlayer;
    }

    public static void playMusic(String arg, final Context context, final ArrayList arrayList)
    {

        mediaPlayer= mPlayer();
        if(arg==".")
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
            int pos = arrays.indexOf(arg);
            mediaPlayer = MediaPlayer.create(context, sounds[pos]);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    i++;
                    if (i < arrayList.size())
                        playMusic((String) arrayList.get(i), context, arrayList);
                }
            });

        }
}
}
