package gmail.vuthanhvt.dictionary.screen.vietmong.view;

import android.content.Context;
import android.support.annotation.NonNull;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.view.BaseDialog;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class LoadingDialog.
 */
public class LoadingDialog extends BaseDialog {

    public LoadingDialog(@NonNull Context context, boolean isFull) {
        super(context, isFull);
    }

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.dialog_loading;
    }
}
