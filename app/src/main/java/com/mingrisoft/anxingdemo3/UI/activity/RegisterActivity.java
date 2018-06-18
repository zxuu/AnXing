package com.mingrisoft.anxingdemo3.UI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.util.AnXingUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/*用户名+密码+确认密码+电话+邮箱
 * private String username;
 * private String password;
 * private String email;
 * private String mobilePhoneNumber;
 */
public class RegisterActivity extends AppCompatActivity{
    private EditText name,psw,psw_2,email,mobile,age_r,nickName,sex_r;
    private Button register;
    private int age,stateCode;
    String userName,emailText,phone,pass1,pass2,nick_name,sexx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        initialize();
        initView();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=name.getText().toString();
                pass1=psw.getText().toString();
                pass2=psw_2.getText().toString();
                emailText=email.getText().toString();
                phone=mobile.getText().toString();

                nick_name=nickName.getText().toString();
                age=Integer.valueOf(age_r.getText().toString());
                sexx=sex_r.getText().toString();

                stateCode=getStatus(userName,pass1,pass2,emailText,phone,nick_name,age,sexx);
                if(stateCode==1){
                    AnXingUser u = new AnXingUser();
                    u.setUsername(userName);
                    u.setPassword(pass1);
                    u.setEmail(emailText);
                    u.setMobilePhoneNumber(phone);
                    u.setAge(age);
                    u.setNickName(nick_name);
                    u.setSex(sexx);

                    u.signUp(new SaveListener<AnXingUser>() {
                        @Override
                        public void done(AnXingUser anXingUser, BmobException e) {
                            if(e==null){
                                toast("注册成功！:" +anXingUser.toString());
                                Intent intent = new Intent();
                                intent.putExtra("userName", userName);
                                intent.putExtra("password", pass1);
                                setResult(0, intent);
                                finish();
                            }else{
                                toast("注册失败！"+e.getMessage());
                            }
                        }
                    });

                }
            }
        });
    }
        /*  2018.6.2
         *   黄华飞
         * 注册按钮监听
         */
    private void initView() {

    }

    private void initialize() {
        View v = findViewById(R.id.register_button_sure);//找到你要设透明背景的layout 的id
        v.getBackground().setAlpha(100);//0~255透明度值
        name=findViewById(R.id.register_name);
        psw=findViewById(R.id.register_password);
        psw_2=findViewById(R.id.register_pass_two);
        email=findViewById(R.id.register_email);
        mobile=findViewById(R.id.register_phone);
        register=findViewById(R.id.register_button_sure);
        age_r=findViewById(R.id.register_age);
        nickName=findViewById(R.id.register_nick);
        sex_r=findViewById(R.id.register_sex);

    }
    /*  2018.6.2
     *   黄华飞
     * 判断注册信息是否正确
     */
    private int getStatus(String userName, String pass1, String pass2, String emailText, String phone,String nick,int age,String sex) {
        int num=1;
        if(userName.length()<=0||userName.length()>=20||nick.length()<=0||nick.length()>=15){
            toast("账户名或者昵称长度不对！");
            num=0;
        }else if(!(pass1.equals(pass2))||pass1.length()<=0){
            toast("密码不一致或密码格式不对！");
            num=0;
        }else if(emailText.length()<=0||phone.length()!=11){
            toast("邮箱或电话格式不对！");
            num=0;
        }else if(age<=0||age>=100||(!sex.equals("man")&&!sex.equals("woman"))){
            toast("年龄或性别不对！");
            num=0;
        }
        return num;
    }
    /*  2018.6.2
     *   黄华飞
     * 显示信息
     */
    private void toast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }


}
