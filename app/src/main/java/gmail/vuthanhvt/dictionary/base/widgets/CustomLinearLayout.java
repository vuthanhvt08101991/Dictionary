package gmail.vuthanhvt.dictionary.base.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import gmail.vuthanhvt.dictionary.listener.OnMeasureChange;

public class CustomLinearLayout extends LinearLayout {

    private OnMeasureChange mOnMeasureChange;

    public void setOnMeasureChange(OnMeasureChange onMeasureChange) {
        mOnMeasureChange = onMeasureChange;
    }

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mOnMeasureChange!=null){
            mOnMeasureChange.onMesure(widthMeasureSpec,heightMeasureSpec);
        }
    }
}
