package net.infobosccoma.cantinadechalmunv1;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.io.File;
import java.io.IOException;

/**
 * Created by aoteros on 11/04/2016.
 */
public class GravacioAudio extends AppCompatActivity {
    private static final String LOG_TAG = "GravacioAudio";
    private static String mFileName = null;

    private RecordButton mRecordButton = null;
    private MediaRecorder mRecorder = null;

    private PlayButton mPlayButton = null;
    private MediaPlayer mPlayer = null;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        LinearLayout ll = new LinearLayout(this);
        // es crea el botó de gravació i s'afegix al layout
        mRecordButton = new RecordButton(this);
        mRecordButton.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecord(!mRecordButton.isRecording());
            }
        });
        ll.addView(mRecordButton, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 0));

        // es crea el botó de reproducció i s'afegix al layout
        mPlayButton = new PlayButton(this);
        mPlayButton.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlay(!mPlayButton.isPlaying());
            }
        });
        ll.addView(mPlayButton, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 0));
        setContentView(ll);

        mFileName = getAudioFileName();
    }


    private String getAudioFileName() {
        String mFileName = "gravacioAudio.3gp";
        File path = new File(Environment.getExternalStorageDirectory(), getApplicationContext().getPackageName());
        if (!path.exists())
            path.mkdirs();

        return new File(path, mFileName).getAbsolutePath();
    }


    @Override
    public void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }


    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    /**
     * Iniciar la reproducció
     */
    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() player failed :: " + e.getMessage());
        }
    }

    /**
     * Aturar la reproducció
     */
    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    /**
     * Iniciar la gravació
     */
    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
            mRecorder.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

    }

    /**
     * Aturar la gravació
     */
    private void stopRecording() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }
}