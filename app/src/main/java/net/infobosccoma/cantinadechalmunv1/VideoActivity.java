package net.infobosccoma.cantinadechalmunv1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by aoteros on 11/04/2016.
 */
public class VideoActivity extends AppCompatActivity {
    private MediaController mediaController;
    private VideoView videoView;
    final String VIDEOPATH = "http://r5---sn-aiglln6l.googlevideo.com/videoplayback?id=o-AAyKYmpyCtFAFkvEZsRGDFYS_F154j1hYnnMSLW_sFdo&sparams=dur%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Cratebypass%2Csource%2Cupn%2Cexpire&key=yt6&initcwndbps=12252500&ip=146.185.29.14&dur=381.364&fexp=9405967%2C9416126%2C9416891%2C9420452%2C9422596%2C9423662%2C9425791%2C9426927%2C9427902%2C9428398%2C9429315%2C9429694%2C9429741%2C9430067%2C9431859%2C9432564%2C9433425%2C9433630%2C9433783%2C9433803&ms=au&mt=1460386740&mv=m&source=youtube&mm=31&mn=sn-aiglln6l&upn=YP9SU13lgoY&lmt=1458210539602116&signature=31BC3E501C9059FADB12F0F33A5F8D81153C86BA.E25A4BA368BFF69522026368A31BE7F424F1A07E&mime=video%2Fmp4&itag=22&sver=3&ipbits=0&pl=24&ratebypass=yes&nh=IgpwcjAyLmxocjE0KgkxMjcuMC4wLjE&expire=1460408477&title=Original+Cantina+Scene+-+A+New+Hope+%5B1080p+HD%5D";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        videoView.setMediaController(mediaController);
        videoView.setVideoPath(VIDEOPATH);
        videoView.start();
    }
}