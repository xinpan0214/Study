package zhaoqy.com.study.base;

import android.app.Activity;
import android.os.Bundle;

import zhaoqy.com.study.utils.SystemBarUtil;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        /**
         * 设置状态栏颜色
         */
        SystemBarUtil.setSystemBar(this);
        initViews();
        setListener();
        initData();
        loadData();
        updateUI();
    }

    protected abstract int getLayoutResID();

    protected abstract void initViews();

    protected abstract void setListener();

    protected abstract void initData();

    protected abstract void loadData();

    protected abstract void updateUI();
}
