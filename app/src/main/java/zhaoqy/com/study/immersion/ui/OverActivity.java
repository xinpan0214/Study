package zhaoqy.com.study.immersion.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;

public class OverActivity extends BaseActivity implements View.OnClickListener{

    TextView textView;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_over;
    }

    @Override
    protected void initViews() {
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void setListener() {
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        String text = "请看这个页面的Toolbar和状态栏重叠啦，怎么解决呢？" +
                "先说说沉浸式的原理吧！" +
                "原理：其实沉浸式就是把整个布局拉伸到全屏显示，这样自然而然就会使得布局的最顶端和状态栏重合了，" +
                "好吧，以下给出五种解决方案，大家根据项目需求自己看着使用哦，不可结合使用。";
        textView.setText(text);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn: {
                Intent intent = new Intent(this, OverSolveActivity.class);
                startActivity(intent);
            }
        }
    }
}
