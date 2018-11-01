package gmail.vuthanhvt.dictionary.screen.mongviet;

import gmail.vuthanhvt.dictionary.base.screen.BaseView;

/**
 * Create by FRAMGIA\vu.anh.thanh on 26/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MongVietView.
 */
public interface MongVietView extends BaseView<MongVietPresenter> {

    void onClickBackView();

    void loadListWords();

    void onClickAddView();
}
