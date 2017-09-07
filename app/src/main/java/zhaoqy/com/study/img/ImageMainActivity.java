package zhaoqy.com.study.img;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;
import zhaoqy.com.study.custom.VerticalCard;
import zhaoqy.com.study.img.load.PicassoActivity;
import zhaoqy.com.study.img.shadow.ShadowActivity;
import zhaoqy.com.study.img.vip.VipActivity;


public class ImageMainActivity extends BaseActivity implements View.OnClickListener, VerticalCard.IVCListener {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_image_main;
    }

    @Override
    protected void initViews() {

        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("ImageView");
    }

    @Override
    protected void setListener() {
        ((VerticalCard) findViewById(R.id.image_item0)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.image_item1)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.image_item2)).setOnVCListener(this);
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
            case R.id.image_item0: {
                Intent intent = new Intent(this, VipActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.image_item1: {
                Intent intent = new Intent(this, ShadowActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.image_item2: {
                Intent intent = new Intent(this, PicassoActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
