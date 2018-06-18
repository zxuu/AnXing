package com.mingrisoft.anxingdemo3.UI.util;

import android.content.Context;
import android.media.MediaPlayer;

import com.mingrisoft.anxingdemo3.R;

/**
 * Created by 11455 on 2018/6/9.
 */

public class PlayVoice {
    //开始播放声音

        private static MediaPlayer mediaPlayer;

        public static void playVoice(Context context){
            try {
                mediaPlayer= MediaPlayer.create(context, R.raw.test);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    //停止播放声音
    public  static void stopVoice(){
        if(null!=mediaPlayer) {
            mediaPlayer.stop();
        }
    }
}

