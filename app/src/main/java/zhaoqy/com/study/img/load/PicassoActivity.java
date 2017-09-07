package zhaoqy.com.study.img.load;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;
import zhaoqy.com.study.residelayout.utils.CropCircleTransform;

import static zhaoqy.com.study.R.id.img_back;
import static zhaoqy.com.study.R.id.tv_title;

public class PicassoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_picasso;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(tv_title);
        title.setText("Picasso加载");

        imageView = ((ImageView) findViewById(R.id.iiv));
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
                Picasso.with(this)
                        .load(R.mipmap.guojia)
                        .into(imageView);
                break;
            }
            case R.id.bt2: {
                Picasso.with(this)
                        .load(R.mipmap.guojia)
                        .transform(new CropCircleTransform())
                        .into(imageView);
                break;
            }
            case R.id.bt3: {
                Picasso.with(this)
                        .load("https://ws1.sinaimg.cn/large/610dc034ly1fir1jbpod5j20ip0newh3.jpg")
                        //加载过程中的图片显示
                        .placeholder(R.mipmap.icon_avatar)
                        //加载失败中的图片显示
                        .error(R.mipmap.icon_avatar)
                        .into(imageView);
                break;
            }
            case R.id.bt4: {
                /**
                 * 加载Assets资源
                 */
                Picasso.with(this)
                        .load("file:///android_asset/images/favorite.png")
                        .into(imageView);
                break;
            }
            case R.id.bt5: {

                break;
            }
            case R.id.bt6: {

                Picasso.with(this)
                        .load(R.mipmap.guojia)
                        //裁剪图片尺寸
                        .resize(100, 100)
                        //设置图片圆角
                        .centerCrop()
                        .into(imageView);

                break;
            }
        }
    }
}
