package zhaoqy.com.study.start;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import zhaoqy.com.study.MainActivity;
import zhaoqy.com.study.R;

/*
 * 功能特性：文字竖排显示
 * 技术点：1. 控件android:ems属性
 * 注意：只有在android:layout_width="wrap_content"时，android:ems属性才会有效果，否则无效
 * 2. 隐藏标题栏（自定义theme）
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onResume() {
        super.onResume();
        jump();
    }

    private void jump() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                onJump();
            }
        }, 2500);
    }

    protected void onJump() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
