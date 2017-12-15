package zhaoqy.com.study.immersion.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;
import zhaoqy.com.study.immersion.library.ImmersionBar;

public class WhiteStatusBarActivity extends BaseActivity implements View.OnClickListener {

    Button btn;
    TextView text;
    View view;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_white_status_bar;
    }

    @Override
    protected void initViews() {
        btn = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.text);
        view = findViewById(R.id.top_view);
    }

    @Override
    protected void setListener() {
        btn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarView(view).init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn: {
                ImmersionBar.with(WhiteStatusBarActivity.this)
                        .statusBarDarkFont(true, 0.2f)
                        .init();
                text.setText("A：重点在于statusBarDarkFont(true,0.2f)这个方法，" +
                        "原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，" +
                        "如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度。");
                btn.setText("解决啦");
            }
        }
    }
}
