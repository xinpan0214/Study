package zhaoqy.com.study.immersion;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import jp.wasabeef.blurry.Blurry;
import zhaoqy.com.study.R;
import zhaoqy.com.study.custom.VerticalCard;
import zhaoqy.com.study.immersion.base.BaseActivity;
import zhaoqy.com.study.immersion.library.BarHide;
import zhaoqy.com.study.immersion.library.BarParams;
import zhaoqy.com.study.immersion.library.ImmersionBar;
import zhaoqy.com.study.immersion.ui.ActionBarActivity;
import zhaoqy.com.study.immersion.ui.BlogActivity;
import zhaoqy.com.study.immersion.ui.ColorStatusBarActivity;
import zhaoqy.com.study.immersion.ui.CoordinatorActivity;
import zhaoqy.com.study.immersion.ui.FullPicActivity;
import zhaoqy.com.study.immersion.ui.InmersionDialogActivity;
import zhaoqy.com.study.immersion.ui.OverActivity;
import zhaoqy.com.study.immersion.ui.PicStatusBarActivity;
import zhaoqy.com.study.immersion.ui.ShapeActivity;
import zhaoqy.com.study.immersion.ui.WhiteStatusBarActivity;

public class ImmersionActivity extends BaseActivity implements View.OnClickListener, VerticalCard.IVCListener {

    DrawerLayout drawer;
    Toolbar toolbar;
    ImageView iv_bg;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_immersion;
    }

    @Override
    protected void initViews() {
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
    }

    @Override
    protected void setListener() {
        /**
         * toolbar返回按钮监听
         */
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ((VerticalCard) findViewById(R.id.immersion_item0)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_item1)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_item2)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_item3)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_item4)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_item5)).setOnVCListener(this);

        ((VerticalCard) findViewById(R.id.immersion_itema)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_itemb)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_itemc)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_itemd)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_iteme)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_itemf)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_itemg)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_itemi)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_itemj)).setOnVCListener(this);

        ((VerticalCard) findViewById(R.id.immersion_item_actionbar)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_item_dialog)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.immersion_item_fragment)).setOnVCListener(this);

        findViewById(R.id.ll_github).setOnClickListener(this);
        findViewById(R.id.ll_jianshu).setOnClickListener(this);
        findViewById(R.id.ll_bokeyuan).setOnClickListener(this);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(toolbar).init();
    }

    @Override
    protected void initData() {

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        /**
         * 图片边模糊效果
         */
        Blurry.with(this)
                .from(BitmapFactory.decodeResource(getResources(), R.mipmap.head_bg))
                .into(iv_bg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_github: {
                /**
                 * github
                 */
                Intent intent = new Intent(this, BlogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("blog", "github");
                intent.putExtra("bundle", bundle);
                startActivity(intent);
                break;
            }
            case R.id.ll_jianshu: {
                /**
                 * 简书
                 */
                Intent intent2 = new Intent(this, BlogActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("blog", "jianshu");
                intent2.putExtra("bundle", bundle2);
                startActivity(intent2);
                break;
            }
            case R.id.ll_bokeyuan: {
                /**
                 * 博客园
                 */
                Intent intent3 = new Intent(this, BlogActivity.class);
                Bundle bundle3 = new Bundle();
                bundle3.putString("blog", "bokeyuan");
                intent3.putExtra("bundle", bundle3);
                startActivity(intent3);
                break;
            }
        }
    }

    @Override
    public void onVcClick(View view) {
        switch (view.getId()) {
            case R.id.immersion_item0: {
                /**
                 * 侧边栏
                 */
                drawer.openDrawer(Gravity.LEFT);
                break;
            }
            case R.id.immersion_item1: {
                /**
                 * CoordinatorLayout
                 */
                Intent intent = new Intent(this, CoordinatorActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_item_actionbar: {
                /**
                 * ActionBar
                 */
                Intent intent = new Intent(this, ActionBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_item_dialog: {
                /**
                 * Dialog
                 */
                Intent intent = new Intent(this, InmersionDialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_item_fragment: {
                /**
                 * Fragment
                 */
                //Intent intent = new Intent(this, ActionBarActivity.class);
                //startActivity(intent);
                break;
            }
            case R.id.immersion_item2: {
                /**
                 * 全屏图片
                 */
                Intent intent = new Intent(this, FullPicActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_item3: {
                /**
                 * 标题栏背景色渐变
                 */
                Intent intent = new Intent(this, ShapeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_item4: {
                /**
                 * 图片状态栏
                 */
                Intent intent = new Intent(this, PicStatusBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_item5: {
                /**
                 * 彩色状态栏
                 */
                Intent intent = new Intent(this, ColorStatusBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_itema: {
                /**
                 * 隐藏状态栏
                 */
                mImmersionBar.hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
                break;
            }
            case R.id.immersion_itemb: {
                /**
                 * 隐藏导航栏
                 */
                if (ImmersionBar.hasNavigationBar(this)) {
                    ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR).init();
                }
                else {
                    Toast.makeText(this, "当前设备没有导航栏或者低于4.4系统", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.immersion_itemc: {
                /**
                 * 隐藏全部
                 */
                mImmersionBar.hideBar(BarHide.FLAG_HIDE_BAR).init();
                break;
            }
            case R.id.immersion_itemd: {
                /**
                 * 恢复显示
                 */
                mImmersionBar.hideBar(BarHide.FLAG_SHOW_BAR).init();
                break;
            }
            case R.id.immersion_iteme: {
                /**
                 * 全屏显示切换
                 */
                if (ImmersionBar.hasNavigationBar(this)) {
                    BarParams barParams = mImmersionBar.getBarParams();
                    if (barParams.fullScreen) {
                        mImmersionBar.fullScreen(false).navigationBarColor(R.color.black).init();
                    } else {
                        mImmersionBar.fullScreen(true).transparentNavigationBar().init();
                    }
                } else {
                    Toast.makeText(this, "当前设备没有导航栏或者低于4.4系统", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.immersion_itemf: {
                /**
                 * 状态栏字体颜色为深色
                 */
                if (ImmersionBar.isSupportStatusBarDarkFont()) {
                    mImmersionBar.statusBarDarkFont(true).init();
                }
                else {
                    Toast.makeText(this, "当前设备不支持状态栏字体变色", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.immersion_itemg: {
                /**
                 * 状态栏字体颜色为亮色
                 */
                mImmersionBar.statusBarDarkFont(false).init();
                break;
            }
            case R.id.immersion_itemi: {
                /**
                 * 解决白色状态栏问题
                 */
                Intent intent = new Intent(this, WhiteStatusBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.immersion_itemj: {
                /**
                 * 解决顶部与状态栏重叠问题
                 */
                Intent intent = new Intent(this, OverActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
