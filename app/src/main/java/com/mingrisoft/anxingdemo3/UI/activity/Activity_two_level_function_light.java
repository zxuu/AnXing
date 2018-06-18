package com.mingrisoft.anxingdemo3.UI.activity;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mingrisoft.anxingdemo3.R;

/**
 * Created by 11455 on 2018/6/9.
 */

public class Activity_two_level_function_light extends AppCompatActivity {

    private Button open;
    private Button close;
    private Button openFlicker;
    private Button closeFlicker;
    private Camera camera;
    private Boolean isShanshuo;
    //Camera camera = Camera.open();
    //Camera.Parameters p = camera.getParameters();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_level_function_light);


       // processOnFlash();
        open = (Button) this.findViewById(R.id.buttonop);
        close = (Button) this.findViewById(R.id.buttonst);
        openFlicker = (Button) findViewById(R.id.buttonshan);
        closeFlicker = (Button) findViewById(R.id.buttonguan);

        open.setOnClickListener(openOnClickListener);
        close.setOnClickListener(closeOnClickListener);
        openFlicker.setOnClickListener(openFlickerOnClickListener);
        closeFlicker.setOnClickListener(closeFlickerOnClickListener);


    }

    /**
     * 打开手电筒
     */
    private View.OnClickListener openOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            open();
        }
    };

    /**
     * 关闭手电筒
     */
    private View.OnClickListener closeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            close();
        }
    };

    /**
     * 开启闪烁
     */
    private View.OnClickListener openFlickerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isShanshuo = true;
            openFlicker.setEnabled(false);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isShanshuo) {
                        open();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        close();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    };

    /**
     * 关闭闪烁
     */
    private View.OnClickListener closeFlickerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isShanshuo = false;
            openFlicker.setEnabled(true);
        }
    };
    /**
     * 打开闪光灯
     *
     * @return
     */
    private void open() {
        try {
            camera = Camera.open();
            camera.startPreview();
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 关闭闪光灯
     *
     * @return
     */
    private void close() {
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameters);
            camera.release();
            camera = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    //手电筒闪光开启
//    private void processOnFlash(){
//        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//        camera.setParameters(p);
//        camera.startPreview();
//    }
//    //手电筒闪光关闭
//    private void processOffFlash(){
//        p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//        camera.setParameters(p);
//        camera.stopPreview();
//    }
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        camera.setPreviewCallback(null);
//        camera.stopPreview();
//        camera.release();
//        camera = null;
//    }

}
