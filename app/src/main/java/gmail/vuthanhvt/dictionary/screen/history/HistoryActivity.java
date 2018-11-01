package gmail.vuthanhvt.dictionary.screen.history;

import android.content.Context;
import android.util.Log;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.screen.BaseDataBindingActivity;
import gmail.vuthanhvt.dictionary.databinding.ActivityHistoryBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 31/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class HistoryActivity.
 */
public class HistoryActivity extends BaseDataBindingActivity<ActivityHistoryBinding, HistoryPresenter>
        implements HistoryView {

    public static final String TAG = "HistoryActivity";

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    public void initData() {
        mPresenter = new HistoryPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onClickBackView() {
        Log.d(TAG, "onClickBackView: ");
        onBackPressed();
    }
}
