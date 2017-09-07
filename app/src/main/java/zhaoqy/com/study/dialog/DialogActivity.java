package zhaoqy.com.study.dialog;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;
import zhaoqy.com.study.custom.VerticalCard;
import zhaoqy.com.study.dialog.nice.NiceDialogActivity;

public class DialogActivity extends BaseActivity implements View.OnClickListener, VerticalCard.IVCListener {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_dialog;
    }

    @Override
    protected void initViews() {

        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("Dialog");
    }

    @Override
    protected void setListener() {
        ((VerticalCard) findViewById(R.id.dialog_item0)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.dialog_item1)).setOnVCListener(this);
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
            case R.id.dialog_item0: {
                Intent intent = new Intent(this, NiceDialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.dialog_item1: {
                //Intent intent = new Intent(this, ShadowActivity.class);
                //startActivity(intent);
                break;
            }
        }
    }
}
