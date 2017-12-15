package zhaoqy.com.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import zhaoqy.com.study.custom.VerticalCard;
import zhaoqy.com.study.customview.CustomActivity;
import zhaoqy.com.study.dialog.DialogActivity;
import zhaoqy.com.study.img.ImageMainActivity;
import zhaoqy.com.study.immersion.ImmersionActivity;
import zhaoqy.com.study.pie.PieMainActivity;
import zhaoqy.com.study.popup.PopupWindowActivity;
import zhaoqy.com.study.residelayout.ResideLayoutActivity;
import zhaoqy.com.study.statusbar.StatusBarActivity;
import zhaoqy.com.study.swiperefresh.SwipeMainActivity;
import zhaoqy.com.study.textview.TextViewActivity;
import zhaoqy.com.study.utils.SystemBarUtil;

public class MainActivity extends AppCompatActivity implements VerticalCard.IVCListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 隐藏标题栏
         */
        //getSupportActionBar().hide();
        SystemBarUtil.setSystemBar(this);

        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(getResources().getString(R.string.app_name));
        setListener();
    }

    private void setListener() {
        ((VerticalCard) findViewById(R.id.main_pop)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_image)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_text)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_dialog)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_reside)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_swiperefresh)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_custom)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_statusbar)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_immersion)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_pie)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_permissions)).setOnVCListener(this);
    }

    @Override
    public void onVcClick(View view) {
        switch (view.getId()) {
            case R.id.main_pop: {
                /**
                 * PopupWindow
                 */
                Intent intent = new Intent(this, PopupWindowActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_image: {
                /**
                 * ImageView相关
                 */
                Intent intent = new Intent(this, ImageMainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_text: {
                /**
                 * TextView相关
                 */
                Intent intent = new Intent(this, TextViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_dialog: {
                /**
                 * Dialog相关
                 */
                Intent intent = new Intent(this, DialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_reside: {
                /**
                 * ResideLayout的使用
                 */
                Intent intent = new Intent(this, ResideLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_swiperefresh: {
                /**
                 * SwipeRefreshLayout的使用
                 */
                Intent intent = new Intent(this, SwipeMainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_custom: {
                /**
                 * 自定义
                 */
                Intent intent = new Intent(this, CustomActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_statusbar: {
                /**
                 * 状态栏
                 */
                Intent intent = new Intent(this, StatusBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_immersion: {
                /**
                 *  沉浸式效果
                 */
                Intent intent = new Intent(this, ImmersionActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_pie: {
                /**
                 * 饼状图
                 */
                Intent intent = new Intent(this, PieMainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_permissions: {
                /**
                 * 权限管理
                 */
                break;
            }
        }
    }
}
