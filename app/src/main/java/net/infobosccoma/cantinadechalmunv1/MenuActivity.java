package net.infobosccoma.cantinadechalmunv1;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

/**
 * Created by aoteros on 05/04/2016.
 */
public class MenuActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    static final String AUDIO_PATH = "@raw/cantinasong.mp3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        mediaPlayer.setOnPreparedListener(this);
//        //mediaPlayer.isPlaying(); per si mentres esta sonant per lo del looping
//        try {
//            mediaPlayer.setDataSource(AUDIO_PATH);
//            playAudio(); //Implementar el subprograma perque s'executi la musica.
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        //findViewById(R.id.btVideo).setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer = MediaPlayer.create(this, R.raw.cantinasong);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        //mediaPlayer.isPlaying(); per si mentres esta sonant per lo del looping
        try {
            mediaPlayer.setDataSource(AUDIO_PATH);
            playAudio(); //Implementar el subprograma perque s'executi la musica.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void onClickVideo(View v) {
        mediaPlayer.release();
        Intent i = new Intent (this, VideoActivity.class);
        startActivity(i);

    }

    public void onClickContingut(View v) {
        mediaPlayer.release();
        Intent i = new Intent (this, ContingutActivity.class);
        startActivity(i);
    }

    public void onClickAudio(View v) {
        mediaPlayer.release();
        Intent i = new Intent (this, GravacioAudio.class);
        startActivity(i);

    }

    private void playAudio() {
        mediaPlayer.prepareAsync();
    }

//    @Override
//    public void onPrepared(MediaPlayer mp) {
//        mp.start();
//        mp.setLooping(true);//serveix per fer que la musica faci looping.
//    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

//    @Override
//    public void onClick(View v) {
//        Intent i = new Intent (this, VideoActivity.class);
//        startActivity(i);
//    }
}
