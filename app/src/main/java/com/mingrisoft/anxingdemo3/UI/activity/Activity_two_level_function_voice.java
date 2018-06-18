package com.mingrisoft.anxingdemo3.UI.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.util.PlayVoice;

/**
 * Created by 11455 on 2018/6/9.
 */

public class Activity_two_level_function_voice extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.two_level_function_voice);
        View view =  this.findViewById(R.id.voice_btn);
        view.setOnClickListener(this);
         view =  this.findViewById(R.id.voice_btn2);
        view.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.voice_btn:{
                //直接创建，不需要设置setDataSource
                //mMediaPlayer= MediaPlayer.create(this, R.raw.audio);
                //mMediaPlayer.start();
                PlayVoice.playVoice(this);
                break;

            }
            case R.id.voice_btn2:{
                PlayVoice.stopVoice();
                finish();

            }
        }
    }
}
