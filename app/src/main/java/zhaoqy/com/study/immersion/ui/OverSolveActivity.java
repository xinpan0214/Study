package zhaoqy.com.study.immersion.ui;

import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;

public class OverSolveActivity extends BaseActivity {

    TextView textView;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_over_solve;
    }

    @Override
    protected void initViews() {
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        textView.setText("使用系统的fitsSystemWindows属性,在布局的根节点，" +
                "指定fitsSystemWindows为true，然后在代码中使用ImmersionBar指定状态栏的颜色，详情参看此页面的实现");
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.barColor(R.color.colorPrimary)
                .init();
    }
}
