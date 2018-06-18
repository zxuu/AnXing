package com.mingrisoft.anxingdemo3.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.activity.Activity_two_level_function_conversation;
import com.mingrisoft.anxingdemo3.UI.activity.Activity_two_level_function_light;
import com.mingrisoft.anxingdemo3.UI.activity.Activity_two_level_function_video;
import com.mingrisoft.anxingdemo3.UI.activity.Activity_two_level_function_voice;

public class AXPopWindows extends AppCompatActivity implements View.OnClickListener{

    ImageView yuyinImg;
    ImageView shoudianImg;
    ImageView shipingImg;
    ImageView dianhuaImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindows);
        inint();
    }

    private void inint() {
        yuyinImg = (ImageView) findViewById(R.id.yuyin_btn);
        shoudianImg = (ImageView) findViewById(R.id.shiping_btn);
        shipingImg = (ImageView) findViewById(R.id.dianhua_btn);
        dianhuaImg = (ImageView) findViewById(R.id.shoudian_btn);
        yuyinImg.setOnClickListener(this);
        shoudianImg.setOnClickListener(this);
        shipingImg.setOnClickListener(this);
        dianhuaImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yuyin_btn:
                startActivity(new Intent(AXPopWindows.this, Activity_two_level_function_voice.class));
                break;
            case R.id.dianhua_btn:
                startActivity(new Intent(AXPopWindows.this, Activity_two_level_function_conversation.class));
                break;
            case R.id.shiping_btn:
                startActivity(new Intent(AXPopWindows.this, Activity_two_level_function_video.class));
                break;
            case R.id.shoudian_btn:
                startActivity(new Intent(AXPopWindows.this, Activity_two_level_function_light.class));
                break;
        }
    }
}
