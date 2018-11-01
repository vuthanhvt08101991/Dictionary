package gmail.vuthanhvt.dictionary.screen.mongviet;

import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;
import gmail.vuthanhvt.dictionary.screen.addnew.NewWordActivity;

/**
 * Create by FRAMGIA\vu.anh.thanh on 26/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MongVietPresenter.
 */
public class MongVietPresenter implements BasePresenter {

    public static final String TAG = "VietMongPresenter";

    private MongVietView mVietMongView;

    public ObservableField<Boolean> mIsFocusableEdt = new ObservableField<>(false);

    public MongVietPresenter(MongVietView mVietMongView) {
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

    public void onClickAddView() {
        Log.d(TAG, "onClickAddView: ");
        mVietMongView.onClickAddView();
    }

    public void getData() {
        Log.d(TAG, "getData: ");
        mVietMongView.loadListWords();
    }
}
