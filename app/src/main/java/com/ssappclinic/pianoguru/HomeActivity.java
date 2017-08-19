package com.ssappclinic.pianoguru;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText note;
    static protected TextView currentPos;
    static String str="";
    protected Button playPause,stop;
    int i, t = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         currentPos=(TextView)findViewById(R.id.currentPos) ;
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
                currentPos.setText(" ");
                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(noteTones.split("\\s+")));
                i = 0;
                Hidekeyboard();

                String s = arrayList.get(i);
                MusicPlayer.i=0;
                 MusicPlayer.playMusic(s,this,arrayList);

                break;

            case  R.id.stop:
                if(MusicPlayer.mediaPlayer.isPlaying()) {
                    MusicPlayer.mediaPlayer.stop();
                    MusicPlayer.mediaPlayer.reset();
                }
                break;
        }
    }

    private void Hidekeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void setText(String s)
{
    if (str.length()>=20)
        str="";
    str=str+" "+s;

    currentPos.setText(str);

}
}
