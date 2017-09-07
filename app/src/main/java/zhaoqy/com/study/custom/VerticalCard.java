package zhaoqy.com.study.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import zhaoqy.com.study.R;

/**
 * Created by zhaoqy on 2017/8/22.
 */

public class VerticalCard extends LinearLayout implements View.OnClickListener{

    private TextView mTitle;
    private String title;
    private int title_color;
    private int bg_color;

    private IVCListener mListener;

    public interface IVCListener {
        public void onVcClick(View view);
    }

    public void setOnVCListener(IVCListener listener) {
        mListener = listener;
    }

    public VerticalCard(Context context) {
        super(context);
    }

    @SuppressLint("Recycle")
    public VerticalCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleTypedArray(context, attrs);
        initView(context);
    }

    private void handleTypedArray(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.VerticalCard);
        title = typedArray.getString(R.styleable.VerticalCard_vc_title);
        int def_color = getResources().getColor(R.color.colorBlack);
        title_color = typedArray.getColor(
                R.styleable.VerticalCard_vc_title_color, def_color);
        bg_color = typedArray.getColor(
                R.styleable.VerticalCard_vc_bg_color, def_color);
        typedArray.recycle();
    }

    private void initView(Context context) {
        inflate(context, R.layout.layout_vertical_card, this);
        /**
         * 设置标题
         */
        mTitle = (TextView) findViewById(R.id.vc_title);
        mTitle.setText(title);
        mTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vc_title: {
                if (mListener != null) {
                    mListener.onVcClick(this);
                }
                break;
            }
        }
    }
}
