package zhaoqy.com.study.statusbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.utils.DpUtil;

public class StatusBarActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listview;
    private RelativeLayout rl_title;
    private ImageView img_back;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
        getSupportActionBar().hide();

        rl_title = (RelativeLayout) findViewById(R.id.rl_title);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        img_back.setVisibility(View.VISIBLE);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("状态栏");

        int statusBarHeight = StatusbarUI.getStatusBarHeight(this);
        if (Build.VERSION.SDK_INT >= 21) {
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    DpUtil.dip2px(this, 45) + statusBarHeight);
            rl_title.setLayoutParams(lp);
        } else {
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    DpUtil.dip2px(this, 45));
            rl_title.setLayoutParams(lp);
        }

        /**
         * 设置状态栏字体颜色、图标颜色为白色
         */
        StatusbarUI.setStatusBarUIMode(this, Color.parseColor("#00000000"), false);
        /**
         * 设置状态栏字体颜色、图标颜色为黑色
         */
        //StatusbarUI.setStatusBarUIMode(this, Color.parseColor("#ffffff"), true);

        listview = (ListView) findViewById(R.id.listview);
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.bannerrr);

        listview.addHeaderView(imageView);
        listview.setAdapter(new AAdapter(this));

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (firstVisibleItem == 0) {
                    View childAt = listview.getChildAt(0);

                    if (childAt != null) {
                        int halfHeight = childAt.getMeasuredHeight() / 2;
                        int top = childAt.getTop();
                        int i = top / halfHeight;
                        if (i == 0) {//变白 ，false
                            StatusbarUI.setStatusBarUIMode(StatusBarActivity.this,
                                    Color.parseColor("#00000000"), false);
                            /**
                             * 文字白色
                             */
                            tv_title.setTextColor(Color.parseColor("#ffffff"));
                            //#3F51B5
                            rl_title.setBackgroundColor(Color.parseColor("#33000000"));
                        } else {//变暗，true
                            //#3F51B5
                            StatusbarUI.setStatusBarUIMode(StatusBarActivity.this,
                                    Color.parseColor("#ffffff"), true);
                            /**
                             * 文字黑色
                             */
                            tv_title.setTextColor(Color.parseColor("#000000"));
                            //#3F51B5
                            rl_title.setBackgroundColor(Color.parseColor("#ffffff"));
                        }
                    }
                }
            }
        });
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

    static class AAdapter extends BaseAdapter {

        private Context context;

        public AAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            TextView textView = new TextView(context);
            textView.setPadding(20, 50, 0, 50);
            textView.setText("aa:::" + position);

            return textView;
        }
    }
}
