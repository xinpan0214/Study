package zhaoqy.com.study.customview.timeline;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;

public class TimeLineActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_time_line;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("自定义时间轴");
    }

    @Override
    protected void setListener() {

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
}
