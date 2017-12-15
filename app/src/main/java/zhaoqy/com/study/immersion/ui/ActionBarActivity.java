package zhaoqy.com.study.immersion.ui;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;

public class ActionBarActivity extends BaseActivity implements View.OnClickListener {

    Button btn;
    TextView text;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_action_bar;
    }

    @Override
    protected void initViews() {
        btn = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void setListener() {
        btn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("结合actionBar使用");
        }
        text.setText("上面图片被actionBar遮挡住了,我想使布局从actionBar下面开始绘制，怎么办？");
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.keyboardEnable(true).init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn: {
                mImmersionBar.statusBarColor(R.color.colorPrimary)
                        .supportActionBar(true)
                        .init();
                text.setText("哈哈哈！解决啦！就问你惊不惊喜，意不意外，刺不刺激！！！" +
                        "重点是这个方法supportActionBar(true)，实现原理，当为true时，布局距离顶部的" +
                        "padding值为状态栏的高度+ActionBar的高度");
                btn.setText("解决啦");
            }
        }
    }
}
