package com.mingrisoft.anxingdemo3.UI.activity;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;

import com.mingrisoft.anxingdemo3.R;

import java.io.File;
import java.io.IOException;

/**
 * Created by 11455 on 2018/6/9.
 */

public class Activity_two_level_function_video extends AppCompatActivity {

//    private final String TAG = "main";
//    private EditText et_path;
//    private SurfaceView sv;
//    private Button btn_play, btn_pause, btn_replay, btn_stop;
//    private MediaPlayer mediaPlayer;
//    private SeekBar seekBar;
//    private int currentPosition = 0;
//    private boolean isPlaying;

    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    //读取本地文件
    private File file=new File("/storage/sdcard1/音乐/", "曾经的你.mp4");
    //访问网络视频
    private String uri="http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com   /D046015255134077DDB3ACA0D7E68D45.flv";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.two_level_function_video);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        mediaPlayer = new MediaPlayer();
        //获取SurfaceHolder 可以通过该接口来操作SurfaceView中的Surface
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        //设置Meiaplayer的准备监听
        mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //准备完成后播放
                mediaPlayer.start();
            }




       // seekBar = (SeekBar) findViewById(R.id.seekBar);
//        sv = (SurfaceView) findViewById(R.id.sv);
//        et_path = (EditText) findViewById(R.id.et_path);
//
//        btn_play = (Button) findViewById(R.id.btn_play);
//        btn_pause = (Button) findViewById(R.id.btn_pause);
//        btn_replay = (Button) findViewById(R.id.btn_replay);
//        btn_stop = (Button) findViewById(R.id.btn_stop);
//
//        btn_play.setOnClickListener(click);
//        btn_pause.setOnClickListener(click);
//        btn_replay.setOnClickListener(click);
//        btn_stop.setOnClickListener(click);
//
//        // 为SurfaceHolder添加回调
//        sv.getHolder().addCallback(callback);
//
//        // 4.0版本之下需要设置的属性
//        // 设置Surface不维护自己的缓冲区，而是等待屏幕的渲染引擎将内容推送到界面
//        // sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//
//        // 为进度条添加进度更改事件
//        seekBar.setOnSeekBarChangeListener(change);


        });

            surfaceHolder.addCallback(new Callback() {
                //当SurfaceView中Surface创建时回掉
                //该方法表示Surface已经创建完成，可以在该方法中进行绘图操作
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    mediaPlayer.reset();
                    try {
                        //设置视屏文件图像的显示参数
                        mediaPlayer.setDisplay(holder);

                        //file.getAbsolutePath()本地视频
                        //uri 网络视频
                        mediaPlayer.setDataSource(Activity_two_level_function_video.this, Uri.parse(uri));
                        //prepare();表示准备工作同步进行，（准备工作在UI线程中进行）
                        //当播放网络视频时，如果网络不要 会报ARN 所以不采用该方法
                        //mediaPlayer.prepare();
                        //异步准备 准备工作在子线程中进行 当播放网络视频时候一般采用此方法
                        mediaPlayer.prepareAsync();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                //当SurfaceView的大小发生改变时候触发该方法
                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                }
                //Surface销毁时回掉
                //当Surface销毁时候，同时把MediaPlayer也销毁
                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    if (mediaPlayer!=null) {
                        mediaPlayer.stop();
                        //释放资源
                        mediaPlayer.release();
                    }
                }
            });
            //设置 surfaceView点击监听
        surfaceView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            if (mediaPlayer.isPlaying()) {
                                mediaPlayer.pause();
                            } else {
                                mediaPlayer.start();
                            }
                            break;
                    }
                    //返回True代表事件已经处理了
                    return true;
                }
            });


    }
//
//
//
//    private Callback callback = new Callback() {
//        // SurfaceHolder被修改的时候回调
//        @Override
//        public void surfaceDestroyed(SurfaceHolder holder) {
//            Log.i(TAG, "SurfaceHolder 被销毁");
//            // 销毁SurfaceHolder的时候记录当前的播放位置并停止播放
//            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//                currentPosition = mediaPlayer.getCurrentPosition();
//                mediaPlayer.stop();
//            }
//        }
//
//        @Override
//        public void surfaceCreated(SurfaceHolder holder) {
//            Log.i(TAG, "SurfaceHolder 被创建");
//            if (currentPosition > 0) {
//                // 创建SurfaceHolder的时候，如果存在上次播放的位置，则按照上次播放位置进行播放
//                play(currentPosition);
//                currentPosition = 0;
//            }
//        }
//
//        @Override
//        public void surfaceChanged(SurfaceHolder holder, int format, int width,
//                                   int height) {
//            Log.i(TAG, "SurfaceHolder 大小被改变");
//        }
//
//    };
//
//    private OnSeekBarChangeListener change = new OnSeekBarChangeListener() {
//
//        @Override
//        public void onStopTrackingTouch(SeekBar seekBar) {
//            // 当进度条停止修改的时候触发
//            // 取得当前进度条的刻度
//            int progress = seekBar.getProgress();
//            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//                // 设置当前播放的位置
//                mediaPlayer.seekTo(progress);
//            }
//        }
//
//        @Override
//        public void onStartTrackingTouch(SeekBar seekBar) {
//
//        }
//
//        @Override
//        public void onProgressChanged(SeekBar seekBar, int progress,
//                                      boolean fromUser) {
//
//        }
//    };
//
//    private View.OnClickListener click = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//
//            switch (v.getId()) {
//                case R.id.btn_play:
//                    play(0);
//                    break;
//                case R.id.btn_pause:
//                    pause();
//                    break;
//                case R.id.btn_replay:
//                    replay();
//                    break;
//                case R.id.btn_stop:
//                    stop();
//                    break;
//                default:
//                    break;
//            }
//        }
//    };
//
//
//    /*
//     * 停止播放
//     */
//    protected void stop() {
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.stop();
//            mediaPlayer.release();
//            mediaPlayer = null;
//            btn_play.setEnabled(true);
//            isPlaying = false;
//        }
//    }
//
//    /**
//     * 开始播放
//     *
//     * @param msec 播放初始位置
//     */
//    protected void play(final int msec) {
//        // 获取视频文件地址
//        String path = et_path.getText().toString().trim();
//        File file = new File(path);
//        if (!file.exists()) {
//            Toast.makeText(this, "视频文件路径错误", 0).show();
//            return;
//        }
//        try {
//            mediaPlayer = new MediaPlayer();
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            // 设置播放的视频源
//            mediaPlayer.setDataSource(file.getAbsolutePath());
//            // 设置显示视频的SurfaceHolder
//            mediaPlayer.setDisplay(sv.getHolder());
//            Log.i(TAG, "开始装载");
//            mediaPlayer.prepareAsync();
//            mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
//
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    Log.i(TAG, "装载完成");
//                    mediaPlayer.start();
//                    // 按照初始位置播放
//                    mediaPlayer.seekTo(msec);
//                    // 设置进度条的最大进度为视频流的最大播放时长
//                    seekBar.setMax(mediaPlayer.getDuration());
//                    // 开始线程，更新进度条的刻度
//                    new Thread() {
//
//                        @Override
//                        public void run() {
//                            try {
//                                isPlaying = true;
//                                while (isPlaying) {
//                                    int current = mediaPlayer
//                                            .getCurrentPosition();
//                                    seekBar.setProgress(current);
//
//                                    sleep(500);
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }.start();
//
//                    btn_play.setEnabled(false);
//                }
//            });
//            mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
//
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    // 在播放完毕被回调
//                    btn_play.setEnabled(true);
//                }
//            });
//
//            mediaPlayer.setOnErrorListener(new OnErrorListener() {
//
//                @Override
//                public boolean onError(MediaPlayer mp, int what, int extra) {
//                    // 发生错误重新播放
//                    play(0);
//                    isPlaying = false;
//                    return false;
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 重新开始播放
//     */
//    protected void replay() {
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.seekTo(0);
//            Toast.makeText(this, "重新播放", 0).show();
//            btn_pause.setText("暂停");
//            return;
//        }
//        isPlaying = false;
//        play(0);
//
//
//    }
//
//    /**
//     * 暂停或继续
//     */
//    protected void pause() {
//        if (btn_pause.getText().toString().trim().equals("继续")) {
//            btn_pause.setText("暂停");
//            mediaPlayer.start();
//            Toast.makeText(this, "继续播放", 0).show();
//            return;
//        }
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.pause();
//            btn_pause.setText("继续");
//            Toast.makeText(this, "暂停播放", 0).show();
//        }
//
//    }

}