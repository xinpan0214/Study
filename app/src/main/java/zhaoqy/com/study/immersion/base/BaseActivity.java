package zhaoqy.com.study.immersion.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zhaoqy.com.study.immersion.library.ImmersionBar;

public abstract class BaseActivity extends AppCompatActivity {

    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());

        //view与数据绑定
        initViews();

        //设置监听
        setListener();

        //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        //初始化数据
        initData();
    }

    protected abstract int getLayoutResID();

    protected abstract void initViews();

    protected abstract void setListener();

    protected abstract void initData();

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            //在BaseActivity里销毁
            mImmersionBar.destroy();
        }
    }
}
