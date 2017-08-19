package com.ssappclinic.pianoguru;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText note;
    protected Button playPause,stop;
    int i, t = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        note = (EditText) findViewById(R.id.note);
        playPause = (Button) findViewById(R.id.play_pause);
        stop = (Button) findViewById(R.id.stop);
        playPause.setOnClickListener(this);
       stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_pause:
                String noteTones = note.getText().toString();
                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(noteTones.split("\\s+")));
                i = 0;
                String s = arrayList.get(i);
                MusicPlayer.i=0;
                 MusicPlayer.playMusic(s,this,arrayList);

                break;

            case  R.id.stop:
                if(MusicPlayer.mediaPlayer.isPlaying())
                    MusicPlayer.mediaPlayer.stop();
                break;
        }
    }
}
