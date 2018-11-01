package gmail.vuthanhvt.dictionary.screen.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.adapter.BaseRecyclerViewAdapterBinding;
import gmail.vuthanhvt.dictionary.base.screen.BaseDataBindingActivity;
import gmail.vuthanhvt.dictionary.constant.MenuType;
import gmail.vuthanhvt.dictionary.data.MenuItem;
import gmail.vuthanhvt.dictionary.databinding.ActivityMainBinding;
import gmail.vuthanhvt.dictionary.screen.main.adapter.MenuAdapter;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MainAvtivity.
 */
public class MainAvtivity extends BaseDataBindingActivity<ActivityMainBinding, MainPresenter>
        implements MainView {

    public static final String TAG = "MainAvtivity";

    private MenuAdapter mMenuAdapter;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mPresenter = new MainPresenter(this);
        mMenuAdapter = new MenuAdapter(context(), new ArrayList<MenuItem>());
        mMenuAdapter.setItemListener(new BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<MenuItem>() {
            @Override
            public void onItemClick(int position, MenuItem data) {
                switch (data.getType()) {
                    case MenuType.VietMong:
                        mPresenter.clickButtonVietMong();
                        break;

                    case MenuType.MongViet:
                        mPresenter.clickButtonMongViet();
                        break;

                    case MenuType.Character:
                        mPresenter.clickButtonCharacter();
                        break;

                    case MenuType.History:
                        mPresenter.clickButtonHistory();
                        break;

                    default:
                        break;
                }
            }
        });
        mBinding.setAdapter(mMenuAdapter);
        mPresenter.addMenuItems();
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
    public void menuChange(List<MenuItem> menuItems) {
        Log.d(TAG, "menuChange: ");
        mMenuAdapter.refreshData(menuItems);
    }
}
