package gmail.vuthanhvt.dictionary.base.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import gmail.vuthanhvt.dictionary.BR;
import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;


/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BaseFragment.
 */
public abstract class BaseDataBindingFragmentSwipeBack<V extends ViewDataBinding, P extends
        BasePresenter> extends SwipeBackFragment {

    public V mBinding;

    protected P mPresenter;

    public abstract int getContentViewLayoutId();

    protected abstract void initData();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding =
                DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getContentViewLayoutId(),
                        null, false);
        setView(mBinding.getRoot());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        mBinding.setVariable(BR.presenter, mPresenter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.subscribe();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    public void onCreateFragment() {

    }
}
