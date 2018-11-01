package gmail.vuthanhvt.dictionary.base.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.widget.Spinner;

import java.lang.reflect.Field;

public class CustomSpinner extends AppCompatSpinner {
    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(Context context, int mode) {
        super(context, mode);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    @Override
    public boolean performClick() {
        final boolean superResult = super.performClick();

        try {
            final Field mPopupField = Spinner.class.getDeclaredField("mPopup");
            mPopupField.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow =
                    (android.widget.ListPopupWindow) mPopupField.get(this);

            // Set popupWindow height to 500px
            popupWindow.setHeight(500);
        } catch (Exception e) {
        }

        return superResult;
    }
}
