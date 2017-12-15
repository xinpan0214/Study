package zhaoqy.com.study.immersion.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import zhaoqy.com.study.R;
import zhaoqy.com.study.immersion.base.BaseActivity;

import static android.view.KeyEvent.KEYCODE_BACK;

public class BlogActivity extends BaseActivity {

    WebView mWebView;
    private String blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        blog = getIntent().getBundleExtra("bundle").getString("blog");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_blog;
    }

    @Override
    protected void initViews() {
        mWebView = (WebView) findViewById(R.id.web);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        if (blog.equals("github")) {
            mImmersionBar.fitsSystemWindows(true).statusBarColor(
                    R.color.github_color).init();
        } else {
            mImmersionBar.fitsSystemWindows(true).statusBarColorInt(Color.WHITE)
                    .statusBarDarkFont(true, 0.2f).init();
        }
    }

    @Override
    protected void initData() {
        if (blog.equals("github")) {
            mWebView.loadUrl("https://github.com/zhaoqingyue");
        } else if (blog.equals("jianshu")){
            mWebView.loadUrl("http://www.jianshu.com/users/b56b76abb6b6/timeline");
        } else if (blog.equals("bokeyuan")){
            mWebView.loadUrl("http://www.cnblogs.com/zhaoqingyue/");
        }

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (mWebView != null) {
                mWebView.removeAllViews();
                mWebView.destroy();
                mWebView = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
