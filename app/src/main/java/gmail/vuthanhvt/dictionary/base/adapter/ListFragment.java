package gmail.vuthanhvt.dictionary.base.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.fragment.BaseDataBindingFragment;
import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;
import gmail.vuthanhvt.dictionary.constant.FragmentListType;
import gmail.vuthanhvt.dictionary.databinding.FragmentListBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BaseDataBindingDialogFragment.
 */
public abstract class ListFragment<T>
        extends BaseDataBindingFragment<FragmentListBinding, BasePresenter> {

    private int column = 2;

    private LinearLayoutManager mLayoutManager;

    private BaseRecyclerViewAdapterBinding<BaseViewHolderBinding, T> mAdapter;

    private BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<T> mItemListener;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initData() {
        switch (getTypeList()) {
            case FragmentListType.TYPE_LIST:
                mLayoutManager = new LinearLayoutManager(getActivity());
                break;
            case FragmentListType.TYPE_GRID:
                mLayoutManager = new GridLayoutManager(getActivity(), column);
                break;
        }
        mBinding.list.setLayoutManager(mLayoutManager);
        mBinding.list.setHasFixedSize(true);
        setAdapter(mBinding.list);
        mAdapter = (BaseRecyclerViewAdapterBinding) mBinding.list.getAdapter();
        mAdapter.setItemListener(new BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<T>() {
            @Override
            public void onItemClick(int position, T data) {
                if (mItemListener != null) {
                    mItemListener.onItemClick(position, data);
                }
                ListFragment.this.onItemClick(position, data);
            }
        });
    }

    void setBackground(int color) {
        mBinding.container.setBackgroundColor(color);
    }

    public void setColumn(int column) {
        this.column = column;
        if (mLayoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) mLayoutManager).setSpanCount(column);
            if (mAdapter != null) {
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setItemListener(
            BaseRecyclerViewAdapterBinding.OnRecyclerItemListener<T> itemListener) {
        mItemListener = itemListener;
    }

    protected abstract void setAdapter(RecyclerView list);

    protected abstract int getTypeList();

    public abstract void onItemClick(int position, T t);
}
