package zhaoqy.com.study.textview.reddot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.TextView;
import zhaoqy.com.study.R;

/**
 * Created by zhaoqy on 2017/9/6.
 */
public class RedDotTextView extends TextView {

    private int tipVisibility = 0;

    public RedDotTextView(Context context) {
        super(context);
        init(null);
    }

    public RedDotTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RedDotTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs,
                    R.styleable.RedDotTextView);
            tipVisibility = array.getInt(
                    R.styleable.RedDotTextView_redDotVisibility, 0);
            array.recycle();
        }
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (tipVisibility == 0) {
            int width = getWidth();
            int paddingRight = getPaddingRight();
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setStyle(Style.FILL_AND_STROKE);
            /**
             * 红点的半径：paddingRight / 2
             */
            canvas.drawCircle(width - getPaddingRight() / 2, paddingRight / 2,
                    paddingRight / 2, paint);
        }
    }

    public void setDotVisibility(int visibility) {
        tipVisibility = visibility;
        invalidate();
    }
}
