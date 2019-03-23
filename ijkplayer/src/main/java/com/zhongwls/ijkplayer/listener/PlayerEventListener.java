package com.zhongwls.ijkplayer.listener;

/**
 * Created by zwl on 2019/3/1.
 */
public interface PlayerEventListener {

    void onError();

    void onCompletion();

    void onInfo(int what, int extra);

    void onPrepared();

    void onVideoSizeChanged(int width, int height);

}
