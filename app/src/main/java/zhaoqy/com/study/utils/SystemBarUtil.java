package zhaoqy.com.study.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import zhaoqy.com.study.R;

/**
 * Created by zhaoqy on 2017/8/23.
 */

public class SystemBarUtil {

    /**
     * 实现沉浸式状态栏步骤：
     * 1. 在需要实现沉浸式状态栏的Activity的布局中添加以下参数
     * android:fitsSystemWindows="true"
     * android:clipToPadding="true"
     * 2. 在Activity的setContentView()方法后面调用setSystemBar方法
     */

    /**
     * 设置沉浸式状态栏
     *
     * @param activity
     */
    public static void setSystemBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //window.setStatusBarColor(Color.parseColor("#3F51B5"));//可以自定义状态栏颜色
            window.setStatusBarColor(activity.getResources().getColor(R.color.colorTitle));
        }
    }

    /**
     * @param activity
     * @return > 0 success; <= 0 fail
     */
    public static int getStatusHeight(Activity activity) {
        int statusHeight = 0;
        Rect localRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        statusHeight = localRect.top;
        if (0 == statusHeight) {
            Class<?> localClass;
            try {
                localClass = Class.forName("com.android.internal.R$dimen");
                Object localObject = localClass.newInstance();
                int i5 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
                statusHeight = activity.getResources().getDimensionPixelSize(i5);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IllegalArgumentException | SecurityException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return statusHeight;
    }
}
