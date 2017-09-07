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
import zhaoqy.com.study.pie.PieMainActivity;
import zhaoqy.com.study.popup.PopupWindowActivity;
import zhaoqy.com.study.residelayout.ResideLayoutActivity;
import zhaoqy.com.study.statusbar.StatusBarActivity;
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
        ((VerticalCard) findViewById(R.id.main_custom)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_statusbar)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.main_pie)).setOnVCListener(this);
    }

    @Override
    public void onVcClick(View view) {
        switch (view.getId()) {
            case R.id.main_pop: {
                Intent intent = new Intent(this, PopupWindowActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_image: {
                Intent intent = new Intent(this, ImageMainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_text: {
                Intent intent = new Intent(this, TextViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_dialog: {
                Intent intent = new Intent(this, DialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_reside: {
                Intent intent = new Intent(this, ResideLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_custom: {
                Intent intent = new Intent(this, CustomActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_statusbar: {
                Intent intent = new Intent(this, StatusBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_pie: {
                Intent intent = new Intent(this, PieMainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
