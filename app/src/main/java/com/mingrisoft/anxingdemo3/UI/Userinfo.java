package com.mingrisoft.anxingdemo3.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.activity.LogInActivity;
import com.mingrisoft.anxingdemo3.UI.util.AnXingUser;

import cn.bmob.v3.BmobUser;

public class Userinfo extends AppCompatActivity implements View.OnClickListener{

    private TextView nametext;
    private TextView teltext;
    private TextView agetext;
    private TextView sextext;
    private Button exitd;
    private String username,mobilePhoneNumber,sex;
    Integer age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.userinfo);
        initView();
        showUser();
    }
    /*
* time:2018.6.4
  editer:黄华飞
  mean：显示用户个人信息
* */
    private void showUser() {
        AnXingUser u = BmobUser.getCurrentUser(AnXingUser.class);
        if(u != null){
            username = (String) BmobUser.getObjectByKey("username");
            age = (Integer) BmobUser.getObjectByKey("age");
            sex = (String) BmobUser.getObjectByKey("sex");
            mobilePhoneNumber = (String) BmobUser.getObjectByKey("mobilePhoneNumber");
//            username=u.getNickName();
//            phone =u.getMobilePhoneNumber();
//            sex=u.getSex();
//            age=u.getAge();

            nametext.setText(username);
            agetext.setText(age.toString());
            teltext.setText(mobilePhoneNumber);
            sextext.setText(sex);

        }else{
            Toast.makeText(this,"无法获得当前用户信息",Toast.LENGTH_LONG).show();
        }
    }

    /*
    time:2018.5.13
    editer:书豪
    mean：初始化按钮
   */
    @SuppressLint("WrongViewCast")
    private void initView()
    {
        nametext = findViewById(R.id.nametext);
        teltext = findViewById(R.id.teltext);
        agetext = findViewById(R.id.agetext);
        sextext =findViewById(R.id.sextext);
        exitd = findViewById(R.id.exit);

        exitd.setOnClickListener(this);
    }

    /*
     time:2018.6.4
    editer:黄华飞
    mean：点击事件(退出登录)
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                BmobUser.logOut();
                Intent exit_intent=new Intent(Userinfo.this, LogInActivity.class);
                startActivity(exit_intent);
                break;

        }

    }
}
