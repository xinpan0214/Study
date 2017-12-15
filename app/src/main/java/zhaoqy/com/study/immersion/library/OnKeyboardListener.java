package zhaoqy.com.study.immersion.library;

/**
 * 软键盘监听
 * Created by zhaoqy on 2017/9/8.
 */
public interface OnKeyboardListener {
    /**
     * On keyboard change.
     *
     * @param isPopup        the is popup  是否弹出
     * @param keyboardHeight the keyboard height  软键盘高度
     */
    void onKeyboardChange(boolean isPopup, int keyboardHeight);
}
