package gmail.vuthanhvt.dictionary.screen.character;

import gmail.vuthanhvt.dictionary.base.screen.BaseView;

/**
 * Create by FRAMGIA\vu.anh.thanh on 29/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface CharacterView.
 */
public interface CharacterView extends BaseView<CharacterPresenter> {

    void onClickBackView();

    void onClickMenuView();

    void loadData(int type);
}
