package gmail.vuthanhvt.dictionary.base.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


public class ScaleImageView extends android.support.v7.widget.AppCompatImageView {

    public ScaleImageView(Context context) {
        super(context);
    }

    public ScaleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = w * 9 / 24;
        setMeasuredDimension(w, h);
    }
}
