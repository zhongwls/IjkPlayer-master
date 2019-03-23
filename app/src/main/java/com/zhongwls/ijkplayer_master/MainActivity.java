package com.zhongwls.ijkplayer_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.zhongwls.ijkplayer.player.IjkVideoView;
import com.zhongwls.ijkplayer.player.PlayerConfig;
import com.zhongwls.ijkplayer.ui.StandardVideoController;
import com.zhongwls.ijkplayer_master.R;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {
    private static final String VOD_URL = "http://mov.bn.netease.com/open-movie/nos/flv/2017/01/03/SC8U8K7BC_hd.flv";
    private IjkVideoView ijkVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playBtn = (Button) findViewById(R.id.btn_play_id);
        ijkVideoView = (IjkVideoView) findViewById(R.id.ijk_id);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ijkVideoView.start();

            }
        });

        StandardVideoController controller = new StandardVideoController(this);

        ijkVideoView.setPlayerConfig(new PlayerConfig.Builder()
//                .autoRotate()//自动旋转屏幕
//                    .enableCache()//启用边播边存
//                    .enableMediaCodec()//启动硬解码
//                    .usingSurfaceView()//使用SurfaceView
//                    .setCustomMediaPlayer(new ExoMediaPlayer(this))
//                    .setCustomMediaPlayer(new AndroidMediaPlayer(this))
                .build());
//            ijkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
        Glide.with(this).load("http://pic3.nipic.com/20090527/1242397_102231006_2.jpg").into(controller.getThumb());
        controller.getThumb();
        ijkVideoView.setTitle("测试的标题");
        ijkVideoView.setUrl(VOD_URL);
        ijkVideoView.setVideoController(controller);
        //播放状态监听
//            ijkVideoView.addOnVideoViewStateChangeListener(mOnVideoViewStateChangeListener);
    }


    @Override
    protected void onPause() {
        super.onPause();
        ijkVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ijkVideoView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ijkVideoView.release();
    }


    @Override
    public void onBackPressed() {
        if (!ijkVideoView.onBackPressed()) {
            super.onBackPressed();
        }
    }

}
