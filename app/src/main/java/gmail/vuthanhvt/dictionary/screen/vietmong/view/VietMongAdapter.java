package gmail.vuthanhvt.dictionary.screen.vietmong.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import gmail.vuthanhvt.dictionary.base.adapter.BaseRecyclerViewAdapterBinding;
import gmail.vuthanhvt.dictionary.base.adapter.BaseViewHolderBinding;
import gmail.vuthanhvt.dictionary.data.model.MongViet;
import gmail.vuthanhvt.dictionary.databinding.ItemVietmongBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class VietMongAdapter.
 */
public class VietMongAdapter
        extends BaseRecyclerViewAdapterBinding<VietMongAdapter.VietMongHolder, MongViet> {

    public static final String TAG = "VietMongAdapter";

    private List<MongViet> mList;

    private OnLongClickListener mLongClickListener;

    public void setLongClickListener(OnLongClickListener mListener) {
        this.mLongClickListener = mListener;
    }

    public VietMongAdapter(Context context) {
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
    protected VietMongHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new VietMongHolder(ItemVietmongBinding.inflate(inflater, parent, false));
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
        ((VietMongHolder) holder).bindData(item);
    }

    class VietMongHolder extends BaseViewHolderBinding<ItemVietmongBinding, MongViet> {

        public VietMongHolder(ItemVietmongBinding binding) {
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
