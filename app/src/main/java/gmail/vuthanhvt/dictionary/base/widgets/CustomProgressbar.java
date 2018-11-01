package gmail.vuthanhvt.dictionary.base.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class CustomProgressbar extends ProgressBar {

    private OnValueChangeListener mOnValueChangeListener;

    public void setOnValueChangeListener(OnValueChangeListener onValueChangeListener) {
        mOnValueChangeListener = onValueChangeListener;
    }

    public CustomProgressbar(Context context) {
        super(context);
    }

    public CustomProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        if (mOnValueChangeListener != null) {
            mOnValueChangeListener.onValueChange(progress);
        }
    }

    public interface OnValueChangeListener {
        void onValueChange(int value);
    }
}
