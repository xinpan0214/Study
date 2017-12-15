package zhaoqy.com.study.immersion.ui;

import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;

public class ColorStatusBarActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener {

    Toolbar mToolbar;
    TextView textView;
    SeekBar seekBar;
    Button btn1;
    Button btn2;
    Button btn3;
    LinearLayout linearLayout;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_color_status;
    }

    @Override
    protected void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView) findViewById(R.id.text_view);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        linearLayout = (LinearLayout) findViewById(R.id.line1);
    }

    @Override
    protected void setListener() {
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarView(R.id.top_view)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.btn8)
                .init();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float alpha = (float) progress / 100;
        textView.setText("透明度:" + alpha + "f");
        mImmersionBar.barAlpha(alpha)
                .statusBarColorTransform(R.color.btn14)
                .navigationBarColorTransform(R.color.btn3)
                .addViewSupportTransformColor(mToolbar)
                .addViewSupportTransformColor(btn1, R.color.btn1, R.color.btn4)
                .addViewSupportTransformColor(btn2, R.color.btn3, R.color.btn12)
                .addViewSupportTransformColor(btn3, R.color.btn5, R.color.btn10)
                .addViewSupportTransformColor(linearLayout, R.color.darker_gray, R.color.btn5)
                .init();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
