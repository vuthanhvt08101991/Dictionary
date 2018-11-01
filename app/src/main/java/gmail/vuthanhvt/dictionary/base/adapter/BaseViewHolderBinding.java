package gmail.vuthanhvt.dictionary.base.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class BaseDataBindingDialogFragment.
 */
public class BaseViewHolderBinding<T extends ViewDataBinding, K> extends RecyclerView.ViewHolder {

    public T mBinding;

    public BaseRecyclerViewAdapterBinding.OnRecyclerItemListener mListener;

    private K data;

    public BaseViewHolderBinding(T binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public BaseViewHolderBinding(T binding,
            BaseRecyclerViewAdapterBinding.OnRecyclerItemListener listener) {
        super(binding.getRoot());
        mBinding = binding;
        mListener = listener;
        mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(getAdapterPosition(), data);
                }
            }
        });
    }

    public void bindData(K k) {
        data = k;
    }
}
