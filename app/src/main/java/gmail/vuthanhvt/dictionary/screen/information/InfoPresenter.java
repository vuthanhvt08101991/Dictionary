package gmail.vuthanhvt.dictionary.screen.information;

import android.content.Intent;

import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;
import gmail.vuthanhvt.dictionary.screen.main.MainAvtivity;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class InfoPresenter.
 */
public class InfoPresenter implements BasePresenter {

    private InfoView mInfoView;

    public InfoPresenter(InfoView mInfoView) {
        this.mInfoView = mInfoView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void onClickBackView() {
        mInfoView.onClickBackView();
    }
}
