package com.mingrisoft.anxingdemo3.UI.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.MyApplication;
import com.mingrisoft.anxingdemo3.UI.model.IAndUrgenPer;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class AddUergenPerson extends AppCompatActivity {

    EditText urgenTel;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_uergen_person);
        inint();
    }

    private void inint() {
        urgenTel = (EditText) findViewById(R.id.uergenper_edittext);
        button = (Button) findViewById(R.id.confirm_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IAndUrgenPer iAndUrgenPer = new IAndUrgenPer();
                String tel = String.valueOf(urgenTel.getText());

                iAndUrgenPer.setIname(MyApplication.name);
                iAndUrgenPer.setItel(MyApplication.tel);
                iAndUrgenPer.setUrgenpertel(tel);

                iAndUrgenPer.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        Toast.makeText(AddUergenPerson.this, "添加成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
