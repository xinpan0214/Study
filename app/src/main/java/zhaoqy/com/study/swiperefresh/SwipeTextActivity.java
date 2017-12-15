package zhaoqy.com.study.swiperefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhaoqy.com.study.R;

import static zhaoqy.com.study.R.id.SwipeRefreshLayout;

public class SwipeTextActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(SwipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.textview)
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_text);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        setSupportActionBar(toolbar);
        toolbar.setTitle("SwipeRefresh + 非滑动View");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        //禁止刷新
        //swipeRefreshLayout.setEnabled(false);
        //允许刷新
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                fresh();
            }
        });
    }

    @OnClick(R.id.btn)
    public void fresh() {
        swipeRefreshLayout.setRefreshing(true);
        textview.setText("正在刷新...");
        new Handler().postDelayed(new Runnable() {

            @Override public void run() {
                textview.setText("刷新成功");
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 4000);
    }
}
