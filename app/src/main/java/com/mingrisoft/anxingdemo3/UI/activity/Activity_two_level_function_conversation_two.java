package com.mingrisoft.anxingdemo3.UI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.mingrisoft.anxingdemo3.R;

/**
 * Created by 11455 on 2018/6/9.
 */

public class Activity_two_level_function_conversation_two extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.two_level_function_conversation_two);
        View view = this.findViewById(R.id.callbutton2);
        view.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.callbutton2:{
                Intent intent = new Intent(Activity_two_level_function_conversation_two.this,Activity_two_level_function_conversation.class);
                startActivity(intent);
                finish();


                break;
            }

    }
}
}
