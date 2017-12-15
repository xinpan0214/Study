package zhaoqy.com.study.immersion.ui;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import zhaoqy.com.study.R;
import zhaoqy.com.study.custom.VerticalCard;
import zhaoqy.com.study.immersion.base.BaseActivity;
import zhaoqy.com.study.immersion.library.ImmersionBar;

public class InmersionDialogActivity extends BaseActivity implements VerticalCard.IVCListener, DialogInterface.OnDismissListener{

    private ImmersionBar mImmersionBarDialog = null;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_inmersion_dialog;
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void setListener() {
        ((VerticalCard) findViewById(R.id.btn_full)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.btn_top)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.btn_bottom)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.btn_left)).setOnVCListener(this);
        ((VerticalCard) findViewById(R.id.btn_right)).setOnVCListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar)
                .keyboardEnable(true)
                .init();
    }

    @Override
    public void onVcClick(View view) {
        mImmersionBar.keyboardEnable(false).init();  //取消activity的软键盘监听
        //弹出Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyDialog);
        AlertDialog dialog = builder.create();
        dialog.setOnDismissListener(this);
        dialog.show();
        View dialogView = LayoutInflater.from(this).inflate(R.layout.layout_immersion_dialog, null);
        Toolbar toolbar = (Toolbar) dialogView.findViewById(R.id.toolbar);
        dialog.setContentView(dialogView);
        Window window = dialog.getWindow();
        //解决无法弹出输入法的问题
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        //计算屏幕宽高
        int width;
        int height;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getRealMetrics(dm);
            width = dm.widthPixels;
            height = dm.heightPixels;
        } else {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            width = metrics.widthPixels;
            height = metrics.heightPixels;
        }

        switch (view.getId()) {
            case R.id.btn_full: {
                window.setGravity(Gravity.TOP);
                window.setWindowAnimations(R.style.RightDialog);
                window.setLayout(width, height);
                mImmersionBarDialog = ImmersionBar.with(this, dialog, "Full");
                mImmersionBarDialog.titleBar(toolbar)
                        .navigationBarColor(R.color.btn3)
                        .keyboardEnable(true)
                        .init();
                break;
            }
            case R.id.btn_top: {
                window.setGravity(Gravity.TOP);
                window.setWindowAnimations(R.style.TopDialog);
                window.setLayout(width, height / 2);
                mImmersionBarDialog = ImmersionBar.with(this, dialog, "Top");
                mImmersionBarDialog.titleBar(toolbar).navigationBarWithKitkatEnable(false).init();
                break;
            }
            case R.id.btn_bottom: {
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.BottomDialog);
                window.setLayout(width, height / 2);
                mImmersionBarDialog = ImmersionBar.with(this, dialog, "Bottom");
                mImmersionBarDialog.navigationBarColor(R.color.btn1).init();
                break;
            }
            case R.id.btn_left: {
                window.setGravity(Gravity.TOP | Gravity.START);
                window.setWindowAnimations(R.style.LeftDialog);
                window.setLayout(width * 2 / 3, height);
                mImmersionBarDialog = ImmersionBar.with(this, dialog, "Left");
                mImmersionBarDialog.titleBar(toolbar)
                        .navigationBarColor(R.color.btn11)
                        .keyboardEnable(true).init();
                break;
            }
            case R.id.btn_right: {
                window.setGravity(Gravity.TOP | Gravity.END);
                window.setWindowAnimations(R.style.RightDialog);
                window.setLayout(width * 2 / 3, height);
                mImmersionBarDialog = ImmersionBar.with(this, dialog, "Right");
                mImmersionBarDialog.titleBar(toolbar)
                        .navigationBarColor(R.color.btn6)
                        .keyboardEnable(true)
                        .init();
                break;
            }
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        mImmersionBar.keyboardEnable(true).init();
        if (mImmersionBarDialog != null)
            mImmersionBarDialog.destroy();
    }
}
