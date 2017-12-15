package zhaoqy.com.study.img.glide;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;

public class GlideActivity extends BaseActivity implements View.OnClickListener{

    ImageView imageview;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_glide;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("GIF图片加载");

        imageview = (ImageView) findViewById(R.id.img);
    }

    @Override
    protected void setListener() {
        findViewById(R.id.net).setOnClickListener(this);
        findViewById(R.id.local).setOnClickListener(this);
        findViewById(R.id.asserts).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        /**
         * 加载网络图片
         */
        String url = "http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png";
        Glide.with(this)
                .load(url)
                .into(imageview);
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
            case R.id.net: {
                /**
                 * 加载网络图片
                 */
                //String url = "http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png";
                Glide.with(this)
                        .load("https://ws1.sinaimg.cn/large/610dc034ly1fir1jbpod5j20ip0newh3.jpg")
                        //加载过程中的图片显示
                        .placeholder(R.mipmap.icon_avatar)
                        //加载失败中的图片显示
                        .error(R.mipmap.icon_avatar)
                        .into(imageview);
                break;
            }
            case R.id.local: {
                /**
                 * 加载资源图片
                 */
                Glide.with(this)
                        .load(R.mipmap.head)
                        .into(imageview);
                break;
            }
            case R.id.asserts: {
                /**
                 * 加载Assets资源
                 */
                Glide.with(this)
                        .load("file:///android_asset/images/favorite.png")
                        .into(imageview);
                break;
            }
        }
    }
}
