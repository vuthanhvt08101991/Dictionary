package gmail.vuthanhvt.dictionary.screen.information;

import android.content.Context;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.screen.BaseDataBindingActivity;
import gmail.vuthanhvt.dictionary.databinding.ActivityMainBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class InfoActivity.
 */
public class InfoActivity extends BaseDataBindingActivity<ActivityMainBinding, InfoPresenter>
        implements InfoView {

    public static final String TAG = "InfoActivity";

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_info;
    }

    @Override
    public void initData() {
        mPresenter = new InfoPresenter(this);
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
        onBackPressed();
    }
}
