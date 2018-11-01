package gmail.vuthanhvt.dictionary.screen.mongviet.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gmail.vuthanhvt.dictionary.base.adapter.BaseRecyclerViewAdapterBinding;
import gmail.vuthanhvt.dictionary.base.adapter.BaseViewHolderBinding;
import gmail.vuthanhvt.dictionary.data.model.MongViet;
import gmail.vuthanhvt.dictionary.databinding.ItemMongvietBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 26/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MongVietAdapter.
 */
public class MongVietAdapter extends BaseRecyclerViewAdapterBinding<MongVietAdapter.MongVietHolder, MongViet> {

    public static final String TAG = "VietMongAdapter";

    private List<MongViet> mList;

    private OnLongClickListener mLongClickListener;

    public void setLongClickListener(OnLongClickListener mListener) {
        this.mLongClickListener = mListener;
    }

    public MongVietAdapter(Context context) {
        super(context);
        mList = new ArrayList<>();
    }

    public void refreshDataView(List<MongViet> list) {
        Log.d(TAG, "refreshDataView: list.size() = " + list.size());
        mList.clear();
        mList.addAll(list);
        refreshData(mList);
    }

    @Override
    protected MongVietHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new MongVietHolder(ItemMongvietBinding.inflate(inflater, parent, false));
    }

    @Override
    public BaseViewHolderBinding onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolderBinding viewHolderBinding = null;
        viewHolderBinding = getViewHolder(parent, LayoutInflater.from(parent.getContext()));
        return viewHolderBinding;
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        Log.d("ThanhVA", "onBindViewHolder: position = " + position);
        MongViet item = mList.get(position);
        ((MongVietHolder) holder).bindData(item);
    }

    class MongVietHolder extends BaseViewHolderBinding<ItemMongvietBinding, MongViet> {

        public MongVietHolder(ItemMongvietBinding binding) {
            super(binding);
        }

        public void bindData(final MongViet item) {
            super.bindData(item);
            mBinding.setItem(item);
            mBinding.setOnLongClick(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mLongClickListener != null) {
                        mLongClickListener.onLongClick(item);
                    }
                    return false;
                }
            });
        }
    }

    public interface OnLongClickListener {
        void onLongClick(MongViet item);
    }
}
