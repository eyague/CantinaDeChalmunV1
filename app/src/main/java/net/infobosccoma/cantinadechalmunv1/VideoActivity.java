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
    final String VIDEOPATH = "http://r6---sn-q4fl6n7y.googlevideo.com/videoplayback?initcwndbps=637500&upn=ADjEBotwf2g&source=youtube&fexp=9407610%2C9408210%2C9408522%2C9416074%2C9416126%2C9416891%2C9419451%2C9420452%2C9422342%2C9422596%2C9423662%2C9426926%2C9427902%2C9428398%2C9429149%2C9429165%2C9429585%2C9432363%2C9433301%2C9433424%2C9433858%2C9433999&lmt=1458210531353179&axtags=tx%3D9417362&nh=IgpwcjA1LmRmdzA2KgkxMjcuMC4wLjE&key=yt6&mime=video%2Fmp4&signature=808FA0AD13C38FB290D4B5979AF5F335B5A39404.65F9F3B51ACFA583A5A9B46AE8CC5D93B52B9F84&pte=yes&dur=381.364&ipbits=0&sver=3&expire=1460403122&ratebypass=yes&ip=2a03%3A8180%3A1001%3A16a%3A%3A8ee1&sparams=axtags%2Cdur%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Cpte%2Cratebypass%2Csource%2Cupn%2Cexpire&mv=m&mt=1460381390&ms=au&itag=18&mn=sn-q4fl6n7y&mm=31&pl=40&id=o-AL-5PJhKcCfmpVZi5A-xW3_QJ3MmjOBcR1a3TzI-EzLW&title=Original+Cantina+Scene+-+A+New+Hope+%5B1080p+HD%5D";
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