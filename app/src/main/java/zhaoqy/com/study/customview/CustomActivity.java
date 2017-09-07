package zhaoqy.com.study.customview;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;
import zhaoqy.com.study.custom.VerticalCard;
import zhaoqy.com.study.customview.countdown.CountdownActivity;
import zhaoqy.com.study.customview.speedcontrol.SpeedControlActivity;
import zhaoqy.com.study.customview.timeline.TimeLineActivity;

public class CustomActivity extends BaseActivity implements View.OnClickListener, VerticalCard.IVCListener{

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_custom;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("自定义View");
    }

    @Override
    protected void setListener() {
        ((VerticalCard) findViewById(R.id.custom_item0)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.custom_item1)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.custom_item2)).setOnVCListener(this);
    }

    @Override
    protected void initData() {

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

    @Override
    public void onVcClick(View view) {
        switch (view.getId()) {
            case R.id.custom_item0: {
                Intent intent = new Intent(this, TimeLineActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.custom_item1: {
                Intent intent = new Intent(this, CountdownActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.custom_item2: {
                Intent intent = new Intent(this, SpeedControlActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
