package zhaoqy.com.study.start;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import zhaoqy.com.study.MainActivity;
import zhaoqy.com.study.R;

/*
 * 功能特性：文字竖排显示
 * 技术点：1. 控件android:ems属性
 * 注意：只有在android:layout_width="wrap_content"时，android:ems属性才会有效果，否则无效
 * 2. 隐藏标题栏（自定义theme）
 */
public class WelcomeActivity extends AppCompatActivity {

    RelativeLayout welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome = (RelativeLayout) findViewById(R.id.activity_welcome);
        startAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //jump();
    }

    /**
     * 延时跳转
     */
    private void jump() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                onJump();
            }
        }, 2500);
    }

    /**
     * 设置动画
     */
    private void startAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f,1.0f);
        scaleAnimation.setDuration(2500);
        alphaAnimation.setDuration(2500);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        welcome.startAnimation(animationSet);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                onJump();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    protected void onJump() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
