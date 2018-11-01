package gmail.vuthanhvt.dictionary.base.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import gmail.vuthanhvt.dictionary.base.screen.BaseActivity;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BaseFragment.
 */

public class BaseFragment extends Fragment {

    private boolean isBaseActivity() {
        return getActivity() != null
                && !getActivity().isFinishing()
                && getActivity() instanceof BaseActivity;
    }

    public BaseActivity getBaseActivity() {
        if (!isBaseActivity()) {
            return null;
        } else {
            return (BaseActivity) getActivity();
        }
    }

    public void showOrHideDialog(final boolean isShow) {
        if (getBaseActivity() == null) {
            return;
        }
        getBaseActivity().showOrHideDialog(isShow);
    }

    public boolean onBackPressed() {
        return false;
    }
}
