package gmail.vuthanhvt.dictionary.screen.addnew;

import android.content.Context;
import android.util.Log;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.screen.BaseDataBindingActivity;
import gmail.vuthanhvt.dictionary.databinding.ActivityAddNewWordBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 31/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class NewWordActivity.
 */
public class NewWordActivity extends BaseDataBindingActivity<ActivityAddNewWordBinding, NewWordPresenter>
        implements NewWordView {

    public static final String TAG = "NewWordActivity";

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_add_new_word;
    }

    @Override
    public void initData() {
        mPresenter = new NewWordPresenter(this);
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
        return null;
    }

    @Override
    public void onClickBackView() {
        Log.d(TAG, "onClickBackView: ");
        onBackPressed();
    }
}
