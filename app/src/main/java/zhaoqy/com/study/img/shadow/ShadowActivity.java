package zhaoqy.com.study.img.shadow;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;

public class ShadowActivity extends BaseActivity implements View.OnClickListener {

    private TextView view1, view2, view3, view4, view5, view6, view7, view8;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_shadow;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("阴影效果");

        view1 = (TextView) findViewById(R.id.view1);
        view2 = (TextView) findViewById(R.id.view2);
        view3 = (TextView) findViewById(R.id.view3);
        view4 = (TextView) findViewById(R.id.view4);
        view5 = (TextView) findViewById(R.id.view5);
        view6 = (TextView) findViewById(R.id.view6);
        view7 = (TextView) findViewById(R.id.view7);
        view8 = (TextView) findViewById(R.id.view8);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        /**
         * 顶部阴影
         */
        ShadowDrawable.Builder.on(view1)
                .bgColor(getResources().getColor(R.color.white))
                .shadowColor(Color.parseColor("#000000"))
                .shadowRange(dp2Px(10))
                .offsetTop(dp2Px(10))
                .create();

        /**
         * 左侧阴影
         */
        ShadowDrawable.Builder.on(view2)
                .bgColor(getResources().getColor(R.color.white))
                .shadowColor(Color.parseColor("#000000"))
                .shadowRange(dp2Px(10))
                .offsetLeft(dp2Px(10))
                .create();

        /**
         * 右侧阴影
         */
        ShadowDrawable.Builder.on(view3)
                .bgColor(getResources().getColor(R.color.white))
                .shadowColor(Color.parseColor("#000000"))
                .shadowRange(dp2Px(10))
                .offsetRight(dp2Px(10))
                .create();

        /**
         * 底部阴影
         */
        ShadowDrawable.Builder.on(view4)
                .bgColor(getResources().getColor(R.color.white))
                .shadowColor(Color.parseColor("#000000"))
                .shadowRange(dp2Px(10))
                .offsetBottom(dp2Px(10))
                .create();

        /**
         * 四边阴影
         */
        ShadowDrawable.Builder.on(view5)
                .bgColor(getResources().getColor(R.color.white))
                .shadowColor(Color.parseColor("#000000"))
                .shadowRange(dp2Px(10))
                .offsetTop(dp2Px(10))
                .offsetBottom(dp2Px(10))
                .offsetLeft(dp2Px(10))
                .offsetRight(dp2Px(10))
                .create();

        /**
         * 四边阴影 + 圆角
         */
        ShadowDrawable.Builder.on(view6)
                .bgColor(getResources().getColor(R.color.white))
                .radius(dp2Px(5))
                .shadowColor(Color.parseColor("#000000"))
                .shadowRange(dp2Px(10))
                .offsetTop(dp2Px(10))
                .offsetBottom(dp2Px(10))
                .offsetLeft(dp2Px(10))
                .offsetRight(dp2Px(10))
                .create();

        /**
         * 四边阴影 + 自定义阴影颜色
         */
        ShadowDrawable.Builder.on(view7)
                .bgColor(getResources().getColor(R.color.white))
                .shadowColor(getResources().getColor(R.color.colorAccent))
                .shadowRange(dp2Px(10))
                .offsetTop(dp2Px(10))
                .offsetBottom(dp2Px(10))
                .offsetLeft(dp2Px(10))
                .offsetRight(dp2Px(10))
                .create();

        /**
         * 四边阴影 + 自定义背景颜色
         */
        ShadowDrawable.Builder.on(view8)
                .bgColor(getResources().getColor(R.color.colorAccent))
                .shadowColor(Color.parseColor("#000000"))
                .shadowRange(dp2Px(10))
                .offsetTop(dp2Px(10))
                .offsetBottom(dp2Px(10))
                .offsetLeft(dp2Px(10))
                .offsetRight(dp2Px(10))
                .create();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void updateUI() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back: {
                finish();
                break;
            }
        }
    }

    public int dp2Px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
