package gmail.vuthanhvt.dictionary.screen.addnew;

import android.util.Log;

import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;

/**
 * Create by FRAMGIA\vu.anh.thanh on 31/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class NewWordPresenter.
 */
public class NewWordPresenter implements BasePresenter {

    public static final String TAG = "NewWordPresenter";

    private NewWordView mNewWordView;

    public NewWordPresenter(NewWordView mNewWordView) {
        this.mNewWordView = mNewWordView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
    
    public void onClickBackView() {
        Log.d(TAG, "onClickBackView: ");
        mNewWordView.onClickBackView();
    }
}
