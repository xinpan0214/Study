package zhaoqy.com.study.textview;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;
import zhaoqy.com.study.custom.VerticalCard;
import zhaoqy.com.study.textview.reddot.RedDotActivity;

public class TextViewActivity extends BaseActivity implements View.OnClickListener, VerticalCard.IVCListener {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_text_view;
    }

    @Override
    protected void initViews() {

        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("TextView");
    }

    @Override
    protected void setListener() {
        ((VerticalCard) findViewById(R.id.text_item0)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.text_item1)).setOnVCListener(this);
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
            case R.id.text_item0: {
                Intent intent = new Intent(this, RedDotActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.text_item1: {
                //Intent intent = new Intent(this, ShadowActivity.class);
                //startActivity(intent);
                break;
            }
        }
    }
}
