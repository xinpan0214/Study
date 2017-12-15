package zhaoqy.com.study.img.gif;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cunoraz.gifview.library.GifView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;

public class GifActivity extends BaseActivity implements View.OnClickListener {

    private GifView gifView;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_gif;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("GIF图片加载");

        gifView = (GifView) findViewById(R.id.gif);
    }

    @Override
    protected void setListener() {
        findViewById(R.id.play).setOnClickListener(this);
        findViewById(R.id.pause).setOnClickListener(this);
        findViewById(R.id.load).setOnClickListener(this);
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
            case R.id.play: {
                if (gifView.isPaused()) {
                    gifView.play();
                }
                break;
            }
            case R.id.pause: {
                if (gifView.isPlaying()) {
                    gifView.pause();
                }
                break;
            }
            case R.id.load: {
                gifView.setGifResource(R.mipmap.gif2);
                break;
            }
        }
    }
}
