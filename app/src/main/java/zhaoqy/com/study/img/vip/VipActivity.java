package zhaoqy.com.study.img.vip;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;

import static zhaoqy.com.study.R.id.img_back;
import static zhaoqy.com.study.R.id.tv_title;

public class VipActivity extends BaseActivity implements View.OnClickListener{

    private IdentityImageView identityImageView;
    private int i = 10;
    private int angle = 30;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_vip;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(tv_title);
        title.setText("VIP标识圆形头像");

        identityImageView = ((IdentityImageView) findViewById(R.id.iiv));
    }

    @Override
    protected void setListener() {
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        findViewById(R.id.bt6).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {
        /**
         * 填充头像
         */
        identityImageView.getBigCircleImageView().setImageResource(R.mipmap.guojia);

        /**
         * 生成小图
         */
        identityImageView.getSmallCircleImageView().setImageResource(R.mipmap.v);

        /**
         * 改变图片比例大小，
         */
        identityImageView.setRadiusScale(0.1f);
    }

    @Override
    protected void updateUI() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case img_back: {
                finish();
                break;
            }
            case R.id.bt1: {
                /**
                 * 填充头像
                 */
                identityImageView.getBigCircleImageView().setImageResource(R.mipmap.guojia);
                break;
            }
            case R.id.bt2: {
                /**
                 * 生成小图
                 */
                identityImageView.getSmallCircleImageView().setImageResource(R.mipmap.v);
                break;
            }
            case R.id.bt3: {
                /**
                 * 改变图片比例大小，
                 */
                identityImageView.setRadiusScale(0.1f);
                break;
            }
            case R.id.bt4: {
                /**
                 * 移动小图
                 */
                identityImageView.setAngle(angle += 7);
                break;
            }
            case R.id.bt5: {
                /**
                 * 增加边框
                 */
                identityImageView.setBorderWidth(50);
                identityImageView.setBorderColor(R.color.colorTest);
                break;
            }
            case R.id.bt6: {
                /**
                 * 增加进度条，没按一次加10,以及改变的角度
                 */
                identityImageView.setIsprogress(true);
                identityImageView.setProgressColor(R.color.colorAccent);
                identityImageView.setProgress(i += 10);
                break;
            }
        }
    }
}
