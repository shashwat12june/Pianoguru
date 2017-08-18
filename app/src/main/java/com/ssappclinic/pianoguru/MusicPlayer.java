package com.ssappclinic.pianoguru;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Shashwat-PC on 18-08-2017.
 */

public class MusicPlayer extends MediaPlayer {
    String song;

   static MediaPlayer mediaPlayer;
    static int sounds[]={R.raw.a1,R.raw.a1s,R.raw.b1,R.raw.c1,R.raw.c1s,R.raw.c2,R.raw.d1,R.raw.d1s,R.raw.e1,R.raw.f1,R.raw.f1s,R.raw.g1,R.raw.g1s};
static int i=0;

    public static MediaPlayer mPlayer()
    {
        if (mediaPlayer==null)
        mediaPlayer=new MediaPlayer();

        return mediaPlayer;
    }

    public static void playMusic(String arg, final Context context, final ArrayList arrayList)
    {

        mediaPlayer= mPlayer();

        switch (arg)
        {
            case "A1":
                mediaPlayer=MediaPlayer.create(context, sounds[0]);
                mediaPlayer.start();
                break;
            case "A1s":
                mediaPlayer=MediaPlayer.create(context, sounds[1]);
                mediaPlayer.start();
                break;
            case "B1":
                mediaPlayer=MediaPlayer.create(context, sounds[2]);
                mediaPlayer.start();
                break;
            case "C1":
                mediaPlayer=MediaPlayer.create(context, sounds[3]);
                mediaPlayer.start();
                break;
            case "C1s":
                mediaPlayer=MediaPlayer.create(context, sounds[4]);
                mediaPlayer.start();
                break;
            case "C2":
                mediaPlayer=MediaPlayer.create(context, sounds[5]);
                mediaPlayer.start();
                break;
            case "D1":
                mediaPlayer=MediaPlayer.create(context, sounds[6]);
                mediaPlayer.start();
                break;
            case "D1s":
                mediaPlayer=MediaPlayer.create(context, sounds[7]);
                mediaPlayer.start();
                break;
            case "E1":
                mediaPlayer=MediaPlayer.create(context, sounds[8]);
                mediaPlayer.start();
                break;
            case "F1":
                mediaPlayer=MediaPlayer.create(context, sounds[9]);
                mediaPlayer.start();
                break;
            case "F1s":
                mediaPlayer=MediaPlayer.create(context, sounds[10]);
                mediaPlayer.start();
                break;
            case "G1":
                mediaPlayer=MediaPlayer.create(context, sounds[11]);
                mediaPlayer.start();
                break;
            case "G1s":
                mediaPlayer=MediaPlayer.create(context, sounds[12]);
                mediaPlayer.start();
                break;
            case ".":
                Runnable r = new Runnable() {
                    @Override
                    public void run(){

                    }
                };

                Handler h = new Handler();
                h.postDelayed(r, 50);
                i++;
                if(i<arrayList.size())
                    playMusic((String) arrayList.get(i),context,arrayList);
                break;

            default:
                Toast.makeText(context,"Wrong input !!!!",Toast.LENGTH_LONG).show();
                break;
        }


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                i++;
                if(i<arrayList.size())
           playMusic((String) arrayList.get(i),context,arrayList);
            }
        });


}
}
