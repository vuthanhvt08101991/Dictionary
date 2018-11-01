package gmail.vuthanhvt.dictionary.screen.history;

import android.util.Log;

import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;

/**
 * Create by FRAMGIA\vu.anh.thanh on 31/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class HistoryPresenter.
 */
public class HistoryPresenter implements BasePresenter {

    public static final String TAG = "HistoryPresenter";

    private HistoryView mHistoryView;

    public HistoryPresenter(HistoryView mHistoryView) {
        this.mHistoryView = mHistoryView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void onClickBackView() {
        Log.d(TAG, "onClickBackView: ");
        mHistoryView.onClickBackView();
    }
}
