package gmail.vuthanhvt.dictionary.screen.vietmong;

import gmail.vuthanhvt.dictionary.base.screen.BaseView;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface VietMongView.
 */
public interface VietMongView extends BaseView<VietMongPresenter> {

    void onClickBackView();

    void loadListWords();

    void onClickAddView();
}
