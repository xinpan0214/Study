package zhaoqy.com.study.customview.speedcontrol;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import zhaoqy.com.study.R;
import zhaoqy.com.study.base.BaseActivity;

public class SpeedControlActivity extends BaseActivity implements View.OnClickListener {

    private SpeedControlView speedControlView;
    private Button speedUp; //油门
    private Button speedDown;//刹车
    private Button shutDown; //手刹

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_speed_control;
    }

    @Override
    protected void initViews() {
        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("汽车速度控制仪表盘");

        speedControlView = (SpeedControlView) findViewById(R.id.speed_control);

        //实体化
        speedUp = (Button) findViewById(R.id.speed_up);
        speedDown = (Button) findViewById(R.id.speed_down);
        shutDown = (Button) findViewById(R.id.shut_down);
    }

    @Override
    protected void setListener() {
        //speedUp.setOnClickListener(this);
        //speedDown.setOnClickListener(this);
        //shutDown.setOnClickListener(this);

        //设置监听
        speedUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //按下的时候加速
                        speedControlView.setType(1);
                        break;
                    case MotionEvent.ACTION_UP:
                        //松开做自然减速
                        speedControlView.setType(0);
                        break;
                }
                return true;
            }
        });

        speedDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //按下的时候减速
                        speedControlView.setType(2);
                        break;
                    case MotionEvent.ACTION_UP:
                        //松开做自然减速
                        speedControlView.setType(0);
                        break;
                }
                return true;
            }
        });

        shutDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //按下的时候拉手刹
                        speedControlView.setType(3);
                        break;
                    case MotionEvent.ACTION_UP:
                        //松开做自然减速
                        speedControlView.setType(0);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (speedControlView != null) {
            speedControlView.setSpeed(0);
            speedControlView.setStart(true);
        }
        new Thread(speedControlView).start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (speedControlView != null) {
            speedControlView.setSpeed(0);
            speedControlView.setStart(false);
        }
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
            case R.id.speed_up: {
                speedControlView.setType(1);
                break;
            }
            case R.id.speed_down: {
                speedControlView.setType(2);
                break;
            }
            case R.id.shut_down: {
                speedControlView.setType(3);
                break;
            }
        }
    }
}
