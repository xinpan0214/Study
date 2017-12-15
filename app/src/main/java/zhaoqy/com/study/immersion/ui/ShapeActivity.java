package zhaoqy.com.study.immersion.ui;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;

public class ShapeActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_shape;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar)
                /**
                 * 设置导航栏颜色
                 */
                .navigationBarColor(R.color.shape1)
                .init();
    }
}
