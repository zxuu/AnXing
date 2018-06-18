package com.mingrisoft.anxingdemo3.UI.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.MainActivity;
import com.mingrisoft.anxingdemo3.UI.util.AnXingUser;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class LogInActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login,register;
    private EditText user,pass;
    private int requestCode ;
    private String userName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_log_in);
        initialize();
        initView();


    }
/*
* 时间：2018.6.4
* 人：黄华飞
* 功能：获取本地用户并登陆
*
* */
    private void initView() {
        AnXingUser userInfo = BmobUser.getCurrentUser(AnXingUser.class);
        if(userInfo != null){
            Intent intent_main = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent_main);
        }else{
//            TODO
        }
    }
/*
 time:2018.6.1
 editer:黄华飞
 mean：监听初始化
 */
    private void initialize() {
        Bmob.initialize(this,"43e2eca80dfd913ca7cc0c6b9382be66");

        View v = findViewById(R.id.Login_button);//找到你要设透明背景的layout 的id
        v.getBackground().setAlpha(100);//0~255透明度值
        login=findViewById(R.id.Login_button);
        login.setTextColor(Color.WHITE);
        View view = findViewById(R.id.Register_button);//找到你要设透明背景的layout 的id
        view.getBackground().setAlpha(100);//0~255透明度值
        register=findViewById(R.id.Register_button);
        register.setTextColor(Color.WHITE);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

        user=findViewById(R.id.login_account);
        pass=findViewById(R.id.login_password);
    }

    /*
         time:2018.6.1
         editer:黄华飞
         mean：点击事件
         */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Register_button:
                requestCode=0;
                Intent intent1 = new Intent();
                intent1.setClass(LogInActivity.this,RegisterActivity.class);
                startActivityForResult(intent1, requestCode);
                break;
            case R.id.Login_button:
                String user_num = user.getText().toString();
                String user_password = pass.getText().toString();
                if(user_num.length()<=0||user_password.length()<=0){
                    toast( "密码或账号不为空!");
                    return;
                }
                BmobUser u=new AnXingUser();
                u.setUsername(user_num);
                u.setPassword(user_password);
                u.login(new SaveListener<AnXingUser>() {
                    @Override
                    public void done(AnXingUser anXingUser, BmobException e) {
                        if(e==null){
                            toast(" 登录成功");
                            Intent intent_main = new Intent(LogInActivity.this, MainActivity.class);
                            startActivity(intent_main);
                        }else{
                            toast(" 登录失败");
                        }
                    }
                });
                break;
        }

    }
    /*
         time:2018.6.1
         editer:黄华飞
         mean：返回结果显示
         */
    @Override
    protected void onActivityResult(int reCode, int resultCode, Intent data) {
        super.onActivityResult(reCode, resultCode, data);
            if (reCode == requestCode) {
                userName=data.getStringExtra("userName");
                password=data.getStringExtra("password");
                user.setText(userName);
                pass.setText(password);
            }
    }
    private void toast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
