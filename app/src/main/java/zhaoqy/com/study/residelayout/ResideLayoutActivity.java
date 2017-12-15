package zhaoqy.com.study.residelayout;

import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseCompatActivity;
import zhaoqy.com.study.residelayout.utils.CropCircleTransform;
import zhaoqy.com.study.residelayout.widget.ColorView;
import zhaoqy.com.study.residelayout.widget.ResideLayout;
import zhaoqy.com.study.utils.SystemBarUtil;

public class ResideLayoutActivity extends BaseCompatActivity {

    @Bind(R.id.avatar) ImageView mAvatar;
    @Bind(R.id.desc) TextView mDesc;
    @Bind(R.id.all) TextView mAll;
    @Bind(R.id.fuli) TextView mFuli;
    @Bind(R.id.android) TextView mAndroid;
    @Bind(R.id.ios) TextView mIos;
    @Bind(R.id.video) TextView mVideo;
    @Bind(R.id.front) TextView mFront;
    @Bind(R.id.resource) TextView mResource;
    @Bind(R.id.app) TextView mApp;
    @Bind(R.id.more) TextView mMore;
    @Bind(R.id.scrollView) ScrollView mScrollView;
    @Bind(R.id.about) TextView mAbout;
    @Bind(R.id.theme) TextView mTheme;
    @Bind(R.id.menu) RelativeLayout mMenu;
    @Bind(R.id.status_bar) ColorView mStatusBar;
    @Bind(R.id.icon) ImageView mIcon;
    @Bind(R.id.title) TextView mTitle;
    @Bind(R.id.container) FrameLayout mContainer;
    @Bind(R.id.resideLayout) ResideLayout mResideLayout;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_reside_layout;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mStatusBar.setVisibility(View.VISIBLE);
            mStatusBar.getLayoutParams().height = SystemBarUtil.getStatusHeight(this);
            mStatusBar.setLayoutParams(mStatusBar.getLayoutParams());
        } else {
            mStatusBar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        mResideLayout.openPane();
    }

    @Override
    protected void loadData() {
        Picasso.with(this)
                .load(R.mipmap.head)
                // .transform(new RoundTransform(90))
                .transform(new CropCircleTransform())
                .into(mAvatar);
    }

    @Override
    protected void updateUI() {

    }

    @OnClick({R.id.avatar, R.id.all, R.id.fuli, R.id.android,
            R.id.ios, R.id.video, R.id.front,
            R.id.resource, R.id.about,
            R.id.app, R.id.theme, R.id.icon, R.id.more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.avatar:
                break;

            case R.id.icon:
                mResideLayout.openPane();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mResideLayout.isOpen()) {
            mResideLayout.closePane();
        } else {
            super.onBackPressed();
        }
    }

}
