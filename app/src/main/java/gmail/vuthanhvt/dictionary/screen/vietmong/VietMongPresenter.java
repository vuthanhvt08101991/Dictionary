package gmail.vuthanhvt.dictionary.screen.vietmong;

import android.databinding.ObservableField;
import android.util.Log;

import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class VietMongPresenter.
 */
public class VietMongPresenter implements BasePresenter {

    public static final String TAG = "VietMongPresenter";

    private VietMongView mVietMongView;

    public ObservableField<Boolean> mIsFocusableEdt = new ObservableField<>(false);

    public VietMongPresenter(VietMongView mVietMongView) {
        this.mVietMongView = mVietMongView;
        mIsFocusableEdt.set(false);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void onClickBackView() {
        Log.d(TAG, "onClickBackView: ");
        mVietMongView.onClickBackView();
    }

    public void getData() {
        Log.d(TAG, "getData: ");
        mVietMongView.loadListWords();
    }
    
    public void onClickAddView() {
        Log.d(TAG, "onClickAddView: ");
        mVietMongView.onClickAddView();
    }
}
