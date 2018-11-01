package gmail.vuthanhvt.dictionary.screen.main;

import android.app.Fragment;

import java.util.List;

import gmail.vuthanhvt.dictionary.base.screen.BaseView;
import gmail.vuthanhvt.dictionary.data.MenuItem;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Interface MainView.
 */
public interface MainView extends BaseView<MainPresenter> {

    void menuChange(List<MenuItem> menuItems);
}
