package zhaoqy.com.study.immersion.ui;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;
import zhaoqy.com.study.immersion.library.ImmersionBar;

public class PicStatusBarActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    Toolbar toolbar;
    SeekBar seekBar;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_pic_status;
    }

    @Override
    protected void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
    }

    @Override
    protected void setListener() {
        seekBar.setOnSeekBarChangeListener(this);
        findViewById(R.id.btn_status_color).setOnClickListener(this);
        findViewById(R.id.btn_navigation_color).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarView(R.id.top_view)
                .navigationBarColor(R.color.colorPrimary)
                .fullScreen(true)
                .addTag("PicAndColor")  //给上面参数打标记，以后可以通过标记恢复
                .init();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float alpha = (float) progress / 100;
        mImmersionBar.statusBarColorTransform(R.color.orange)
                .navigationBarColorTransform(R.color.translucent)
                .addViewSupportTransformColor(toolbar)
                .barAlpha(alpha)
                .init();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_status_color:
                mImmersionBar.statusBarColor(R.color.colorAccent).init();
                break;
            case R.id.btn_navigation_color:
                if (ImmersionBar.hasNavigationBar(this))
                    mImmersionBar.navigationBarColor(R.color.colorAccent).init();
                else
                    Toast.makeText(this, "当前设备没有导航栏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_color:
                mImmersionBar.getTag("PicAndColor").init(); //根据tag标记来恢复
                break;
        }
    }
}
