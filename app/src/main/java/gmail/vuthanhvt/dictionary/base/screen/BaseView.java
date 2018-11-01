package gmail.vuthanhvt.dictionary.base.screen;

import android.content.Context;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface BaseView.
 */
public interface BaseView<P extends BasePresenter> {

    void showLoading();

    void hideLoading();

    void showError();

    Context context();
}
