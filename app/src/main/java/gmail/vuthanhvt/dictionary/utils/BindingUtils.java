package gmail.vuthanhvt.dictionary.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.annotation.DimenRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.widgets.CustomTextView;
import gmail.vuthanhvt.dictionary.base.widgets.GridSpacingItemDecoration;
import gmail.vuthanhvt.dictionary.constant.Constants;

public class BindingUtils {

    /***
     * Set adapter for recyclerview
     * @param recyclerView
     * @param adapter
     * @param columns
     * @param orientation
     * @param itemDecoration
     */
    @BindingAdapter(value = {
            "adapter", "columns", "orientation", "itemDecoration", "space", "includeEdge", "reverse"
    }, requireAll = false)
    public static void setRecyclerViewData(RecyclerView recyclerView, RecyclerView.Adapter adapter,
                                           int columns, int orientation, RecyclerView.ItemDecoration itemDecoration,
                                           @DimenRes int space, boolean includeEdge, boolean isReverse) {
        boolean isGrid = columns > 1;
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager;
        Context context = recyclerView.getContext();
        if (isGrid) {
            layoutManager = new GridLayoutManager(context, columns);
            itemDecoration =
                    new GridSpacingItemDecoration(context, columns, space, includeEdge, false);
        } else {

            layoutManager = new LinearLayoutManager(context,
                    orientation == context.getResources().getInteger(R.integer.vertical)
                            ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL, false);
            ((LinearLayoutManager) layoutManager).setReverseLayout(isReverse);
        }
        if (itemDecoration != null) {
            recyclerView.addItemDecoration(itemDecoration);
        }
        recyclerView.setLayoutManager(layoutManager);
    }

    @BindingAdapter("imageBitmap")
    public static void setImageBitmap(ImageView imageView, Bitmap bitmap) {
        if (bitmap == null) return;
        imageView.setImageBitmap(bitmap);
    }

    /***
     * set error for input text
     * @param textView
     * @param error
     */
    @BindingAdapter("error")
    public static void setTextError(EditText textView, CharSequence error) {
        textView.setError(error);
    }

    /***
     * request focus for edittext
     * @param textView
     * @param isFocus
     */
    @BindingAdapter("requestFocus")
    public static void requestFocus(EditText textView, boolean isFocus) {
        if (!isFocus) {
            return;
        }
        textView.requestFocus();
    }

    @BindingAdapter({ "selected" })
    public static void setSelected(View view, boolean isSelected) {
        view.setSelected(isSelected);
    }

    @BindingAdapter({ "isUnderline" })
    public static void setTextUnderLine(TextView textView, boolean isUnderline) {
        if (isUnderline) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }
    }

    @BindingAdapter({ "maxChar" })
    public static void setMaxChar(TextView textView, int numOfChar) {
        String text = textView.getText().toString();
        if (text.length() > 20) {
            text = text.substring(0, numOfChar) + "...";
            textView.setText(text);
        }
    }

    @BindingAdapter(value = { "gravity" }, requireAll = false)
    public static void setGravity(LinearLayout linearLayout, int gravity) {
        linearLayout.setGravity(gravity);
    }

    @BindingAdapter(value = { "ellipsize" }, requireAll = false)
    public static void ellipsize(CustomTextView textView, boolean isEllipsize) {
        if (isEllipsize) {
            textView.setLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @BindingAdapter({ "clickSafe" })
    public static void setClickSafe(View view, final View.OnClickListener listener) {
        view.setOnClickListener(new View.OnClickListener() {
            private long mLastClickTime = 0;

            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime
                        < 1000) {
                    return;
                }
                if (listener != null) listener.onClick(v);
                mLastClickTime = SystemClock.elapsedRealtime();
            }
        });
    }

}
